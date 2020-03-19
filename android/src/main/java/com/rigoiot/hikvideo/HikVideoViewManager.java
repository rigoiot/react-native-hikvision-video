package com.rigoiot.hikvideo;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableMap;

import java.util.Map;

/**
 * Created by oulp on 2018/3/23.
 */

public class HikVideoViewManager extends SimpleViewManager<HikVideoView> {

    private static final int COMMAND_PTZ_ID = 1;
    private static final String COMMAND_PTZ_NAME = "ptzControl";

    private static final int COMMAND_CP_ID = 2;
    private static final String COMMAND_CP_NAME = "capturePicture";

    @Override
    public String getName() {
        return "HikVideoView";
    }

    @Override
    protected HikVideoView createViewInstance(ThemedReactContext reactContext) {
        HikVideoView textView = new HikVideoView(reactContext);
        return textView;
    }

    @Override
    public void onDropViewInstance(HikVideoView view) {
        super.onDropViewInstance(view);
        view.onDropView();
    }

    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(
                COMMAND_PTZ_NAME, COMMAND_PTZ_ID,
                COMMAND_CP_NAME, COMMAND_CP_ID
        );
    }

//    @Override
    public void receiveCommand(HikVideoView video, int commandId, ReadableArray args) {
        switch (commandId){
            case COMMAND_PTZ_ID:
                if(args != null) {
                    video.ptzControl(args.getString(0), args.getInt(1), args.getInt(2));
                }
                break;
            case COMMAND_CP_ID:
                if(args != null) {
                //   video.capturePicture(args.getString(0));
                }
                break;
            default:
                break;
        }
    }

    @ReactProp(name = "source")
    public void setSource(HikVideoView view, ReadableMap source) {
        if (!source.hasKey("uri")){
            return;
        }
        String uri = source.getString("uri");
        String user = source.hasKey("user") ? source.getString("user") : "";
        String psd = source.hasKey("psd") ? source.getString("psd") : "";

        int port = 8000;
        int channel = 0;
  		try { 
            if (source.hasKey("port")){
                port = Integer.parseInt(source.getString("port"));
            }
            if (source.hasKey("channel")){
                channel = Integer.parseInt(source.getString("channel"));
            }
  		} catch (Exception e) {
  			// e.printStackTrace();
  		}
        view.loadView(uri, port, user, psd, channel);
    }
}
