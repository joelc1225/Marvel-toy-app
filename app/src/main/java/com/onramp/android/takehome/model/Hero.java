package com.onramp.android.takehome.model;

import org.parceler.Parcel;

@Parcel
public class Hero {

    // Needs to public for Parceler library
    public String name;
    public String description;
    public String imagePath;


    public Hero(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    // Empty constructor needed for Parceler library
    public Hero() {
    }
}
