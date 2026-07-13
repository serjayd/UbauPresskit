package com.sympstudio.ubaupresskit.fragments;
import android.view.View;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

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

        View card1 = view.findViewById(R.id.goodies_card_1_container);
        View card2 = view.findViewById(R.id.goodies_card_2_container);
        View card3 = view.findViewById(R.id.goodies_card_4_container);

        animateCard(card1, 0);
        animateCard(card2, 150);
        animateCard(card3, 300);
        animatePage(view);

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

    private void animateCard(View view, int delay) {

        view.setAlpha(0f);
        view.setTranslationY(80f);

        view.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(500)
                .setStartDelay(delay)
                .start();
    }

    private void animatePage(View view) {

        view.setAlpha(0f);
        view.setTranslationY(30f);

        view.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(500)
                .setInterpolator(new android.view.animation.DecelerateInterpolator())
                .start();
    }
}