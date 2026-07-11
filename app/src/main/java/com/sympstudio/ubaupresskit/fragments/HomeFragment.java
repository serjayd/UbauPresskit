package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.R;

public class HomeFragment extends Fragment {

    private static final String PS_STORE_URL = "https://store.playstation.com/en-gb/";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

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
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Bağlantı açılamadı", Toast.LENGTH_SHORT).show();
        }
    }
}