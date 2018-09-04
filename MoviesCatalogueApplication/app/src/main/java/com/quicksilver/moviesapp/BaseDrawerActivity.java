package com.quicksilver.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.quicksilver.moviesapp.views.movieList.MoviesListActivity;

public abstract class BaseDrawerActivity extends AppCompatActivity{
    private Toolbar mToolbar;

    public BaseDrawerActivity() {
    }

    public void setupDrawer() {
        PrimaryDrawerItem listMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesListActivity.IDENTIFIER)
                .withName("Movies");

//        PrimaryDrawerItem secondMoviesItem = new PrimaryDrawerItem()
//                .withIdentifier("TODO")
//                .withIcon(android.R.drawable.btn_plus)
//                .withName("TODO");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this).withToolbar(getDrawerToolbar()).addDrawerItems(
                        listMoviesItem,
                        new DividerDrawerItem()
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);

                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                }).build();
    }

    private  Intent getNextIntent(long identifier) {
        //TODO
        return new Intent(this, MoviesListActivity.class);
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
