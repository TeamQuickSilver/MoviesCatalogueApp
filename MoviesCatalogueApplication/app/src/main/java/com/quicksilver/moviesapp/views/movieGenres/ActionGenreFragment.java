package com.quicksilver.moviesapp.views.movieGenres;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class ActionGenreFragment extends Fragment implements MovieGenreContracts.View, MoviesGenreAdapter.onMovieClickListener{
    public static final String TITLE = "Action";

    @BindView(R.id.rv_movies)
    RecyclerView mRecyclerViewMovies;

    private MovieGenreContracts.Navigator mNavigator;

    @Inject
    MoviesGenreAdapter mMoviesAdapter;

    private GridLayoutManager mMoviesViewLayoutManager;
    private MovieGenreContracts.Presenter mPresenter;

    @Inject
    public ActionGenreFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_action_genre, container, false);

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
        mPresenter.filterMovies(TITLE);
    }

    @Override
    public void setPresenter(MovieGenreContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMovies(List<Movie> movies) {
        mMoviesAdapter.clear();
        mMoviesAdapter.addGenreMovies(movies);

        // refresh changes
        mMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void setNavigator(MovieGenreContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void showMovieDetails(Movie movie) {
        mNavigator.navigateWith(movie);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(Movie movie) {
        mPresenter.selectMovie(movie);
    }
}


