package com.onramp.android.takehome.model;

import org.parceler.Parcel;

@Parcel
public class Character {

    String name;
    String description;
    String imagePath;


    public Character(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    // Empty constructor needed for Parceler library
    public Character() {
    }
}
