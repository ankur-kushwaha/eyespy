package com.ankurkushwaha.eyespy;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ankurkushwaha.eyespy.service.FirebaseService;
import com.ankurkushwaha.eyespy.service.GPSTracker;
import com.ankurkushwaha.eyespy.service.GoogleApiService;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HomeActivity extends AppCompatActivity{
    private static final String TAG = "HomeActivity";
    private LocationManager locationManager;
    private String provider;

    //private GoogleApiService googleApiService;

    // GPSTracker class
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    private void saveLocation(Location loc) {

    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    }

    private Location fetchLocation() {
        Location loc = null;
        System.out.println("starting location service");
        // create class object
        gps = new GPSTracker(HomeActivity.this);

        // check if GPS enabled
        if (gps.canGetLocation()) {
            loc = gps.getLocation2();


            // \n is for new line
            //Toast.makeText(getApplicationContext(), "Your Location is -"+loc.toString(), Toast.LENGTH_LONG).show();
        } else {

            gps.showSettingsAlert();
        }
        return loc;
    }


    protected void onStart() {
        //googleApiService.connect();
        super.onStart();
    }

    protected void onStop() {
        //googleApiService.disconnect();
        super.onStop();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //googleApiService.stopLocationUpdates();
    }

    public void startService(View view){
        Log.d(TAG,"starting service");
        startService(new Intent(this,GoogleApiService.class));
//        bindService(new Intent(this, GoogleApiService.class), new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//
//            }
//        }, Context.BIND_AUTO_CREATE);
    }
    public void stopService(View view){
        Log.d(TAG,"stopping service");
        stopService(new Intent(this,GoogleApiService.class));
    }
}
