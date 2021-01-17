package com.onramp.android.takehome.room;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.onramp.android.takehome.model.Hero;

import timber.log.Timber;

@androidx.room.Database(entities = {Hero.class}, version = 1, exportSchema = false)
public abstract class HeroDatabase extends RoomDatabase {

    public abstract HeroDao heroDao();

    private final static String DATABASE_NAME = "heroes";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static volatile HeroDatabase sInstance;

    public static HeroDatabase getInstance(Context context) {

        Timber.d("CREATING DATABASE");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        HeroDatabase.class, HeroDatabase.DATABASE_NAME).build();

                Timber.d(" FINISHED CREATING DATABASE");
            }
        } else Timber.d("DATABASE ALREASY EXISTS. RETURNING SAME INSTANCE");
        return sInstance;
    }
}
