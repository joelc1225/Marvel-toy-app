package com.onramp.android.takehome;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.onramp.android.takehome.data.HeroRepository;
import com.onramp.android.takehome.model.Hero;

import org.parceler.Parcels;

import timber.log.Timber;

public class DatabaseService extends IntentService {

    public DatabaseService() {
        super("DatabaseService");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Timber.d("SERVICE ON HANDLEINTENT CALLED");

        String action = null;
        Hero hero = null;

        // Perform null checks before setting data and taking action
        Bundle bundle = null;
        if (intent != null) {
            bundle = intent.getExtras();
        }

        if (bundle != null) {
            Timber.d("Bundle NOT null. Extracting data from bundle");

            if (bundle.containsKey("actionKey")) {
                action = bundle.getString("actionKey");
            } else {
                Timber.d("NO ACTION KEY FOUND");
            }

            if (bundle.containsKey("heroKey")) {
                hero = Parcels.unwrap(bundle.getParcelable("heroKey"));
            } else {
                Timber.d("NO HERO KEY FOUND");
            }

        } else {
            Timber.d("Service Bundle is NULL");
        }

        // Perform database action based on data sent into the service
        if (action != null && action.equals("insert")) {
            Timber.d("ACTION is set to INSERT. Inserting now");
            HeroRepository.getHeroDao().insert(hero);
        }

        if (action != null && action.equals("delete")) {
            Timber.d("ACTION is set to DELETE. Deleting now");
            HeroRepository.getHeroDao().delete(hero);
        }
    }
}
