package com.rigoiot.hikvideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.util.Log;

import com.facebook.react.uimanager.ThemedReactContext;
import com.rigoiot.hikvideo.utils.HikUtil;

import java.util.Calendar;

public final class HikVideoView extends FrameLayout {
    private static final String TAG = "HikVideoView";
    //----------------------------------------------------------------------------------------------
    SurfaceView surfaceView;
    //----------------------------------------------------------------------------------------------
    private static final int PLAY_HIK_STREAM_CODE = 1001;
    //----------------------------------------------------------------------------------------------
    private HikUtil hikUtil;

    private String ip;
    private int port;
    private String user;
    private String psd;
    private int channel;
    private String mode;

    public void setSourse(String ip, int port, String user, String psd, int channel) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.psd = psd;
        this.channel = channel;
        if (this.mode != null) {
            loadView(ip, port, user, psd, channel, this.mode);
        }
    }

    public void setMode(String mode) {
        this.mode = mode;
        if (this.ip != null) {
            loadView(this.ip, this.port, this.user, this.psd, this.channel, mode);
        }
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case PLAY_HIK_STREAM_CODE:
                    hikUtil.playStream();
                default:
                    break;
            }
            return false;
        }
    });

    private Handler iHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            hikUtil.loginDevice(mHandler, msg.what);
            return false;
        }
    });

    public HikVideoView(final ThemedReactContext themedReactContext) {
        super(themedReactContext);
        surfaceView = new SurfaceView(themedReactContext);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        surfaceView.setLayoutParams(params);
        addView(surfaceView);
    }


    public void onDropView() {
        if (hikUtil != null) {
            hikUtil.stopStream();
            hikUtil.stopNVRBack();
            hikUtil.logout();
        }
    }

    public void loadView(String ip, int port, String user, String psd, int channel, String mode) {
        // Log.i(TAG, "loadView " + ip + " " + port + " " + user + " " + psd + " " + channel + " " + mode);
        HikUtil.initSDK();
        hikUtil = new HikUtil();
        hikUtil.initView(surfaceView, iHandler, "playback".equals(mode) ? 0 : PLAY_HIK_STREAM_CODE);
        hikUtil.setDeviceData(ip, port, user, psd, channel);
        // hikUtil.loginDevice(mHandler, PLAY_HIK_STREAM_CODE);
    }

    public void ptzControl(String command, int dwStop, int dwSpeed) {
        if (hikUtil != null) {
            hikUtil.ptzControl(command, dwStop, dwSpeed);
        }
    }

    public void playNVRBack(Calendar startTime, Calendar stopTime) {
        if (hikUtil != null) {
            hikUtil.playNVRBack(startTime, stopTime);
        }
    }

    public void stopNVRBack() {
        if (hikUtil != null) {
            hikUtil.stopNVRBack();
        }
    }

    public void controlNVRBack(int dwControlCode) {
        if (hikUtil != null) {
            hikUtil.controlNVRBack(dwControlCode);
        }
    }
}
