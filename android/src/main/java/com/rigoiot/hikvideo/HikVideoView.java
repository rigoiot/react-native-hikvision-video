package com.rigoiot.hikvideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceView;

import com.rigoiot.hikvideo.utils.HikUtil;

public class HikVideoView extends Activity {
    private static final String TAG = "MainActivity";
    //----------------------------------------------------------------------------------------------
    SurfaceView surfaceView; 
    //----------------------------------------------------------------------------------------------
    private static final int PLAY_HIK_STREAM_CODE = 1001;
    private static final int PLAY_HIK_STREAM_CODE_2 = 1002;
    private static final int PLAY_HIK_STREAM_CODE_3 = 1003;
    private static final String IP_ADDRESS = "192.168.0.64";
    private static final String IP_ADDRESS_2 = "192.168.0.65";
    private static final String IP_ADDRESS_3 = "192.168.0.164";
    private static final int PORT = 8000;
    private static final String USER_NAME = "admin";
    private static final String USER_NAME_2 = "admin";
    private static final String PASSWORD = "rigoiot123";
    private static final String PASSWORD_2 = "fzjs12345";
    //----------------------------------------------------------------------------------------------

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case PLAY_HIK_STREAM_CODE:
                    hikUtil.playOrStopStream(); 
                default:
                    break;
            }
            return false;
        }
    });
    private HikUtil hikUtil; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = findViewById(R.id.surfaceView); 

        // HikUtil.initSDK();
        // hikUtil = new HikUtil();
        // hikUtil.initView(surfaceView);
        // hikUtil.setDeviceData(IP_ADDRESS, PORT, USER_NAME, PASSWORD);
        // hikUtil.loginDevice(mHandler, PLAY_HIK_STREAM_CODE); 
    }  

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hikUtil.playOrStopStream(); 
    }

    public void loadView(String ip, int port, String user, String psd) {
        HikUtil.initSDK();
        hikUtil = new HikUtil();
        hikUtil.initView(surfaceView);
        hikUtil.setDeviceData(ip, port, user, psd);
        hikUtil.loginDevice(mHandler, PLAY_HIK_STREAM_CODE); 
    }
}
