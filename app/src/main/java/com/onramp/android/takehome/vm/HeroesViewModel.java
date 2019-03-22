package com.onramp.android.takehome.vm;

import android.arch.lifecycle.ViewModel;

import com.onramp.android.takehome.model.Hero;

import java.util.List;

public class HeroesViewModel extends ViewModel {

    private static List<Hero> mHeroes;

    public List<Hero> getHeroes() {
        return mHeroes;
    }

    public void setHeroes(List<Hero> heroes) {
        mHeroes = heroes;
    }
}
