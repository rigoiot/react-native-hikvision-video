package com.hikplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.hcnetsdk.jna.HCNetSDKJNAInstance;
import com.hikvision.netsdk.HCNetSDK;
import com.hikvision.netsdk.NET_DVR_PREVIEWINFO;


public class PlaySurfaceView extends SurfaceView implements Callback {

    private final String TAG = "PlaySurfaceView";
    private int m_iWidth = 0;
    private int m_iHeight = 0;
    public int m_iPreviewHandle = -1;
    private SurfaceHolder m_hHolder;
    public boolean bCreate = false;

    public int m_lUserID = -1;
    public int m_iChan = 0;

    public int getM_iWidth() {
        return m_iWidth;
    }

    public void setM_iWidth(int m_iWidth) {
        this.m_iWidth = m_iWidth;
    }

    public int getM_iHeight() {
        return m_iHeight;
    }

    public void setM_iHeight(int m_iHeight) {
        this.m_iHeight = m_iHeight;
    }

    public PlaySurfaceView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        m_hHolder = this.getHolder();
        getHolder().addCallback(this);
        Log.d("........PlaySurfaceView............", "3");
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
        setZOrderOnTop(true);
        getHolder().setFormat(PixelFormat.TRANSLUCENT);

        Log.d("........PlaySurfaceView............","surfaceChanged");
    }

    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
        bCreate = true;
        Log.d("........PlaySurfaceView............","surfaceCreated");

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        // TODO Auto-generated method stub
        Log.d("........PlaySurfaceView............","surfaceDestroyed");
        bCreate = false;

    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.setMeasuredDimension(m_iWidth - 1, m_iHeight - 1);
    }

    public void setParam(int nScreenSize) {
        m_iWidth = nScreenSize / 2;
        m_iHeight = (m_iWidth * 3) / 4;
    }

    public void startPreview(int iUserID, int iChan) {
        Log.i(TAG, "preview channel:" + iChan);

        while (!bCreate) {
            try {
                Thread.sleep(100);
                Log.i(TAG, "wait for surface create");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        NET_DVR_PREVIEWINFO previewInfo = new NET_DVR_PREVIEWINFO();
        previewInfo.lChannel = iChan;
        previewInfo.dwStreamType = 1; // substream
        previewInfo.bBlocked = 1;
        previewInfo.hHwnd = m_hHolder;
        // HCNetSDK start preview

        m_iPreviewHandle = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(iUserID,
                previewInfo, null);
        if (m_iPreviewHandle < 0) {
            Log.e(TAG, "NET_DVR_RealPlay is failed!Err:"
                    + HCNetSDK.getInstance().NET_DVR_GetLastError());
        }

        boolean bRet = HCNetSDKJNAInstance.getInstance().NET_DVR_OpenSound(m_iPreviewHandle);

        // m_lUserID = iUserID;
        // m_iChan = iChan;
        //
        // new Thread(new Runnable() {
        //
        // @Override
        // public void run() {
        // // TODO Auto-generated method stub
        //
        // while (!bCreate) {
        // try {
        // Thread.sleep(100);
        // Log.i(TAG, "wait for surface create");
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }
        //
        // NET_DVR_PREVIEWINFO previewInfo = new NET_DVR_PREVIEWINFO();
        // previewInfo.lChannel = m_iChan;
        // previewInfo.dwStreamType = 0; // substream
        // previewInfo.bBlocked = 1;
        // previewInfo.hHwnd = m_hHolder;
        //
        // m_iPreviewHandle = HCNetSDK.getInstance().NET_DVR_RealPlay_V40(
        // m_lUserID, previewInfo, null);
        // if (m_iPreviewHandle < 0) {
        // Log.e(TAG, "NET_DVR_RealPlay is failed!Err:"
        // + HCNetSDK.getInstance().NET_DVR_GetLastError());
        // }
        // }
        // }).start();

    }

    public void stopPreview() {
        HCNetSDK.getInstance().NET_DVR_StopRealPlay(m_iPreviewHandle);
    }
}
