package com.onramp.android.takehome;

import android.app.Application;

import timber.log.Timber;

public class MarvelApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
    }
}
