package com.sympstudio.ubaupresskit.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.sympstudio.ubaupresskit.R;

public class DevelopersFragment extends Fragment {

    public DevelopersFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_developers, container, false);


        ListView listView = view.findViewById(R.id.developer_cards);


        int[] images = {
                R.drawable.serjay_img,
                R.drawable.merve_img,
                R.drawable.pavlo_img,
                R.drawable.yulia_img,
        };


        String[] names = {
                "Serjay Antsibor",
                "Merve Uzuner",
                "Pavlo Bairamkulov",
                "Yuliia Haponchak",
        };


        String[] descriptions = {
                "Worked on the app's core systems, navigation, and helped shape the overall experience",
                "Designed the interface and gave the app its clean, polished look",
                "Built and improved the app's functionality, making sure everything runs smoothly",
                "Implemented features, tested gameplay, and squashed bugs along the way",
        };

        String[] githubLinks = {
                "https://github.com/serjayd",
                "https://github.com/Mervellious",
                "https://github.com/Paul-webd",
                "https://github.com/YuliiaHaponchak"
        };

        String[] linkedinLinks = {
                "https://www.linkedin.com/in/serjayantsibor",
                "https://www.linkedin.com/in/merve-uzuner/",
                "https://www.linkedin.com/in/",
                "https://www.linkedin.com/in/"
        };


        developerAdapter adapter = new developerAdapter(
                getContext(),
                images,
                names,
                descriptions,
                githubLinks,
                linkedinLinks
        );


        listView.setAdapter(adapter);


        return view;
    }
}