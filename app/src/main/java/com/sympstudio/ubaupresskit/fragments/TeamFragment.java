package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sympstudio.ubaupresskit.R;

public class TeamFragment extends Fragment {

    public TeamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team, container, false);


        ListView listView = view.findViewById(R.id.team_cards);
        listView.setNestedScrollingEnabled(true);

        int[] images = {
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground
        };


        String[] names = {
                "Rhiannon",
                "Campbell",
                "Mani",
                "Ktz",
                "Florin",
                "Sadik",
                "Ali",
                "Mei Mei",
                "Kyrah",
                "Yohan"
        };


        String[] descriptions = {
                "Game Designer",
                "Programmer",
                "Programmer",
                "Programmer",
                "Programmer",
                "Artist",
                "Artist",
                "Artist",
                "Game Designer",
                "Artist"
        };


        teamAdapter adapter = new teamAdapter(
                getContext(),
                images,
                names,
                descriptions
        );


        listView.setAdapter(adapter);


        return view;
    }
}