package com.quicksilver.moviesapp.views.movieList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> mMovies;
    private onMovieClickListener mOnMovieClickListener;

    public MoviesAdapter() {
        this.mMovies = new ArrayList<>();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        int height = parent.getMeasuredHeight() / 3;

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
        view.setMinimumHeight(height);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setOnMovieClickListener(mOnMovieClickListener);
        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public Movie getItem(int position) {
        return mMovies.get(position);
    }

    public void clear() {
        mMovies.clear();
    }

    public void addAll(List<Movie> movies) {
        mMovies.addAll(movies);
    }

    public void setmOnMovieClickListener(onMovieClickListener mOnMovieClickListener) {
        this.mOnMovieClickListener = mOnMovieClickListener;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_movie)
        ImageView mImageView;

        @BindView(R.id.tv_title)
        TextView mTitleTextView;

        private Movie mMovie;
        private onMovieClickListener mOnClickListener;

        public MovieViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Movie movie) {
            mTitleTextView.setText(movie.getName());

            Picasso.get().load(movie.getImageUrl()).into(mImageView);

            mMovie = movie;
        }

        public void onClick() {
            mOnClickListener.onClick(mMovie);
        }

        public void setOnMovieClickListener(onMovieClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface onMovieClickListener {
        void onClick(Movie movie);
    }
}