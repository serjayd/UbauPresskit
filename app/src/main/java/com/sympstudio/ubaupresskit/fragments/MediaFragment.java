package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sympstudio.ubaupresskit.R;

public class MediaFragment extends Fragment {

    public MediaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 1. Inflate the layout once and keep a reference to it
        View view = inflater.inflate(R.layout.fragment_media, container, false);

        // 2. Use 'View' instead of 'LinearLayout' to avoid ClassCastException
        View card1 = view.findViewById(R.id.trailerImage);
        View card2 = view.findViewById(R.id.media_videos);
        View card3 = view.findViewById(R.id.media_images);

        // Animation for Cards
        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim1.setStartOffset(0);

        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim2.setStartOffset(250);

        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim3.setStartOffset(400);

        // Animation for Page
        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        // Trigger animations
        card1.startAnimation(anim1);
        card2.startAnimation(anim2);
        card3.startAnimation(anim3);
        view.startAnimation(animPage);

        // 3. Return the exact view instance we just set up
        return view;
    }
}
