package com.quicksilver.moviesapp.views;

import android.content.Intent;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.quicksilver.moviesapp.views.movieCreate.MoviesCreateActivity;
import com.quicksilver.moviesapp.views.moviesList.MoviesListActivity;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity{

    public BaseDrawerActivity() {
    }

    public void setupDrawer() {
        PrimaryDrawerItem listMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesListActivity.IDENTIFIER)
                .withName("Movies");
        PrimaryDrawerItem createMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesCreateActivity.IDENTIFIER)
                .withName("Create movie");

//        PrimaryDrawerItem secondMoviesItem = new PrimaryDrawerItem()
//                .withIdentifier("TODO")
//                .withIcon(android.R.drawable.btn_plus)
//                .withName("TODO");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .addDrawerItems(
                        listMoviesItem,
                        new DividerDrawerItem(),
                        createMoviesItem
                ).withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    int identifier = (int)drawerItem.getIdentifier();

                    if (getIdentifier() == identifier) {
                        return false;
                    }

                    Intent intent = getNextIntent(identifier);

                    if (intent == null) {
                        return false;
                    }

                    startActivity(intent);
                    return true;
                }).build();
    }

    private Intent getNextIntent(int identifier) {
        Intent intent = null;

        switch (identifier) {
            case MoviesListActivity.IDENTIFIER:
                intent = new Intent(this, MoviesListActivity.class);
                break;
            case MoviesCreateActivity.IDENTIFIER:
                intent = new Intent(this, MoviesCreateActivity.class);
                break;
        }

        return intent;
    }

    protected abstract int getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
