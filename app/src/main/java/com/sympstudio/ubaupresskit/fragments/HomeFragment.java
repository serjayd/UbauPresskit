package com.sympstudio.ubaupresskit.fragments;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.R;

public class HomeFragment extends Fragment {

    private static final String PS_STORE_URL = "https://store.playstation.com/en-gb/";

    private TextureView homeVideo;
    private MediaPlayer mediaPlayer;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeVideo = view.findViewById(R.id.homeVideo);

        homeVideo.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {

            @Override
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface,
                                                  int width,
                                                  int height) {

                try {
                    Surface videoSurface = new Surface(surface);

                    mediaPlayer = MediaPlayer.create(requireContext(), R.raw.trailer1);
                    mediaPlayer.setSurface(videoSurface);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.setVolume(0f, 0f);
                    mediaPlayer.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface,
                                                    int width,
                                                    int height) {
            }

            @Override
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {

                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }

                return true;
            }

            @Override
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {
            }
        });

        LinearLayout card1 = view.findViewById(R.id.home_details);
        LinearLayout card2 = view.findViewById(R.id.home_testimonal_1);
        LinearLayout card3 = view.findViewById(R.id.home_buy);

        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        Animation anim4 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        anim2.setStartOffset(150);
        anim3.setStartOffset(300);
        anim4.setStartOffset(450);

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
            microsoftIcon.setOnClickListener(v ->
                    openUrl("https://www.microsoft.com/en-gb/store/"));
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void openUrl(String url) {

        new AlertDialog.Builder(requireContext())
                .setTitle("External Website")
                .setMessage("You are about to leave the app and open an external website. Continue?")
                .setPositiveButton("Proceed", (dialog, which) -> {

                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    } catch (Exception e) {
                        Toast.makeText(getContext(),
                                "Unable to open link",
                                Toast.LENGTH_SHORT).show();
                    }

                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}