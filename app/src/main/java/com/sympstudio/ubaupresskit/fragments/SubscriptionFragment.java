package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sympstudio.ubaupresskit.R;

public class SubscriptionFragment extends Fragment {

    public SubscriptionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. Link XML to Subscription Fragment
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);

        // 2. Find all IDs of inputs
        EditText nameInput = view.findViewById(R.id.name_input);
        EditText emailInput = view.findViewById(R.id.email_input);

        CheckBox option1 = view.findViewById(R.id.subscription_option_1);
        CheckBox option2 = view.findViewById(R.id.subscription_option_2);
        CheckBox option3 = view.findViewById(R.id.subscription_option_3);
        CheckBox option4 = view.findViewById(R.id.subscription_option_4);

        Button subscribeButton = view.findViewById(R.id.subscribe_button);

        // 3. onclick method for Subscribe Button
        subscribeButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();

            // Check the fields
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(getContext(), "Fill out all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Store data to DB and send the rewards
                String message = "Thank you, " + name + "! your rewards has been sent to " + email + ".";
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                // Clear all fields
                nameInput.setText("");
                emailInput.setText("");
                option1.setChecked(true);
                option2.setChecked(false);
                option3.setChecked(false);
                option4.setChecked(false);
                if (getActivity() != null) {
                    // Return to Home Page after submit button clicked
                    getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    getParentFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new HomeFragment())
                            .commit();
                }
            }
        });

        return view;
    }
}