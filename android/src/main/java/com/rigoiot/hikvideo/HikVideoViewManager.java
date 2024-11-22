package com.rigoiot.hikvideo;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

/**
 * Created by oulp on 2018/3/23.
 */

public class HikVideoViewManager extends SimpleViewManager<HikVideoView> {

    private static final String TAG = "HikVideoViewManager";

    private static final int COMMAND_PTZ_ID = 1;
    private static final String COMMAND_PTZ_NAME = "ptzControl";

    private static final int COMMAND_CP_ID = 2;
    private static final String COMMAND_CP_NAME = "capturePicture";

    private static final int COMMAND_PLAYNVRBACK_ID = 3;
    private static final String COMMAND_PLAYNVRBACK_NAME = "playNVRBack";

    private static final int COMMAND_STOPNVRBACK_ID = 4;
    private static final String COMMAND_STOPNVRBACK_NAME = "stopNVRBack";

    private static final int COMMAND_CONTROLNVRBACK_ID = 5;
    private static final String COMMAND_CONTROLNVRBACK_NAME = "controlNVRBack";

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

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onChange",
                MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onChange"))).build();
    }

    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(
                COMMAND_PTZ_NAME, COMMAND_PTZ_ID,
                COMMAND_CP_NAME, COMMAND_CP_ID,
                COMMAND_PLAYNVRBACK_NAME, COMMAND_PLAYNVRBACK_ID,
                COMMAND_STOPNVRBACK_NAME, COMMAND_STOPNVRBACK_ID,
                COMMAND_CONTROLNVRBACK_NAME, COMMAND_CONTROLNVRBACK_ID
        );
    }

    //    @Override
    public void receiveCommand(HikVideoView video, int commandId, ReadableArray args) {
        switch (commandId) {
            case COMMAND_PTZ_ID:
                if (args != null) {
                    video.ptzControl(args.getString(0), args.getInt(1), args.getInt(2));
                }
                break;
            case COMMAND_CP_ID:
                if (args != null) {
                    //   video.capturePicture(args.getString(0));
                }
                break;
            case COMMAND_PLAYNVRBACK_ID:
                if (args != null && args.size() == 2) {
                   video.playNVRBack(args.getString(0), args.getString(1));
                }
                break;
            case COMMAND_STOPNVRBACK_ID:
                video.stopNVRBack();
                break;
            case COMMAND_CONTROLNVRBACK_ID:
                if (args != null) {
                    video.controlNVRBack(args.getInt(0));
                }
                break;
            default:
                break;
        }
    }

    @ReactProp(name = "mode")
    public void setMode(HikVideoView view, String mode) {
        view.setMode(mode);
    }

    @ReactProp(name = "source")
    public void setSource(HikVideoView view, ReadableMap source) {
        if (!source.hasKey("uri")) {
            return;
        }
        String uri = source.getString("uri");
        String user = source.hasKey("user") ? source.getString("user") : "";
        String psd = source.hasKey("psd") ? source.getString("psd") : "";

        int port = 8000;
        int channel = 0;
        try {
            if (source.hasKey("port")) {
                port = Integer.parseInt(source.getString("port"));
            }
            if (source.hasKey("channel")) {
                channel = Integer.parseInt(source.getString("channel"));
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        view.setSourse(uri, port, user, psd, channel);
//        view.loadView(uri, port, user, psd, channel, "");
    }
}
