package com.onramp.android.takehome.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.Hero;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import timber.log.Timber;

public class MainRecyclerviewAdapter extends RecyclerView.Adapter<MainRecyclerviewAdapter.ViewHolder> {

    private Context mContext;
    private List<Hero> mHeroesList;


    public MainRecyclerviewAdapter(Context context, List<Hero> heroesList) {
        this.mContext = context;
        this.mHeroesList = heroesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.hero_list_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Hero currentHero = mHeroesList.get(i);

        viewHolder.progressBar.setVisibility(View.VISIBLE);

        Picasso.get().load(currentHero.imagePath)
                .placeholder(R.drawable.hero_image_placeholder).fit()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .centerCrop().fit().into(viewHolder.imageView, new Callback() {
            @Override
            public void onSuccess() {
                viewHolder.progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Exception e) {
                viewHolder.progressBar.setVisibility(View.INVISIBLE);
                Snackbar snackbar =
                        Snackbar.make(viewHolder.coordinatorLayout, "No network available to download image", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });
        Timber.d("image path is: %s", currentHero.imagePath);
        viewHolder.nameTextview.setText(currentHero.name);

        viewHolder.constraintLayout.setOnClickListener(v -> {
            Intent goToOverviewIntent = new Intent(mContext, HeroOverviewActivity.class);

            goToOverviewIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putParcelable("hero", Parcels.wrap(currentHero));
            goToOverviewIntent.putExtra("bundle", bundle);
            mContext.startActivity(goToOverviewIntent);
        });
    }

    @Override
    public int getItemCount() {
        return mHeroesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextview;
        ImageView imageView;
        ConstraintLayout constraintLayout;
        ProgressBar progressBar;
        CoordinatorLayout coordinatorLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextview = itemView.findViewById(R.id.item_textView);
            imageView = itemView.findViewById(R.id.item_imageView);
            constraintLayout = itemView.findViewById(R.id.item_constraint_layout);
            progressBar = itemView.findViewById(R.id.listitem_progressBar);
            coordinatorLayout = itemView.findViewById(R.id.list_item_coordinator);
        }
    }
}
