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
        view.logout();
    }

    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(
                COMMAND_PTZ_NAME, COMMAND_PTZ_ID
        );
    }

//    @Override
    public void receiveCommand(HikVideoView video, int commandId, ReadableArray args) {
        switch (commandId){
            case COMMAND_PTZ_ID:
                if(args != null) {
                    video.ptzControl(args.getString(0), args.getInt(1));
                }
                break;
            default:
                break;
        }
    }

    @ReactProp(name = "source")
    public void setSource(HikVideoView view, ReadableMap source) {
        String uri = source.getString("uri");
        String user = source.getString("user");
        String psd = source.getString("psd");
        int port = 8000;
  		try {
  			port = Integer.parseInt(source.getString("port"));
  		} catch (Exception e) {
  			e.printStackTrace();
  		}

      view.loadView(uri, port, user, psd);
    }
}
