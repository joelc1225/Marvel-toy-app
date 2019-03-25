package com.onramp.android.takehome.data;

import android.app.Application;

import com.onramp.android.takehome.model.Hero;
import com.onramp.android.takehome.room.HeroDao;
import com.onramp.android.takehome.room.HeroDatabase;

import java.util.List;

public class Repository {

    private HeroDao mHeroDao;
    private List<Hero> mAllHeroes;

    Repository(Application application) {
        HeroDatabase db = HeroDatabase.getInstance(application);
        mHeroDao = db.heroDao();
        mAllHeroes = mHeroDao.getAllHeroes();
    }

}
