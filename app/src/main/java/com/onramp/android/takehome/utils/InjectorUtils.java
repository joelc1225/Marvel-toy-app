package com.onramp.android.takehome.utils;

import android.content.Context;

import com.onramp.android.takehome.data.HeroRepository;
import com.onramp.android.takehome.room.HeroDatabase;

public class InjectorUtils {

    /**
     * Provides static method to inject various classes needed for app
     * one instantiation per app run through
     */

    public static HeroRepository provideRepository(Context context) {

        HeroDatabase heroDatabase = HeroDatabase.getInstance(context.getApplicationContext());
        return HeroRepository.getInstance(heroDatabase.heroDao());
    }
}
