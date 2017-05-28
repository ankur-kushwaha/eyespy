package com.ankurkushwaha.eyespy.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

/**
 * Created by ankur.kushwaha on 5/27/17.
 */

public class MyTaskService extends HeadlessJsTaskService {

    @Override
    protected
    @Nullable
    HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Log.d("MyTaskService", "task invoked in java");
        Bundle extras = intent.getExtras();

        return new HeadlessJsTaskConfig(
                "SomeTaskName",
               null,
                5000);


    }
}
