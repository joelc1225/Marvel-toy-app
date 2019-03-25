package com.onramp.android.takehome.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.onramp.android.takehome.model.Hero;

import java.util.List;

@Dao
public interface HeroDao {

    @Query("SELECT * FROM hero")
    LiveData<List<Hero>> getAllHeroes();

    // Queries for one Hero item based off Hero name
    // Used only to verify if an entry already exists in database
    @Query("SELECT * FROM hero WHERE name =:name")
    Hero getHeroByName(String name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Hero hero);

    @Delete
    void delete(Hero hero);

    // TODO update getters setters???
}
