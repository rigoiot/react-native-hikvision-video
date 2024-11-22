package com.rigoiot.hikvideo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hikvision.netsdk.ExceptionCallBack;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_DEVICEINFO_V30;
import com.hikvision.netsdk.NET_DVR_PREVIEWINFO;
import com.hikvision.netsdk.RealPlayCallBack;
import com.hikvision.netsdk.PTZCommand;
import com.hikvision.netsdk.NET_DVR_TIME;
import com.hikvision.netsdk.PlaybackCallBack;
import com.hikvision.netsdk.NET_DVR_FILECOND;
import com.hikvision.netsdk.NET_DVR_FINDDATA_V30;
import com.hikvision.netsdk.NET_DVR_VOD_PARA;
import com.hikvision.netsdk.PlaybackControlCommand;

import org.MediaPlayer.PlayM4.Player;

import java.util.Calendar;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

/**
 * Created date: 2017/4/11
 * Author:  Leslie
 * 使用海康SDK播放视频流的工具类.
 * 前提：1->/libs/下放入：AudioEngineSDK.jar,HCNetSDK.jar,PlayerSDK.jar
 * 2->/src/main/jniLibs/下放入：很多 .so 文件.
 * 3->添加网络权限
 * 目前只处理海康摄像头(室内枪型网络摄像机-【型号：DS-2CD5026EFWD】-【软件版本：V5.4.5_170222】)
 * 但是该例子不仅限于这种型号的。
 * 使用方法[由于要预览 2 路，所以很多静态方法，静态变量去掉了，调用流程也变化了]：
 * 1.HikUtil.initSDK();
 * 2.HikUtil hikUtil = new HikUtil();
 * 2.hikUtil.initView(surfaceView);
 * 3.hikUtil.setDeviceData("192.168.1.22",8000,"admin","eyecool2016");
 * 4.hikUtil.loginDevice(mHandler,LOGIN_SUCCESS_CODE);
 * 5.hikUtil.playOrStopStream();
 */

public class HikUtil {
    private static final String TAG = "HikUtil";
    private static final int HIK_MAIN_STREAM_CODE = 0;      //主码流
    private static final int HIK_SUB_STREAM_CODE = 1;      //子码流
    private NET_DVR_DEVICEINFO_V30 m_oNetDvrDeviceInfoV30 = null;
    private int m_iStartChan = 0;
    private int m_iPort = -1;
    private int m_iPlaybackID = -1;
    private int logId = -1;
    private int playId = -1;
    private int viewId = -1;
    private SurfaceView mSurfaceView;
    public String mIpAddress;
    private int mPort;
    private String mUserName;
    private String mPassWord;
    private int mChannel;
    public onPicCapturedListener mPicCapturedListener;
    private SimpleDateFormat sDateFormat;
    private Player.MPInteger stWidth;
    private Player.MPInteger stHeight;
    private Player.MPInteger stSize;

    /**
     * 定义接口，用于监听图片截图成功
     */
    public interface onPicCapturedListener {
        void onPicCaptured(Bitmap bitmap, String bitmapFileAbsolutePath);

        void onPicDataSaved(byte[] picData);
    }

    public HikUtil() {
    }

    /**
     * 初始化HCNet SDK
     *
     * @return
     */
    public static boolean initSDK() {

        if (!HCNetSDK.getInstance().NET_DVR_Init()) {
            Log.e(TAG, "HCNetSDK ---------初始化失败!");
            return false;
        }
        //打印日志到本地，暂时不用打印
//        HCNetSDK.getInstance().NET_DVR_SetLogToFile(3, "/mnt/sdcard/sdklog/", true);
        return true;
    }

    public void initView(SurfaceView surfaceView, final Handler handler, final int resultCode) {
        mSurfaceView = surfaceView;
        mSurfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mSurfaceView.getHolder().setFormat(PixelFormat.TRANSLUCENT);
                // Log.i(TAG, "surface is created " + m_iPort);

                if (viewId == -1) {
                    Message message = handler.obtainMessage();
                    // message.obj = loginState;
                    message.what = resultCode;
                    handler.sendMessage(message);
                    viewId = 0;
                }

                if (-1 == m_iPort) {
                    return;
                }
                Surface surface = holder.getSurface();
                if (surface.isValid()) {
                    if (!Player.getInstance().setVideoWindow(m_iPort, 0, holder)) {
                        Log.e(TAG, "播放器设置或销毁显示区域失败! " + m_iPort);
                    } else {

                    }
                    Log.i(TAG, "surface is isValid " + m_iPort);
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.i(TAG, "Player setVideoWindow release!" + m_iPort);
                if (-1 == m_iPort) {
                    return;
                }
                if (holder.getSurface().isValid()) {
                    if (!Player.getInstance().setVideoWindow(m_iPort, 0, null)) {
                        Log.e(TAG, "播放器设置或销毁显示区域失败!");
                    }
                }
            }
        });
    }

    /**
     * 配置网络摄像头参数
     *
     * @param ipAddress IP 地址
     * @param port      端口号，默认是 8000
     * @param userName  用户名
     * @param passWord  密码
     */
    public void setDeviceData(String ipAddress, int port, String userName, String passWord, int channel) {
        mIpAddress = ipAddress;
        mPort = port;
        mUserName = userName;
        mPassWord = passWord;
        mChannel = channel;
    }

    public void loginDevice(final Handler handler, final int resultCode) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean loginState = login(mIpAddress, mPort, mUserName, mPassWord, mChannel);
                Message message = handler.obtainMessage();
                message.obj = loginState;
                message.what = resultCode;
                handler.sendMessage(message);
            }
        }).start();
    }

    /**
     * 播放或者停止播放视频流
     */
    public void playStream() {
        if (logId < 0) {
            Log.e(TAG, "请先登录设备");
            return;
        }
        if (playId < 0) {
            RealPlayCallBack fRealDataCallBack = getRealPlayerCbf();
            if (fRealDataCallBack == null) {
                Log.e(TAG, "fRealDataCallBack object is failed!");
                return;
            }

            NET_DVR_PREVIEWINFO previewInfo = new NET_DVR_PREVIEWINFO();
            previewInfo.lChannel = m_iStartChan;
            previewInfo.dwStreamType = HIK_SUB_STREAM_CODE;                                                             //子码流
            previewInfo.bBlocked = 1;
            // HCNetSDK start preview
            playId = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(logId, previewInfo, fRealDataCallBack);
            if (playId < 0) {
                Log.e(TAG, "实时预览失败!-----------------Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
                return;
            }

            Log.i(TAG, "NetSdk 播放成功 ！" + playId);
        } else {    //停止播放
            if (playId < 0) {
                Log.e(TAG, "m_iPlayID < 0");
                return;
            }

            //  net sdk stop preview
            if (!HCNetSDK.getInstance().NET_DVR_StopRealPlay(playId)) {
                Log.e(TAG, "停止预览失败!----------------错误:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
                return;
            }

            playId = -1;
            Player.getInstance().stopSound();
            // player stop play
            if (!Player.getInstance().stop(m_iPort)) {
                Log.e(TAG, "-------------------暂停失败!");
                return;
            }
            if (!Player.getInstance().closeStream(m_iPort)) {
                Log.e(TAG, "-------------------关流失败!");
                return;
            }
            if (!Player.getInstance().freePort(m_iPort)) {
                Log.e(TAG, "-------------------释放播放端口失败!" + m_iPort);
                return;
            }
            m_iPort = -1;
            // logId = -1;
            Log.i(TAG, "NetSdk 停止成功 ！" + playId);
        }
    }

    public void stopStream() {

        if (logId < 0) {
            return;
        }
        if (playId < 0) {
            return;
        }

        //  net sdk stop preview
        if (!HCNetSDK.getInstance().NET_DVR_StopRealPlay(playId)) {
            Log.e(TAG, "停止预览失败!----------------错误:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return;
        }

        playId = -1;
        Player.getInstance().stopSound();
        // player stop play
        if (!Player.getInstance().stop(m_iPort)) {
            Log.e(TAG, "-------------------暂停失败!");
            return;
        }
        if (!Player.getInstance().closeStream(m_iPort)) {
            Log.e(TAG, "-------------------关流失败!");
            return;
        }
        if (!Player.getInstance().freePort(m_iPort)) {
            Log.e(TAG, "-------------------释放播放端口失败!" + m_iPort);
            return;
        }
        m_iPort = -1;
        Log.i(TAG, "NetSdk 停止成功 ！" + playId);
    }

    public boolean findDVRFile(Calendar startTime, Calendar stopTime) {
        NET_DVR_FILECOND struFileCond = new NET_DVR_FILECOND();
        struFileCond.dwFileType = 0xFF;
        struFileCond.lChannel = m_iStartChan;
//        struFileCond.dwIsLocked = 0xFF;
//        struFileCond.dwUseCardNo = 0;

//        startDVRTime.dwYear = startTime.get(Calendar.YEAR);
//        startDVRTime.dwMonth = startTime.get(Calendar.MONTH) + 1;
//        startDVRTime.dwDay = startTime.get(Calendar.DAY_OF_MONTH);
//        startDVRTime.dwHour = startTime.get(Calendar.HOUR_OF_DAY);
//        startDVRTime.dwMinute = startTime.get(Calendar.MINUTE);
//        startDVRTime.dwSecond = startTime.get(Calendar.SECOND);

        struFileCond.struStartTime.dwYear = startTime.get(Calendar.YEAR);
        struFileCond.struStartTime.dwMonth = startTime.get(Calendar.MONTH) + 1;
        struFileCond.struStartTime.dwDay = startTime.get(Calendar.DAY_OF_MONTH);
        struFileCond.struStartTime.dwHour = startTime.get(Calendar.HOUR_OF_DAY);
        struFileCond.struStartTime.dwMinute = startTime.get(Calendar.MINUTE);
        struFileCond.struStartTime.dwSecond = startTime.get(Calendar.SECOND);

        struFileCond.struStopTime.dwYear = stopTime.get(Calendar.YEAR);
        struFileCond.struStopTime.dwMonth = stopTime.get(Calendar.MONTH) + 1;
        struFileCond.struStopTime.dwDay = stopTime.get(Calendar.DAY_OF_MONTH);
        struFileCond.struStopTime.dwHour = stopTime.get(Calendar.HOUR_OF_DAY);
        struFileCond.struStopTime.dwMinute = stopTime.get(Calendar.MINUTE);
        struFileCond.struStopTime.dwSecond = stopTime.get(Calendar.SECOND);
        //---------------------------------------
        //查找录像文件
        int lFindHandle = HCNetSDK.getInstance().NET_DVR_FindFile_V30(logId, struFileCond);
        if (lFindHandle < 0) {
            Log.e(TAG, "findDVRFile " + "find file fail");
            return false;
        }
        NET_DVR_FINDDATA_V30 struFileData = new NET_DVR_FINDDATA_V30();
        while (true) {
            int result = HCNetSDK.getInstance().NET_DVR_FindNextFile_V30(lFindHandle, struFileData);
            Log.i(TAG, "findDVRFile " + result + " " + new String(struFileData.sFileName));
            if (result == 1002) {
                continue;
            } else if (result == 1000) {
//                char strFileName[256] = {0};
//                sprintf(strFileName, "./%s", struFileData.sFileName);
                return true;
            } else if (result == 1003 || result == 1001 ) {
                break;
            } else {
                break;
            }
        }
        return false;
    }

    /**
     * 按时间回放或者停止录像
     *
     * @param startTime
     * @param stopTime
     */
    public void playNVRBack(Calendar startTime, Calendar stopTime) {

        if (logId < 0) {
            Log.e(TAG, "请先登录设备");
            return;
        }

        stopNVRBack();

        if (!findDVRFile(startTime, stopTime)){
            return;
        }

        NET_DVR_TIME startDVRTime = new NET_DVR_TIME();
        startDVRTime.dwYear = startTime.get(Calendar.YEAR);
        startDVRTime.dwMonth = startTime.get(Calendar.MONTH) + 1;
        startDVRTime.dwDay = startTime.get(Calendar.DAY_OF_MONTH);
        startDVRTime.dwHour = startTime.get(Calendar.HOUR_OF_DAY);
        startDVRTime.dwMinute = startTime.get(Calendar.MINUTE);
        startDVRTime.dwSecond = startTime.get(Calendar.SECOND);

        NET_DVR_TIME stopDVRTime = new NET_DVR_TIME();
        stopDVRTime.dwYear = stopTime.get(Calendar.YEAR);
        stopDVRTime.dwMonth = stopTime.get(Calendar.MONTH) + 1;
        stopDVRTime.dwDay = stopTime.get(Calendar.DAY_OF_MONTH);
        stopDVRTime.dwHour = stopTime.get(Calendar.HOUR_OF_DAY);
        stopDVRTime.dwMinute = stopTime.get(Calendar.MINUTE);
        stopDVRTime.dwSecond = stopTime.get(Calendar.SECOND);


        NET_DVR_VOD_PARA vodParma = new NET_DVR_VOD_PARA();
        vodParma.struBeginTime = startDVRTime;
        vodParma.struEndTime = stopDVRTime;
        vodParma.byStreamType = 0;
        vodParma.struIDInfo.dwChannel = m_iStartChan;
        vodParma.hWnd = mSurfaceView.getHolder().getSurface();

        Log.i(TAG, "playNVRBack:" + startDVRTime.ToString() + ' ' + stopDVRTime.ToString() + ' ' + m_iStartChan);

        try {
            m_iPlaybackID = HCNetSDK.getInstance().NET_DVR_PlayBackByTime_V40(logId, vodParma);

            if (m_iPlaybackID < 0) {
                Log.e(TAG, "NET_DVR_PlayBackByTime_V40! Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
                return;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            Log.e(TAG, "NET_DVR_PlayBackByTime_V40! Err:" + e);
            return;
        }

//            PlaybackCallBack fPlaybackDataCallBack = getPlayerbackPlayerCbf();
//            if (fPlaybackDataCallBack == null) {
//                Log.e(TAG, "fPlaybackDataCallBack object is failed!");
//                return;
//            }
//
//            if (!HCNetSDK.getInstance().NET_DVR_SetPlayDataCallBack(m_iPlaybackID, fPlaybackDataCallBack)) {
//                Log.e(TAG, "Set playback callback failed!");
//                return;
//            }

        // NET_DVR_PLAYBACK_INFO struPlaybackInfo = null;
        if (!HCNetSDK.getInstance().NET_DVR_PlayBackControl_V40(m_iPlaybackID, PlaybackControlCommand.NET_DVR_PLAYSTART, null, 0, null)) {
            Log.e(TAG, "NET_DVR_PlayBackControl_V40 failed, error code: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return;
        }

        // Thread thread = new Thread() {
        //     public void run() {
        //         int nProgress = -1;
        //         while (true) {
        //             nProgress = HCNetSDK.getInstance().NET_DVR_GetPlayBackPos(m_iPlaybackID);
        //             System.out.println("NET_DVR_GetPlayBackPos:" + nProgress);
        //             if (nProgress < 0 || nProgress >= 100) {
        //                 break;
        //             }
        //             try {
        //                 Thread.sleep(1000);
        //             } catch (InterruptedException e) {
        //                 // TODO Auto-generated catch block
        //                 e.printStackTrace();
        //             }
        //         }
        //     }
        // };
        // thread.start();

        Log.i(TAG, "playNVRBack sucess ！" + m_iPlaybackID);
    }

    /**
     * 播放控制
     *
     * @param dwControlCode 1开始播放、3暂停播放、4恢复播放、5快放、6慢放、
     */
    public void controlNVRBack(int dwControlCode) {

        if (logId < 0 || m_iPlaybackID < 0) {
            return;
        }

        if (!HCNetSDK.getInstance().NET_DVR_PlayBackControl_V40(m_iPlaybackID, dwControlCode, null, 0, null)) {
            Log.e(TAG, "ControlNVRBack failed, error code: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return;
        }
        Log.i(TAG, "ControlNVRBack success " + dwControlCode);
    }

    /**
     * 停止播放
     */
    public void stopNVRBack() {
        if (logId < 0 || m_iPlaybackID < 0) {
            return;
        }
        if (!HCNetSDK.getInstance().NET_DVR_StopPlayBack(m_iPlaybackID)) {
            Log.e(TAG, "NET_DVR_StopPlayBack failed");
        }
        m_iPlaybackID = -1;

        // Player.getInstance().stopSound();
        // // player stop play
        // if (!Player.getInstance().stop(m_iPort)) {
        //     Log.e(TAG, "-------------------暂停失败!");
        // }
        // if (!Player.getInstance().closeStream(m_iPort)) {
        //     Log.e(TAG, "-------------------关流失败!");
        // }
        // if (!Player.getInstance().freePort(m_iPort)) {
        //     Log.e(TAG, "-------------------释放播放端口失败!" + m_iPort);
        // }
        // m_iPort = -1;

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Log.i(TAG, "stopNVRBack success");
    }


    private RealPlayCallBack getRealPlayerCbf() {
        RealPlayCallBack cbf = new RealPlayCallBack() {
            public void fRealDataCallBack(int iRealHandle, int iDataType, byte[] pDataBuffer, int iDataSize) {
                //    Log.i(TAG, "RealPlayCallBack "+ iRealHandle + " " + iDataType+ " " + iDataSize);
                processRealData(iRealHandle, iDataType, pDataBuffer, iDataSize, Player.STREAM_REALTIME);
            }
        };
        return cbf;
    }

    private PlaybackCallBack getPlayerbackPlayerCbf() {
        PlaybackCallBack cbf = new PlaybackCallBack() {
            @Override
            public void fPlayDataCallBack(int iRealHandle, int iDataType, byte[] pDataBuffer, int iDataSize) {
                Log.i(TAG, "PlaybackCallBack " + iRealHandle + " " + iDataType + " " + iDataSize);
                processRealData(iRealHandle, iDataType, pDataBuffer, iDataSize, Player.STREAM_REALTIME);
            }
        };
        return cbf;
    }


    public void processRealData(int iPlayViewNo, int iDataType, byte[] pDataBuffer, int iDataSize, int iStreamMode) {
        if (HCNetSDK.NET_DVR_SYSHEAD == iDataType) {
            if (m_iPort >= 0) {
                return;
            }
            m_iPort = Player.getInstance().getPort();
            if (m_iPort == -1) {
                Log.e(TAG, "获取端口失败！: " + Player.getInstance().getLastError(m_iPort));
                return;
            }
            Log.i(TAG, "获取端口成功！: " + m_iPort + " " + iDataSize);
            if (iDataSize > 0) {
                if (!Player.getInstance().setStreamOpenMode(m_iPort, iStreamMode))  //set stream mode
                {
                    Log.e(TAG, "设置流播放模式失败！");
                    return;
                }
                if (!Player.getInstance().openStream(m_iPort, pDataBuffer, iDataSize, 20 * 1024 * 1024)) //open stream
                {
                    Log.e(TAG, "打开流失败！");
                    return;
                }
                if (!Player.getInstance().play(m_iPort, mSurfaceView.getHolder())) {
                    Log.e(TAG, "播放失败！");
                    return;
                }
                if (!Player.getInstance().playSound(m_iPort)) {
                    Log.e(TAG, "以独占方式播放音频失败！失败码 :" + Player.getInstance().getLastError(m_iPort));
                    return;
                }
            }
        } else {
            if (!Player.getInstance().inputData(m_iPort, pDataBuffer, iDataSize)) {
//                Log.e(TAG, "inputData failed with: " + Player.getInstance().getLastError(m_iPort));
                for (int i = 0; i < 4000 && m_iPlaybackID >= 0; i++) {
                    if (!Player.getInstance().inputData(m_iPort, pDataBuffer, iDataSize)) {
                        Log.e(TAG, "输入流数据失败: " + Player.getInstance().getLastError(m_iPort));
                    } else
                        break;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }


    private boolean login(String ipAddress, int portNum, String userName, String passWord, int channel) {
        try {
            if (logId < 0) {
                // 登录设备
                logId = loginDevice(ipAddress, portNum, userName, passWord, channel);
                if (logId < 0) {
                    Log.e(TAG, "设备登录失败！");
                    return false;
                }
                // 获取异常回调和异常设置的回调
                ExceptionCallBack oexceptionCbf = getExceptiongCbf();
                if (oexceptionCbf == null) {
                    Log.e(TAG, "异常回调对象失败！");
                    return false;
                }

                if (!HCNetSDK.getInstance().NET_DVR_SetExceptionCallBack(oexceptionCbf)) {
                    Log.e(TAG, "注册接收异常、重连消息回调函数失败 !");
                    return false;
                }

                Log.i(TAG, "登录成功 ！");
                return true;
            } else {
                // 是否登出
                if (!HCNetSDK.getInstance().NET_DVR_Logout_V30(logId)) {
                    Log.e(TAG, " 用户注销失败!");
                    return false;
                }

                logId = -1;
                return true;
            }
        } catch (Exception err) {
            Log.e(TAG, "错误: " + err.toString());
            return false;
        }
    }

    private int loginDevice(String ipAddress, int portNum, String userName, String passWord, int channel) {
        //实例化设备信息对象
        m_oNetDvrDeviceInfoV30 = new NET_DVR_DEVICEINFO_V30();
        if (null == m_oNetDvrDeviceInfoV30) {
            Log.e(TAG, "实例化设备信息(NET_DVR_DEVICEINFO_V30)失败!");
            return -1;
        }
        // call NET_DVR_Login_v30 to login on, port 8000 as default
        int iLogID = HCNetSDK.getInstance().NET_DVR_Login_V30(ipAddress, portNum, userName, passWord, m_oNetDvrDeviceInfoV30);
        if (iLogID < 0) {
            Log.e(TAG, "网络设备登录失败!-------------Err:" + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return -1;
        }

        if (channel == 0) {
            if (m_oNetDvrDeviceInfoV30.byChanNum > 0) {
                m_iStartChan = m_oNetDvrDeviceInfoV30.byStartChan;
            } else if (m_oNetDvrDeviceInfoV30.byIPChanNum > 0) {
                m_iStartChan = m_oNetDvrDeviceInfoV30.byStartDChan;
            }
        } else {
            m_iStartChan = channel;
        }

        Log.i(TAG, "网络设备登录成功! " + channel);

        return iLogID;
    }

    private ExceptionCallBack getExceptiongCbf() {
        ExceptionCallBack oExceptionCbf = new ExceptionCallBack() {
            public void fExceptionCallBack(int iType, int iUserID, int iHandle) {
                System.out.println("recv exception------------------------------, type:" + iType);
            }
        };
        return oExceptionCbf;
    }

    public boolean logout() {
        if (logId >= 0) {
            if (!HCNetSDK.getInstance().NET_DVR_Logout_V30(logId)) {
                Log.e(TAG, " 用户注销失败!");
                return false;
            }

            HCNetSDK.getInstance().NET_DVR_Cleanup();

            logId = -1;
            Log.i(TAG, " 用户注销成功!");
            return true;
        }
        return false;
    }

    /**
     * 截取一帧图片,成功返回bitmap对象，失败返回null
     * 经测试得出：
     * 获取截图数据耗时 <10ms
     * 获取截图数据后保存到磁盘耗时 ≈25ms
     * 从获取截图数-保存到磁盘-解码文件到 bitmap 耗时 ≈45ms
     */
    public Bitmap captureFrame(onPicCapturedListener picCapturedListener) {
        try {
            long time1 = System.currentTimeMillis();
            mPicCapturedListener = picCapturedListener;
            Player.MPInteger stWidth = new Player.MPInteger();
            Player.MPInteger stHeight = new Player.MPInteger();
            if (!Player.getInstance().getPictureSize(m_iPort, stWidth, stHeight)) {
                Log.e(TAG, "获取图片尺寸失败---> error code:" + Player.getInstance().getLastError(m_iPort));
                return null;
            }
            int nSize = 5 * stWidth.value * stHeight.value;
            byte[] picBuf = new byte[nSize];
            Player.MPInteger stSize = new Player.MPInteger();
            if (!Player.getInstance().getBMP(m_iPort, picBuf, nSize, stSize)) {
                Log.e(TAG, "获取位图失败----> error code:" + Player.getInstance().getLastError(m_iPort));
                return null;
            }
            long time2 = System.currentTimeMillis();
            if (sDateFormat == null) {
                sDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh_mm_ss_Sss");
            }
            String date = sDateFormat.format(new java.util.Date());
            File dir = new File(Environment.getExternalStorageDirectory() + "/capture");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir, date + ".jpg");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(picBuf, 0, stSize.value);
            fos.close();
            long time3 = System.currentTimeMillis();
            Bitmap bitmap = BitmapFactory.decodeFile(dir.getAbsolutePath() + "/" + date + ".jpg");
            long time4 = System.currentTimeMillis();
            //图片保存成功了，通知给外面
            mPicCapturedListener.onPicCaptured(bitmap, file.getAbsolutePath());
            return bitmap;
        } catch (Exception err) {
            Log.e(TAG, "error: " + err.toString());
        } finally {

            return null;
        }
    }

    /**
     * 截取一帧图片,成功返回bitmap对象，失败返回null
     * 图片数据存放在内存中
     */
    public byte[] captureFrameOnMemroy(onPicCapturedListener picCapturedListener, Handler handler) {
        try {
            long start = System.currentTimeMillis();
            mPicCapturedListener = picCapturedListener;
            if (stWidth == null) {
                stWidth = new Player.MPInteger();
            }
            if (stHeight == null) {
                stHeight = new Player.MPInteger();
            }
            if (!Player.getInstance().getPictureSize(m_iPort, stWidth, stHeight)) {
                Log.e(TAG, "获取图片尺寸失败---> error code:" + Player.getInstance().getLastError(m_iPort));
                return null;
            }
            int nSize = 5 * stWidth.value * stHeight.value;
            byte[] picBuf = new byte[nSize];
            if (stSize == null) {

                stSize = new Player.MPInteger();
            }
            if (!Player.getInstance().getBMP(m_iPort, picBuf, nSize, stSize)) {
//                mPicCapturedListener.onPicDataSavedError();
                Log.e(TAG, "获取位图失败----> error code:" + Player.getInstance().getLastError(m_iPort));
                return null;
            }
            //图片保存数据获取成功了，通知给外面。或者用handler发送出去
           /* mPicCapturedListener.onPicDataSaved(picBuf);
            Message message = handler.obtainMessage();
            message.obj = picBuf;
            message.what = Constant.VIDEO_FRAME_PIC_DATA_SAVED;
            handler.sendMessage(message);
            long end = System.currentTimeMillis();*/
            return picBuf;
        } catch (Exception err) {
            Log.e(TAG, "error: " + err.toString());
        }
        return null;
    }

    /**
     * 云台控制
     *
     * @param command
     * @param dwStop
     * @param dwSpeed
     */
    public void ptzControl(String command, int dwStop, int dwSpeed) {
        int i = 0;
        switch (command) {
            case "TILT_UP":
                i = PTZCommand.TILT_UP;
                break;
            case "TILT_DOWN":
                i = PTZCommand.TILT_DOWN;
                break;
            case "PAN_LEFT":
                i = PTZCommand.PAN_LEFT;
                break;
            case "PAN_RIGHT":
                i = PTZCommand.PAN_RIGHT;
                break;
            case "UP_LEFT":
                i = PTZCommand.UP_LEFT;
                break;
            case "UP_RIGHT":
                i = PTZCommand.UP_RIGHT;
                break;
            case "DOWN_LEFT":
                i = PTZCommand.DOWN_LEFT;
                break;
            case "DOWN_RIGHT":
                i = PTZCommand.DOWN_RIGHT;
                break;
            case "PAN_AUTO":
                i = PTZCommand.PAN_AUTO;
                break;
            case "ZOOM_IN":
                i = PTZCommand.ZOOM_IN;
                break;
            case "ZOOM_OUT":
                i = PTZCommand.ZOOM_OUT;
                break;
            case "FOCUS_NEAR":
                i = PTZCommand.FOCUS_NEAR;
                break;
            case "IRIS_OPEN":
                i = PTZCommand.IRIS_OPEN;
                break;
            case "IRIS_CLOSE":
                i = PTZCommand.IRIS_CLOSE;
                break;
            case "LIGHT_PWRON":
                i = PTZCommand.LIGHT_PWRON;
                break;
            case "WIPER_PWRON":
                i = PTZCommand.WIPER_PWRON;
                break;
            case "FAN_PWRON":
                i = PTZCommand.FAN_PWRON;
                break;
            case "HEATER_PWRON":
                i = PTZCommand.HEATER_PWRON;
                break;
            case "AUX_PWRON1":
                i = PTZCommand.AUX_PWRON1;
                break;
            case "AUX_PWRON2":
                i = PTZCommand.AUX_PWRON2;
                break;
            default:
                break;
        }
        if (i == 0) {
            return;
        }
        if (!HCNetSDK.getInstance().NET_DVR_PTZControlWithSpeed_Other(
                logId, m_iStartChan, i, dwStop, dwSpeed)) {
            Log.e(TAG, "NET_DVR_PTZControl_Other " + command + " " + dwStop + " faild!"
                    + " err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
        } else {
            Log.e(TAG, "NET_DVR_PTZControl_Other " + command + " " + dwStop + " succ");
        }
    }

}
