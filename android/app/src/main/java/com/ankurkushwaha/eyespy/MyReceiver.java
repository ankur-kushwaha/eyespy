package com.ankurkushwaha.eyespy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.ankurkushwaha.eyespy.service.MyTaskService;
import com.facebook.react.HeadlessJsTaskService;

/**
 * Created by ankur.kushwaha on 5/28/17.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();

        context.startService(new Intent(context, MyTaskService.class));
        HeadlessJsTaskService.acquireWakeLockNow(context);
    }
}