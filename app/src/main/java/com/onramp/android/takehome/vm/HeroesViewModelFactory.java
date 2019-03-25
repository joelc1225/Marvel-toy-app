package com.onramp.android.takehome.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.onramp.android.takehome.data.HeroRepository;

public class HeroesViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final HeroRepository mRepository;

    public HeroesViewModelFactory(HeroRepository repository) {
        this.mRepository = repository;
    }

    @SuppressWarnings("unchecked cast warning")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HeroesViewModel(mRepository);
    }
}
