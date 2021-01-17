package com.onramp.android.takehome.data;

import androidx.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.onramp.android.takehome.DatabaseService;
import com.onramp.android.takehome.model.Hero;
import com.onramp.android.takehome.room.HeroDao;

import org.parceler.Parcels;

import java.util.List;

import timber.log.Timber;

public class HeroRepository {

    // For singleton instantiation
    private static HeroDao mHeroDao;
    private static final Object LOCK = new Object();
    private static HeroRepository sInstance;

    private HeroRepository(HeroDao heroDao) {
        mHeroDao = heroDao;
    }

    public synchronized static HeroRepository getInstance(HeroDao heroDao) {
        Timber.d("Getting the repository instance");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new HeroRepository(heroDao);
                Timber.d("Made new repository");
            }
        }
        return sInstance;
    }

    // Gets all heroes from ROOM database
    public LiveData<List<Hero>> getAllHeroes() {
        return mHeroDao.getAllHeroes();
    }

    // Inserts new favorite Hero to Room database
    public static void insertFavoriteHero(Hero hero, Context context) {
        Timber.d("STARTING INSERT METHOD REPO");

        Bundle bundle = new Bundle();
        bundle.putParcelable("heroKey", Parcels.wrap(hero));
        bundle.putString("actionKey", "insert");

        Intent serviceIntent = new Intent(context, DatabaseService.class);
        serviceIntent.putExtras(bundle);

        context.startService(serviceIntent);
    }

    // Deletes Hero from favorites database
    public static void deleteFavoriteHero(Hero hero, Context context) {
        Timber.d("STARTING DELETE METHOD REPO");

        Bundle bundle = new Bundle();
        bundle.putParcelable("heroKey", Parcels.wrap(hero));
        bundle.putString("actionKey", "delete");

        Intent serviceIntent = new Intent(context, DatabaseService.class);
        serviceIntent.putExtras(bundle);

        context.startService(serviceIntent);
    }

    public Hero getSingleHeroById(String name) {
        Timber.d("QUERYING DB FOR SINGLE ITEM");
        return mHeroDao.getHeroByName(name);
    }

    public static HeroDao getHeroDao() {
        return  mHeroDao;
    }
}
