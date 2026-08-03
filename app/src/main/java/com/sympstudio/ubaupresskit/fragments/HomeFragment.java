package com.sympstudio.ubaupresskit.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.R;

public class HomeFragment extends Fragment {

    private static final String PS_STORE_URL = "https://store.playstation.com/en-gb/";

    private VideoView homeVideo;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Background trailer video (silent, looping, auto-play)
        homeVideo = view.findViewById(R.id.homeVideo);

        if (homeVideo != null) {
            Uri videoUri = Uri.parse("android.resource://" + requireContext().getPackageName()
                    + "/" + R.raw.trailer1);
            homeVideo.setVideoURI(videoUri);

            homeVideo.setOnPreparedListener(mediaPlayer -> {
                mediaPlayer.setVolume(0f, 0f); // mute the audio
                mediaPlayer.setLooping(true);  // loop the video
                homeVideo.start();             // auto-play
            });
        }

        LinearLayout card1 = view.findViewById(R.id.home_details);
        LinearLayout card2 = view.findViewById(R.id.home_testimonal_1);
        LinearLayout card3 = view.findViewById(R.id.home_buy);

        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim1.setStartOffset(0);

        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim2.setStartOffset(150);

        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim3.setStartOffset(300);

        Animation anim4 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        anim4.setStartOffset(300);

        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        homeVideo.startAnimation(anim1);
        card1.startAnimation(anim2);
        card2.startAnimation(anim3);
        card3.startAnimation(anim4);
        view.startAnimation(animPage);


        TextView btnBuyNow = view.findViewById(R.id.btnBuyNow);

        if (btnBuyNow != null) {
            btnBuyNow.setOnClickListener(v -> openUrl(PS_STORE_URL));
        }

        ImageView psIcon = view.findViewById(R.id.psIcon);
        ImageView microsoftIcon = view.findViewById(R.id.microsoftIcon);

        if (psIcon != null) {
            psIcon.setOnClickListener(v -> openUrl(PS_STORE_URL));
        }

        if (microsoftIcon != null) {
            microsoftIcon.setOnClickListener(v -> openUrl("https://www.microsoft.com/en-gb/store/"));
        }

        return view;
    }

    private void openUrl(String url) {
        new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("External Website")
                .setMessage("You are about to leave the app and open an external website. Do you want to continue?")
                .setPositiveButton("Proceed", (dialog, which) -> {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(getContext(), "Unable to open the link", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setCancelable(true)
                .show();
    }
}