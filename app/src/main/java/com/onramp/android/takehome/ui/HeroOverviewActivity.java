package com.onramp.android.takehome.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.Hero;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import timber.log.Timber;

public class HeroOverviewActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView descriptionTextView;
    ImageView heroImageView;
    Button detailsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_overview);

        nameTextView = findViewById(R.id.name_overview_textView);
        descriptionTextView = findViewById(R.id.hero_description_TV);
        heroImageView = findViewById(R.id.hero_overview_imageview);
        detailsButton = findViewById(R.id.details_button);

        Bundle bundle = getIntent().getBundleExtra("bundle");

        if (bundle != null) {
            Timber.d("BUNDLE NOT NULL frag");
            if (bundle.containsKey("hero")) {
                Hero hero = Parcels.unwrap(bundle.getParcelable("hero"));

                if (hero != null) {
                    Timber.d("HERO NOT NULL frag");
                    nameTextView.setText(hero.name);
                    descriptionTextView.setText(hero.description);
                    Picasso.get().load(hero.imagePath).into(heroImageView);

                    detailsButton.setOnClickListener(v -> {
                        Intent moreDetailsIntent = new Intent(Intent.ACTION_VIEW);
                        moreDetailsIntent.setData(Uri.parse(hero.detailsUrl));
                        startActivity(moreDetailsIntent);
                    });
                }
            } else {
                Timber.d("NO HERO KEY");
            }
        }
    }
}
