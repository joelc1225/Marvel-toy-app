package com.onramp.android.takehome.utils;

import android.content.Context;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.Hero;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Helper class that creates the list of Hero objects needed to display in our MainActivity
 */
public class HeroHelper {

    public static List<Hero> heroesList;


    public static List<Hero> getHeroes(Context context) {

        if (heroesList == null || heroesList.isEmpty()) {
            Timber.d("Heroes list is null. CREATING");

            heroesList = new ArrayList<>();
            heroesList.add(new Hero(context.getString(R.string.ironman_name),
                    context.getString(R.string.ironman_description),
                    context.getString(R.string.ironman_imagePath)));

            heroesList.add(new Hero(context.getString(R.string.cap_name),
                    context.getString(R.string.cap_description),
                    context.getString(R.string.cap_imagePath)));

            heroesList.add(new Hero(context.getString(R.string.hulk_name),
                    context.getString(R.string.hulk_description),
                    context.getString(R.string.hulk_imagePath)));

            heroesList.add(new Hero(context.getString(R.string.blackWidow_name),
                    context.getString(R.string.blackWidow_description),
                    context.getString(R.string.blackWidow_imagePath)));

            heroesList.add(new Hero(context.getString(R.string.thor_name),
                    context.getString(R.string.thor_description),
                    context.getString(R.string.thor_imagePath)));

            heroesList.add(new Hero(context.getString(R.string.hawkeye_name),
                    context.getString(R.string.hawkeye_description),
                    context.getString(R.string.hawkeye_imagePath)));
        } else {
            Timber.d("List is NOT null. returning same list");
        }

        return heroesList;

    }
}
