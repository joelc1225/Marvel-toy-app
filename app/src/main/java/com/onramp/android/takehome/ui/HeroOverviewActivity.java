package com.onramp.android.takehome.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.onramp.android.takehome.R;
import com.onramp.android.takehome.data.HeroRepository;
import com.onramp.android.takehome.model.Hero;
import com.onramp.android.takehome.utils.InjectorUtils;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import timber.log.Timber;

public class HeroOverviewActivity extends AppCompatActivity {

    // Tried to use databinding in this class, but kept getting an error with the Coordinator layout
    // Will investigate in the future
    TextView nameTextView;
    TextView descriptionTextView;
    ImageView heroImageView;
    Button detailsButton;
    ProgressBar progressBar;
    CoordinatorLayout coordinatorLayout;
    static LottieAnimationView lottieAnimationView;
    static boolean mIsFavorite;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_overview);

        nameTextView = findViewById(R.id.name_overview_textView);
        descriptionTextView = findViewById(R.id.hero_description_TV);
        heroImageView = findViewById(R.id.hero_overview_imageview);
        detailsButton = findViewById(R.id.details_button);
        progressBar = findViewById(R.id.overview_activity_progressbar);
        lottieAnimationView = findViewById(R.id.lottie_fave_star);
        coordinatorLayout = findViewById(R.id.coordinator_hero_overview);
        mContext = this;
        mIsFavorite = false;

        progressBar.setVisibility(View.VISIBLE);


        Bundle bundle = getIntent().getBundleExtra("bundle");

        if (bundle != null) {
            Timber.d("BUNDLE NOT NULL frag");
            if (bundle.containsKey("hero")) {
                Hero hero = Parcels.unwrap(bundle.getParcelable("hero"));

                if (hero != null) {
                    Timber.d("HERO NOT NULL frag");
                    nameTextView.setText(hero.name);
                    descriptionTextView.setText(hero.description);
                    Picasso.get().load(hero.imagePath)
                            .placeholder(R.drawable.hero_image_placeholder)
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .networkPolicy(NetworkPolicy.NO_CACHE)
                            .into(heroImageView, new Callback() {
                                @Override
                                public void onSuccess() {
                                    progressBar.setVisibility(View.INVISIBLE);
                                }

                                @Override
                                public void onError(Exception e) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "No network to download image", Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                }
                            });

                    detailsButton.setOnClickListener(v -> {
                        Intent moreDetailsIntent = new Intent(Intent.ACTION_VIEW);
                        moreDetailsIntent.setData(Uri.parse(hero.detailsUrl));
                        startActivity(moreDetailsIntent);
                    });

                    //Check if hero is already in the database. If so, adjust lottie animation to be colored in
                    new querySingleHeroAsyncTask().execute(hero.name);

                    // Clicking the imageAnimation will Insert and Remove the Hero from the ROOM database
                    lottieAnimationView.setOnClickListener(v -> {
                        if (!mIsFavorite) {
                            Timber.d("INSERTING FAVORITE");
                            lottieAnimationView.setSpeed(1);
                            lottieAnimationView.playAnimation();
                            HeroRepository.insertFavoriteHero(hero, this);
                            mIsFavorite = true;

                            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Inserting to database", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        } else {
                            Timber.d("DELETING FAVORITE");
                            lottieAnimationView.setSpeed(-2f);
                            lottieAnimationView.playAnimation();
                            HeroRepository.deleteFavoriteHero(hero, this);
                            mIsFavorite = false;

                            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Removing from database", Snackbar.LENGTH_LONG);
                            snackbar.show();
                        }
                    });
                }
            } else {
                Timber.d("NO HERO KEY");
            }
        }
    }


    private static class querySingleHeroAsyncTask extends AsyncTask<String, Void, Hero> {

        // Constructor
        querySingleHeroAsyncTask() {
        }

        @Override
        protected Hero doInBackground(String... strings) {
            Timber.d("INSIDE SINGLE HERO DIB");
            return InjectorUtils.provideRepository(mContext).getSingleHeroById(strings[0]);
        }

        @Override
        protected void onPostExecute(Hero hero) {
            super.onPostExecute(hero);

            if (hero == null) {
                Timber.d("HERO NOT IN DATABASE");
                // Do nothing
            } else {
                Timber.d("HERO ISSSSS IN DATABASE");
                // Set animationView to be filled in and ready to reverse animation
                lottieAnimationView.setProgress(1);
                lottieAnimationView.setFrame(49);
                lottieAnimationView.setSpeed(-2);
                mIsFavorite = true;
            }
        }
    }
}
