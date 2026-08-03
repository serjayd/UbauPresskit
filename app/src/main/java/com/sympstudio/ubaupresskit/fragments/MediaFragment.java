package com.sympstudio.ubaupresskit.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.R;

public class MediaFragment extends Fragment {

    public MediaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_media, container, false);


        VideoView videoView = view.findViewById(R.id.homeVideo);

        MediaController mediaController = new MediaController(requireContext());
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("android.resource://"
                + requireContext().getPackageName()
                + "/"
                + R.raw.trailer1);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);

        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            videoView.start();
        });


        View card1 = view.findViewById(R.id.homeVideo);
        View card2 = view.findViewById(R.id.media_videos);
        View card3 = view.findViewById(R.id.media_images);

        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim1.setStartOffset(0);

        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim2.setStartOffset(250);

        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim3.setStartOffset(400);

        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        card1.startAnimation(anim1);
        card2.startAnimation(anim2);
        card3.startAnimation(anim3);
        view.startAnimation(animPage);

        return view;
    }
}