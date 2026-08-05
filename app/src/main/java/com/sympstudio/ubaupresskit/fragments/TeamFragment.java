package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import com.sympstudio.ubaupresskit.R;

public class TeamFragment extends Fragment {

    public TeamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_team, container, false);

        // Animation for Page
        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        view.startAnimation(animPage);


        ListView listView = view.findViewById(R.id.team_cards);
        listView.setNestedScrollingEnabled(true);

        int[] images = {
                R.drawable.yohan,
                R.drawable.campbell,
                R.drawable.yohan,
                R.drawable.yohan,
                R.drawable.florinavatar,
                R.drawable.sadik,
                R.drawable.ali,
                R.drawable.meimei_avatar,
                R.drawable.kyrah,
                R.drawable.yohan
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
                "Designed gameplay mechanics, balanced features, and coordinated the overall game vision.",
                "Implemented core gameplay systems and player controls.",
                "Developed enemy AI and game logic.",
                "Integrated UI functionality and managed game state.",
                "Optimized performance, fixed bugs, and handled technical improvements.",
                "Created character concept art and visual assets.",
                "Designed environments, backgrounds, and level artwork.",
                "Produced animations and visual effects.",
                "Planned level design, game progression, and feature requirements.",
                "Designed the user interface and icons for a consistent visual experience."
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