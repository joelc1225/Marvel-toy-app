package com.onramp.android.takehome.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

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
