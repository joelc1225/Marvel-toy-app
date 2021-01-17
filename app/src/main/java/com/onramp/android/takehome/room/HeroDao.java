package com.onramp.android.takehome.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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
