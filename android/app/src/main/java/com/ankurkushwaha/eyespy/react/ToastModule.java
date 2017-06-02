package com.ankurkushwaha.eyespy.react;

/**
 * Created by ankur.kushwaha on 5/27/17.
 */


import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.ankurkushwaha.eyespy.service.MyTaskService;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class ToastModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CustomToastAndroid";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Log.d(getName(),"toast called with "+message);

        //getReactApplicationContext().startService(new Intent(getReactApplicationContext(), MyTaskService.class));
        //HeadlessJsTaskService.acquireWakeLockNow(getReactApplicationContext());
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
}