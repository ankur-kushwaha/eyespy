package com.ankurkushwaha.eyespy.service;

import android.app.Activity;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ankur.kushwaha on 5/31/17.
 */

public class FirebaseService{
    private String TAG="FirebaseService";
    private FirebaseAuth mAuth;
    private Context context;
    private FirebaseDatabase database;

    public FirebaseService(Context context){
        this.context=context;
        database = FirebaseDatabase.getInstance();
    }

    public void updateLocation(Location loc) {
        Log.d(TAG, "saving location on firebase" + loc);
        DatabaseReference myRef = database.getReference("locations");
        String key = myRef.push().getKey();
        myRef.child(key).setValue(loc);
    }

    public void login(){
        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword("service@gmail.com", "service");
    }
}
