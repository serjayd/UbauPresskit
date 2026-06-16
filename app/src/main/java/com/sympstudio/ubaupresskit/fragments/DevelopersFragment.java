package com.sympstudio.ubaupresskit.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.sympstudio.ubaupresskit.R;

public class DevelopersFragment extends Fragment {

    public DevelopersFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developers, container, false);

        // Get all Links IDs

        // Serjay
        TextView serjayGithub = view.findViewById(R.id.serjay_github);
        TextView serjayLinkedin = view.findViewById(R.id.serjay_linkedin);
        serjayGithub.setOnClickListener(v -> openWebPage("https://github.com/serjayd"));
        serjayLinkedin.setOnClickListener(v -> openWebPage("https://www.linkedin.com/in/serjayantsibor/"));

        // Pavlo
        TextView pavloGithub = view.findViewById(R.id.pavlo_github);
        TextView pavloLinkedin = view.findViewById(R.id.pavlo_linkedin);
        pavloGithub.setOnClickListener(v -> openWebPage("https://github.com/"));
        pavloLinkedin.setOnClickListener(v -> openWebPage("https://linkedin.com/in/"));

        // Merve
        TextView merveGithub = view.findViewById(R.id.merve_github);
        TextView merveLinkedin = view.findViewById(R.id.merve_linkedin);
        merveGithub.setOnClickListener(v -> openWebPage("https://github.com/"));
        merveLinkedin.setOnClickListener(v -> openWebPage("https://linkedin.com/in/"));

        // Yulia
        TextView yuliaGithub = view.findViewById(R.id.yulia_github);
        TextView yuliaLinkedin = view.findViewById(R.id.yulia_linkedin);
        yuliaGithub.setOnClickListener(v -> openWebPage("https://github.com/"));
        yuliaLinkedin.setOnClickListener(v -> openWebPage("https://linkedin.com/in/"));

        // Get all Follow Us links IDs
        View linkDiscord = view.findViewById(R.id.link_discord);
        View linkYoutube = view.findViewById(R.id.link_youtube);
        View linkX = view.findViewById(R.id.link_x);
        View linkInstagram = view.findViewById(R.id.link_instagram);

        linkDiscord.setOnClickListener(v -> openWebPage("https://discord.gg/"));
        linkYoutube.setOnClickListener(v -> openWebPage("https://youtube.com/"));
        linkX.setOnClickListener(v -> openWebPage("https://x.com/"));
        linkInstagram.setOnClickListener(v -> openWebPage("https://instagram.com/"));

        return view;
    }
    // Open links in browser
    private void openWebPage(String url) {
        if (url == null || url.isEmpty()) return;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivity(Intent.createChooser(intent, "Open with"));
    }
}