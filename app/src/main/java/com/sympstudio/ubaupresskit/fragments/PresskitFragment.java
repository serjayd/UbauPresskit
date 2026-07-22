package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        TextView content = view.findViewById(contentId);
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