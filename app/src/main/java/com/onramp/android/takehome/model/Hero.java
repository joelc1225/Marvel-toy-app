package com.onramp.android.takehome.model;

import org.parceler.Parcel;

@Parcel
public class Hero {

    // Needs to public for Parceler library
    public String name;
    public String description;
    public String imagePath;
    public String detailsUrl;


    public Hero(String name, String description, String imagePath, String detailsUrl) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.detailsUrl = detailsUrl;
    }

    // Empty constructor needed for Parceler library
    public Hero() {
    }
}
