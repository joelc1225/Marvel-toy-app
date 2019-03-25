package com.onramp.android.takehome.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.databinding.ActivityEventsBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class EventsActivity extends AppCompatActivity {

    ActivityEventsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_events);

        Picasso.get().load(this.getString(R.string.san_diego_imageUrl))
                .placeholder(R.drawable.hero_image_placeholder)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(binding.sandDiegoImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        binding.eventOverviewTopProgressbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                        binding.eventOverviewTopProgressbar.setVisibility(View.INVISIBLE);
                        Snackbar snackbar = Snackbar.make(binding.eventsActivityCoordinator, "No network to download image", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                });

        Picasso.get().load(this.getString(R.string.ny_imageUrl))
                .placeholder(R.drawable.hero_image_placeholder)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(binding.nyImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        binding.eventOverviewBottomProgressbar.setVisibility(View.INVISIBLE);

                    }

                    @Override
                    public void onError(Exception e) {
                        binding.eventOverviewBottomProgressbar.setVisibility(View.INVISIBLE);
                        Snackbar snackbar = Snackbar.make(binding.eventsActivityCoordinator, "No network to download image", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                });

        FragmentManager fragmentManager = getSupportFragmentManager();

        binding.sdEventButton.setOnClickListener(v -> {
            Timber.d("SD EVENT BUTTON CLICKED frag should launch");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            EventFragment eventFragment = new EventFragment();
            Bundle bundle = new Bundle();
            bundle.putString("eventKey", "sd");
            eventFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.events_activity_constraintLayout, eventFragment)
                    .addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.nyEventButton.setOnClickListener(v -> {
            Timber.d("NY EVENT BUTTON CLICKED. Frag should launch");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            EventFragment eventFragment = new EventFragment();
            Bundle bundle = new Bundle();
            bundle.putString("eventKey", "ny");
            eventFragment.setArguments(bundle);
            fragmentTransaction.add(R.id.events_activity_constraintLayout, eventFragment)
            .addToBackStack(null);
            fragmentTransaction.commit();
        });
    }
}
