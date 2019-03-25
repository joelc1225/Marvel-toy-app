package com.onramp.android.takehome.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;
import org.parceler.Parcel;

@Entity(tableName = "hero")
@Parcel
public class Hero {

    // Needs to public for Parceler library
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;
    public String description;
    public String imagePath;
    public String detailsUrl;


    public Hero(@NotNull String name, String description, String imagePath, String detailsUrl) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.detailsUrl = detailsUrl;
    }

    @Ignore
    // Empty constructor needed for Parceler library
    public Hero() {
    }
}
