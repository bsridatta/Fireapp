package com.example.sridatta.fireapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by sridatta on 21-11-2016.
 */
//common interface-ish  for other classes to use the firebase
public class Fireapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
