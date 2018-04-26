package com.rigoiot.hikvideo;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableMap;

/**
 * Created by oulp on 2018/3/23.
 */

public class HikVideoViewManager extends SimpleViewManager<HikVideoView> {

    @Override
    public String getName() {
        return "HikVideoView";
    }

    @Override
    protected HikVideoView createViewInstance(ThemedReactContext reactContext) {
        HikVideoView textView = new HikVideoView(reactContext);
        return textView;
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

    @ReactProp(name = "command")
    public void setCommand(HikVideoView view, ReadableMap command) {
        view.ptzControl(command.getString("command"));
    }
}
