package com.sympstudio.ubaupresskit.fragments;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.R;

public class PresskitFragment extends Fragment {

    public PresskitFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_presskit, container, false);

        LinearLayout card1 = view.findViewById(R.id.presskit_data);
        LinearLayout card2 = view.findViewById(R.id.presskit_synopsis);
        LinearLayout card3 = view.findViewById(R.id.presskit_images);
        LinearLayout card4 = view.findViewById(R.id.presskit_videos);
        LinearLayout card5 = view.findViewById(R.id.presskit_character_art);
        LinearLayout card6 = view.findViewById(R.id.presskit_key_art);
        LinearLayout card7 = view.findViewById(R.id.presskit_gifs);
        LinearLayout card8 = view.findViewById(R.id.presskit_brand);

        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim1.setStartOffset(0);

        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim2.setStartOffset(0);

        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim3.setStartOffset(150);

        Animation anim4 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim4.setStartOffset(300);

        Animation anim5 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim5.setStartOffset(450);

        Animation anim6 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim6.setStartOffset(600);

        Animation anim7 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim7.setStartOffset(750);

        Animation anim8 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_side);
        anim8.setStartOffset(900);

        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        card1.startAnimation(anim1);
        card2.startAnimation(anim2);
        card3.startAnimation(anim3);
        card4.startAnimation(anim4);
        card5.startAnimation(anim5);
        card6.startAnimation(anim6);
        card7.startAnimation(anim7);
        card8.startAnimation(anim8);
        view.startAnimation(animPage);


        // Set up each accordion section (header + content + chevron)
        setupAccordion(view, R.id.headerSynopsis, R.id.contentSynopsis, R.id.chevronSynopsis);
        setupAccordion(view, R.id.headerVideos, R.id.contentVideos, R.id.chevronVideos);
        setupAccordion(view, R.id.headerImages, R.id.contentImages, R.id.chevronImages);
        setupAccordion(view, R.id.headerCharacterArt, R.id.contentCharacterArt, R.id.chevronCharacterArt);
        setupAccordion(view, R.id.headerKeyArt, R.id.contentKeyArt, R.id.chevronKeyArt);
        setupAccordion(view, R.id.headerGifs, R.id.contentGifs, R.id.chevronGifs);
        setupAccordion(view, R.id.headerBrand, R.id.contentBrand, R.id.chevronBrand);
        setupAccordion(view, R.id.headerPhysical, R.id.contentPhysical, R.id.chevronPhysical);
        setupAccordion(view, R.id.headerCreators, R.id.contentCreators, R.id.chevronCreators);
        setupAccordion(view, R.id.headerCredits, R.id.contentCredits, R.id.chevronCredits);

        // Download button
        TextView btnDownload = view.findViewById(R.id.btnDownloadPresskit);
        if (btnDownload != null) {
            btnDownload.setOnClickListener(v ->
                    Toast.makeText(getContext(), "Press kit download coming soon", Toast.LENGTH_SHORT).show());
        }

        return view;
    }

    // Opens or closes a section when its header is tapped
    private void setupAccordion(View view, int headerId, int contentId, int chevronId) {
        View header = view.findViewById(headerId);
        View content = view.findViewById(contentId);
        ImageView chevron = view.findViewById(chevronId);

        if (header == null || content == null || chevron == null) {
            return;
        }

        header.setOnClickListener(v -> {
            if (content.getVisibility() == View.GONE) {
                content.setVisibility(View.VISIBLE);
                chevron.setRotation(180f); // point the arrow up when open
            } else {
                content.setVisibility(View.GONE);
                chevron.setRotation(0f); // back to pointing down when closed
            }
        });
    }
}