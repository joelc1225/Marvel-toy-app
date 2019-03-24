package com.onramp.android.takehome.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.onramp.android.takehome.R;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class EventsActivity extends AppCompatActivity {

    //    TextView sd_textView;
//    TextView ny_textView;
    ImageView sd_imageView;
    ImageView ny_imageView;
    Button sd_button;
    Button ny_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        sd_imageView = findViewById(R.id.sand_diego_imageView);
        ny_imageView = findViewById(R.id.ny_imageView);
        sd_button = findViewById(R.id.sd_event_button);
        ny_button = findViewById(R.id.ny_event_button);

        Picasso.get().load(this.getString(R.string.san_diego_imageUrl)).into(sd_imageView);
        Picasso.get().load(this.getString(R.string.ny_imageUrl)).into(ny_imageView);

        FragmentManager fragmentManager = getSupportFragmentManager();

        sd_button.setOnClickListener(v -> {
            Timber.d("SD EVENT BUTTON CLICKED frag should launch");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            EventFragment eventFragment = new EventFragment();
            Bundle bundle = new Bundle();
            bundle.putString("eventKey", "sd");
            eventFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.events_activity, eventFragment)
                    .addToBackStack(null);
            fragmentTransaction.commit();
        });

        ny_button.setOnClickListener(v -> {
            Timber.d("NY EVENT BUTTON CLICKED. Frag should launch");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            EventFragment eventFragment = new EventFragment();
            Bundle bundle = new Bundle();
            bundle.putString("eventKey", "ny");
            eventFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.events_activity, eventFragment)
            .addToBackStack(null);
            fragmentTransaction.commit();
        });
    }
}
