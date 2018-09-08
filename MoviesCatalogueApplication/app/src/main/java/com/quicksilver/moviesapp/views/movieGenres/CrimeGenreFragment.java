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
public class CrimeGenreFragment extends Fragment {
    private static final String TAG = "CrimeGenreFragment";


    public CrimeGenreFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_crime_genre, container, false);

        return view;
    }

}
