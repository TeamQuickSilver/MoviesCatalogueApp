package com.quicksilver.moviesapp.views.movieGenres;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quicksilver.moviesapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorrorGenreFragment extends Fragment {


    public HorrorGenreFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horror_genre, container, false);
    }

}
