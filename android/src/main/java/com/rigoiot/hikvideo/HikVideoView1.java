package com.rigoiot.hikvideo;

import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.view.Gravity;
import android.widget.Toast;

import com.hcnetsdk.jna.HCNetSDKJNAInstance;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_DEVICEINFO_V30;
import com.hikvision.netsdk.NET_DVR_PREVIEWINFO;
import com.hikvision.netsdk.PTZCommand;
import com.hikvision.netsdk.NET_DVR_JPEGPARA;

public final class HikVideoView extends FrameLayout {

    // private PlaySurfaceView videoView;
    private SurfaceView surfaceView;

    private NET_DVR_DEVICEINFO_V30 m_oNetDvrDeviceInfoV30 = null;

    private int m_iLogID = -1; // return by NET_DVR_Login_v30
    private int m_iPlayID = -1; // return by NET_DVR_RealPlay_V30

    private int m_iStartChan = 0; // start channel no
    private int m_iChanNum = 0; // channel number
    // private static PlaySurfaceView[] playView = new PlaySurfaceView[4];

    private final String TAG = "........HikVideoView";

    public HikVideoView(final ThemedReactContext themedReactContext) {
        super(themedReactContext);

        // init hikvision
        if (!initeSdk()) {
            return;
        }

        surfaceView = new SurfaceView(themedReactContext);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        surfaceView.setLayoutParams(params);
        addView(surfaceView);
    }

    /**
     * @param NULL [in]
     * @param NULL [out]
     * @return true - success;false - fail
     * @fn initeSdk
     * @author zhuzhenlei
     * @brief SDK init
     */
    private boolean initeSdk() {
        // init net sdk
        if (!HCNetSDK.getInstance().NET_DVR_Init()) {
            Log.e(TAG, "HCNetSDK init is failed!");
            return false;
        }
        HCNetSDK.getInstance().NET_DVR_SetLogToFile(3, "/mnt/sdcard/sdklog/",
                true);

        return true;
    }

    private int loginNormalDevice(String ip, int port, String user, String psd) {
        // get instance
        m_oNetDvrDeviceInfoV30 = new NET_DVR_DEVICEINFO_V30();
        if (null == m_oNetDvrDeviceInfoV30) {
            Log.e(TAG, "HKNetDvrDeviceInfoV30 new is failed!");
            return -1;
        }

        // String strIP = "192.168.0.169";
        // int nPort = 8000;
        // String strUser = "admin";
        // String strPsd = "admin123";
        // call NET_DVR_Login_v30 to login on, port 8000 as default
        int iLogID = HCNetSDK.getInstance().NET_DVR_Login_V30(ip, port, user, psd, m_oNetDvrDeviceInfoV30);

        if (iLogID < 0) {
            Log.e(TAG, "NET_DVR_Login is failed!Err:"
                    + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return -1;
        }
        if (m_oNetDvrDeviceInfoV30.byChanNum > 0) {
            m_iStartChan = m_oNetDvrDeviceInfoV30.byStartChan;
            m_iChanNum = m_oNetDvrDeviceInfoV30.byChanNum;
        } else if (m_oNetDvrDeviceInfoV30.byIPChanNum > 0) {
            m_iStartChan = m_oNetDvrDeviceInfoV30.byStartDChan;
            m_iChanNum = m_oNetDvrDeviceInfoV30.byIPChanNum
                    + m_oNetDvrDeviceInfoV30.byHighDChanNum * 256;
        }

        if (m_iChanNum > 1) {
            // ChangeSingleSurFace(false);
        } else {
            // changeSingleSurFace();
        }

        Log.i(TAG, "NET_DVR_Login is Successful!");

        return iLogID;
    }

    private void startSinglePreview() {

        if (m_iPlayID > -1) {
            Log.i(TAG, "m_iPlayID > -1");
            return;
        }

        // Log.i(TAG, "m_iStartChan:" + m_iStartChan);

        NET_DVR_PREVIEWINFO previewInfo = new NET_DVR_PREVIEWINFO();
        previewInfo.lChannel = m_iStartChan;
        previewInfo.dwStreamType = 0; // substream
        previewInfo.bBlocked = 1;
        // previewInfo.hHwnd = videoView.getHolder();
        previewInfo.hHwnd = surfaceView.getHolder();

        m_iPlayID = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(m_iLogID,
                previewInfo, null);
        if (m_iPlayID < 0) {
            Log.e(TAG, "NET_DVR_RealPlay is failed!Err:"
                    + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return;
        }

        boolean bRet = HCNetSDKJNAInstance.getInstance().NET_DVR_OpenSound(m_iPlayID);
        if (bRet) {
            Log.e(TAG, "NET_DVR_OpenSound Succ!");
        }

        // Log.i(TAG, "NetSdk Play sucess ***********************3***************************");

    }

    private void stopSinglePreview() {
        if (m_iPlayID < 0) {
            Log.i(TAG, "m_iPlayID < 0");
            return;
        }

        if (HCNetSDKJNAInstance.getInstance().NET_DVR_CloseSound()) {
            Log.i(TAG, "NET_DVR_CloseSound Succ!");
        }

        // net sdk stop preview
        if (!HCNetSDK.getInstance().NET_DVR_StopRealPlay(m_iPlayID)) {
            Log.e(TAG, "StopRealPlay is failed!Err:"
                    + HCNetSDK.getInstance().NET_DVR_GetLastError());
            return;
        }
        Log.i(TAG, "NET_DVR_StopRealPlay succ");
        m_iPlayID = -1;
    }

    public void loadView(String ip, int port, String user, String psd) {

        logout();

        m_iLogID = loginNormalDevice(ip, port, user, psd);

        if (m_iLogID >= 0) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startSinglePreview();
                }
            }, 1000);
        }
    }

    public void ptzControl(String command, int dwStop) {
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
        default:
            break;
        }
        if (i == 0) {
          return;
        }
        if (!HCNetSDK.getInstance().NET_DVR_PTZControlWithSpeed_Other(
                m_iLogID, m_iStartChan, i, 0, 3)) {
            Log.e(TAG,
                    "start PAN_LEFT failed with error code: "
                            + HCNetSDK.getInstance()
                            .NET_DVR_GetLastError());
        } else {
            Log.i(TAG, "start PAN_LEFT succ");
        }

        if(!HCNetSDK.getInstance().NET_DVR_PTZControl_Other(m_iLogID, m_iStartChan, i, dwStop))
    		{
    			Log.e(TAG, "NET_DVR_PTZControl_Other " + command +" "+dwStop+ " faild!" + " err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
    		}
    		else
    		{
    			Log.e(TAG, "NET_DVR_PTZControl_Other " + command +" "+dwStop+ " succ");
    		}
    }

    public void logout() {
        stopSinglePreview();

        if (m_iLogID != -1) {
            if (!HCNetSDK.getInstance().NET_DVR_Logout_V30(m_iLogID)) {
                Log.e(TAG, " NET_DVR_Logout is failed!");
                //if (!HCNetSDKJNAInstance.getInstance().NET_DVR_DeleteOpenEzvizUser(m_iLogID)) {
                //		Log.e(TAG, " NET_DVR_DeleteOpenEzvizUser is failed!");
                return;
            }
            Log.i(TAG, " NET_DVR_Logout is succ!");
            m_iLogID = -1;
        }
    }

    public void capturePicture(String fileName){
      if (fileName == null) {
        return;
      }
      NET_DVR_JPEGPARA strJpeg = new  NET_DVR_JPEGPARA();
    	strJpeg.wPicQuality = 1;
    	strJpeg.wPicSize = 2;
    	if(!HCNetSDK.getInstance().NET_DVR_CaptureJPEGPicture(m_iLogID, m_iChanNum, strJpeg, new String(fileName)))
    	{
    		Log.i(TAG, "NET_DVR_CaptureJPEGPicture!" + " err: " + HCNetSDK.getInstance().NET_DVR_GetLastError());
		  }
    	else
    	{
    		Log.i(TAG, "NET_DVR_CaptureJPEGPicture! succeed");
    	}
    }

}
