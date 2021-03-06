package com.quicksilver.moviesapp.views.movieHome;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeContracts.View, HomeAdapter.onMovieClickListener {
    private HomeContracts.Presenter mPresenter;
    private HomeContracts.Navigator mNavigator;
    private GridLayoutManager mMoviesViewLayoutManager;

    @BindView(R.id.rv_movies)
    RecyclerView mRecyclerViewMovies;

    @Inject
    HomeAdapter mMoviesAdapter;

    @Inject
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        mMoviesAdapter.setOnMovieClickListener(this);
        mRecyclerViewMovies.setAdapter(mMoviesAdapter);

        mMoviesViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerViewMovies.setLayoutManager(mMoviesViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadLatestMovies();
    }

    @Override
    public void setPresenter(HomeContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setNavigator(HomeContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showLatestMovies(List<Movie> movies) {
        mMoviesAdapter.clear();
        mMoviesAdapter.addAll(movies);

        mMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMovieDetails(Movie movie) {
        mNavigator.navigateWith(movie);
    }

    @Override
    public void onClick(Movie movie) {
        mPresenter.selectMovie(movie);
    }
}
