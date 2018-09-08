package com.quicksilver.moviesapp.views.movieHome;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.quicksilver.moviesapp.R;
import com.quicksilver.moviesapp.views.moviesList.MoviesListActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button mButton = view.findViewById(R.id.btn_to_menu);

        mButton.setOnClickListener(this);

        return view;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), MoviesListActivity.class);
        startActivity(intent);
    }

}
