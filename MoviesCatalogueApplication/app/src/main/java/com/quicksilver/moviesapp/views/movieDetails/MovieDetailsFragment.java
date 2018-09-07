package com.quicksilver.moviesapp.views.movieDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.models.Movie;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailsFragment extends Fragment implements MovieDetailsContracts.View {
    private MovieDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_title)
    TextView mTextViewTitle;

    @BindView(R.id.iv_wallpaper)
    ImageView mImageViewWallpaper;

    @BindView(R.id.tv_cast)
    TextView mTextViewCast;

    @BindView(R.id.tv_description)
    TextView mTextViewDescription;

    @BindView(R.id.tv_category)
    TextView mTextCategory;

    @Inject
    public MovieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(MovieDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMovie(Movie movie) {
        mTextViewTitle.setText(movie.getTitle());

        Picasso.get()
                .load(movie.getImageUrl())
                .into(mImageViewWallpaper);

        mTextCategory.setText(movie.getCategory());
        mTextViewCast.setText(movie.getCast());
        mTextViewDescription.setText(movie.getDescription());
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(),
                Toast.LENGTH_SHORT).show();
    }
}
