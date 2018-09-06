package com.quicksilver.moviesapp.views.movieCreate;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesCreateFragment extends Fragment implements MovieCreateContracts.View {
    private MovieCreateContracts.Navigator mNavigator;
    private MovieCreateContracts.Presenter mPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.relative_layout)
    RelativeLayout mRelativeLayout;

    @Inject
    public MoviesCreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies_create, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(MovieCreateContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showForm() {

    }

    @Override
    public void showCreatedMovie(Movie movie) {
        mNavigator.navigateWith(movie);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRelativeLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
        mRelativeLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void setNavigator(MovieCreateContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error " + error.getMessage(), Toast.LENGTH_LONG).show();
    }
}