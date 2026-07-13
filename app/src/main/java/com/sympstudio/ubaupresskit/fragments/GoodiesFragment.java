package com.sympstudio.ubaupresskit.fragments;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import static com.sympstudio.ubaupresskit.R.*;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

        // Containers for Animation
        LinearLayout card1 = view.findViewById(R.id.goodies_card_1_container);
        LinearLayout card2 = view.findViewById(R.id.goodies_card_2_container);
        LinearLayout card3 = view.findViewById(R.id.goodies_card_4_container);

        // Animation for Cards
        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim1.setStartOffset(0);

        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim2.setStartOffset(150);

        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim3.setStartOffset(300);

        // Animation for Page
        Animation animPage = AnimationUtils.loadAnimation(getContext(), anim.fade_in);

        card1.startAnimation(anim1);
        card2.startAnimation(anim2);
        card3.startAnimation(anim3);
        view.startAnimation(animPage);


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