package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import com.sympstudio.ubaupresskit.R;

public class GoodiesFragment extends Fragment {

    public GoodiesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Get the Goodies Fragment Layout
        View view = inflater.inflate(R.layout.fragment_goodies, container, false);

        // Get the IDs of all buttons
        AppCompatButton btnCard1 = view.findViewById(R.id.goodies_button_card_1);
        AppCompatButton btnCard2 = view.findViewById(R.id.goodies_button_card_2);
        AppCompatButton btnCard3 = view.findViewById(R.id.goodies_button_card_3);
        AppCompatButton btnCard4 = view.findViewById(R.id.goodies_button_card_4);

        // onClick method to transfer to Subscription Fragment (e.g., page)
        btnCard1.setOnClickListener(v -> openSubscriptionPage());
        btnCard2.setOnClickListener(v -> openSubscriptionPage());
        btnCard3.setOnClickListener(v -> openSubscriptionPage());
        btnCard4.setOnClickListener(v -> openSubscriptionPage());

        return view;
    }

    // Method for Subscription Fragment
    private void openSubscriptionPage() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SubscriptionFragment())
                    .commit();
        }
    }
}