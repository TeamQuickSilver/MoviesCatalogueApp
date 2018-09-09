package com.quicksilver.moviesapp.views;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.about.AboutUsActivity;
import com.quicksilver.moviesapp.views.movieCreate.MoviesCreateActivity;
import com.quicksilver.moviesapp.views.movieGenres.MoviesGenresActivity;
import com.quicksilver.moviesapp.views.movieHome.HomeActivity;
import com.quicksilver.moviesapp.views.moviesList.MoviesListActivity;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {
    }

    public void setupDrawer() {
        PrimaryDrawerItem homeMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(HomeActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_home)
                .withName("Home");
        PrimaryDrawerItem listMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesListActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_local_movies)
                .withName("Movies");
        PrimaryDrawerItem createMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesCreateActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_movie_creation)
                .withName("Create movie");
        PrimaryDrawerItem genresMoviesItem = new PrimaryDrawerItem()
                .withIdentifier(MoviesGenresActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_local_activity)
                .withName("Genres movie");
        PrimaryDrawerItem aboutUsItem = new PrimaryDrawerItem()
                .withIdentifier(AboutUsActivity.IDENTIFIER)
                .withIcon(GoogleMaterial.Icon.gmd_info)
                .withName("About Us");

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .build();

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withSliderBackgroundColor(Color.GRAY)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        homeMoviesItem,
                        new DividerDrawerItem(),
                        listMoviesItem,
                        createMoviesItem,
                        genresMoviesItem,
                        aboutUsItem
                ).withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    int identifier = (int) drawerItem.getIdentifier();

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
            case HomeActivity.IDENTIFIER:
                intent = new Intent(this, HomeActivity.class);
                break;
            case MoviesListActivity.IDENTIFIER:
                intent = new Intent(this, MoviesListActivity.class);
                break;
            case MoviesCreateActivity.IDENTIFIER:
                intent = new Intent(this, MoviesCreateActivity.class);
                break;
            case MoviesGenresActivity.IDENTIFIER:
                intent = new Intent(this, MoviesGenresActivity.class);
                break;
            case AboutUsActivity.IDENTIFIER:
                intent = new Intent(this, AboutUsActivity.class);
                break;
            default:
                break;
        }

        return intent;
    }

    protected abstract int getIdentifier();

    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
