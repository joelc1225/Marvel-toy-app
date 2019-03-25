package com.onramp.android.takehome.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.onramp.android.takehome.data.HeroRepository;
import com.onramp.android.takehome.model.Hero;

import java.util.List;

public class HeroesViewModel extends ViewModel {

    private static List<Hero> mHeroes;
    private static LiveData<List<Hero>> mFavoriteHeroes;

    HeroesViewModel(HeroRepository heroRepository) {
        mFavoriteHeroes = heroRepository.getAllHeroes();
    }

    // Will be used to develop in the future to show the favorites in the database
    public static LiveData<List<Hero>> getFavoriteHeroes() {
        return mFavoriteHeroes;
    }

    public List<Hero> getHeroes() {
        return mHeroes;
    }

    public void setHeroes(List<Hero> heroes) {
        mHeroes = heroes;
    }
}
