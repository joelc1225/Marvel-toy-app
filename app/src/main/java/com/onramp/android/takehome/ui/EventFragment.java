package com.onramp.android.takehome.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.databinding.FragmentEventDetailBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Timber.d("FRAG ONCREATEVIEW starting ****");

        FragmentEventDetailBinding binding = FragmentEventDetailBinding.inflate(inflater, container, false);
        View view =  binding.getRoot();

        Bundle bundle = getArguments();
        binding.eventFragDetailProgressbar.setVisibility(View.VISIBLE);

        // Inflates views depending on what event was clicked in the EventsActivity
        if (bundle != null) {
            Timber.d("FRAG BUNDLE NOT NULL");
            switch (Objects.requireNonNull(bundle.getString("eventKey"))) {
                case "sd":
                    Timber.d("FOUND SD KEY");
                    binding.fragEventName.setText(getString(R.string.san_diego_comic_con));
                    Picasso.get().load(getString(R.string.san_diego_imageUrl))
                            .placeholder(R.drawable.hero_image_placeholder)
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .networkPolicy(NetworkPolicy.NO_CACHE)
                            .into(binding.fragEventImage, new Callback() {
                                @Override
                                public void onSuccess() {
                                    binding.eventFragDetailProgressbar.setVisibility(View.INVISIBLE);
                                }

                                @Override
                                public void onError(Exception e) {
                                    binding.eventFragDetailProgressbar.setVisibility(View.INVISIBLE);
                                    Snackbar snackbar =
                                            Snackbar.make(binding.eventDetailCoordinator, "No network available to download image", Snackbar.LENGTH_LONG);
                                    snackbar.show();
                                }
                            });
                    binding.fragEventDate.setText(getString(R.string.sd_event_date));
                    binding.fragEventLocationTV.setText(getString(R.string.sd_event_location));
                    binding.fragLearnMoreButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent eventDetailsIntent = new Intent(Intent.ACTION_VIEW);
                            eventDetailsIntent.setData(Uri.parse(getString(R.string.comiccon_sanDiego_url)));
                            startActivity(eventDetailsIntent);
                        }
                    });
                    break;
                case "ny":
                    Timber.d("FOUND NY KEY");

                    binding.fragEventName.setText(this.getString(R.string.new_york_comic_con));
                    Picasso.get().load(this.getString(R.string.ny_imageUrl))
                            .placeholder(R.drawable.hero_image_placeholder)
                            .memoryPolicy(MemoryPolicy.NO_CACHE)
                            .networkPolicy(NetworkPolicy.NO_CACHE)
                            .into(binding.fragEventImage);
                    binding.fragEventDate.setText(this.getString(R.string.ny_event_date));
                    binding.fragEventLocationTV.setText(this.getString(R.string.ny_event_location));
                    binding.fragLearnMoreButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent eventDetailsIntent = new Intent(Intent.ACTION_VIEW);
                            eventDetailsIntent.setData(Uri.parse(getString(R.string.comicon_ny_url)));
                            startActivity(eventDetailsIntent);
                        }
                    });
                    break;
                default:
                    Timber.d("*** Key not found ******");
                    break;
            }
        }
        return view;


    }

}
