package com.foxconn.fii.app.webview_flutter_kitkat.webview_flutter_kitkat_example;

import android.app.Application;

import androidx.multidex.MultiDex;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
