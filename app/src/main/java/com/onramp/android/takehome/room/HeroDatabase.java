package com.onramp.android.takehome.room;

import android.arch.persistence.room.RoomDatabase;

import com.onramp.android.takehome.model.Hero;

@android.arch.persistence.room.Database(entities = {Hero.class}, version = 1)
public abstract class Database  extends RoomDatabase {
    public abstract HeroDao heroDao();
}
