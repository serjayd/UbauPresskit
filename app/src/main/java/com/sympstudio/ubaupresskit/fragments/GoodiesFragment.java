package com.sympstudio.ubaupresskit.fragments;

import static com.sympstudio.ubaupresskit.R.*;

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
        AppCompatButton btnSubscribe = view.findViewById(R.id.goodies_button_subscribe);

        // onClick method to transfer to Subscription Fragment (e.g., page)
        btnSubscribe.setOnClickListener(v -> openSubscriptionPage());

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