package com.onramp.android.takehome.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.utils.HeroHelper;
import com.onramp.android.takehome.utils.InjectorUtils;
import com.onramp.android.takehome.vm.HeroesViewModel;
import com.onramp.android.takehome.vm.HeroesViewModelFactory;

public class MainActivity extends AppCompatActivity {

    HeroesViewModel heroesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Creates ViewModel
        HeroesViewModelFactory factory = new HeroesViewModelFactory(InjectorUtils.provideRepository(this));
        heroesViewModel = ViewModelProviders.of(this, factory).get(HeroesViewModel.class);
        heroesViewModel.setHeroes(HeroHelper.getHeroes(this));
        bindUi();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_events) {
            Intent startEventsActivity = new Intent(this, EventsActivity.class);
            startActivity(startEventsActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void bindUi() {
        RecyclerView recyclerView = findViewById(R.id.hero_RV);
        MainRecyclerviewAdapter adapter =
                new MainRecyclerviewAdapter(this, heroesViewModel.getHeroes());
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }
}
