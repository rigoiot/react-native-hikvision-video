package com.hikplayer;

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

    @ReactProp(name="source")
    public void setUrl(HikVideoView view, ReadableMap source){
        view.loadView(source.getString("uri"), Integer.parseInt(source.getString("port")),source.getString("user"),source.getString("psd"));
    }
}
