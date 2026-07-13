package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.util.Patterns; // --- ADDED FOR EMAIL CHECK ---
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sympstudio.ubaupresskit.DBHelper;
import com.sympstudio.ubaupresskit.R;

public class SubscriptionFragment extends Fragment {

    public SubscriptionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);

        EditText nameInput = view.findViewById(R.id.name_input);
        EditText emailInput = view.findViewById(R.id.email_input);

        CheckBox option1 = view.findViewById(R.id.subscription_option_1);
        CheckBox option3 = view.findViewById(R.id.subscription_option_3);
        CheckBox option4 = view.findViewById(R.id.subscription_option_4);

        TextView nameError = view.findViewById(R.id.name_error);
        TextView emailError = view.findViewById(R.id.email_error);

        Button subscribeButton = view.findViewById(R.id.subscribe_button);

        subscribeButton.setOnClickListener(v -> {

            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            boolean option1Checked = option1.isChecked();
            boolean option3Checked = option3.isChecked();
            boolean option4Checked = option4.isChecked();


            // Validate Name
            if (name.isEmpty() || name.length() < 2) {
                nameError.setText("Name must contain at least 2 characters!");
            }
            // Validate Email is not empty
            else if (email.isEmpty()) {
                emailError.setText("Please enter your email!");
            }
            // Check if email matches standard patterns
            // !CHANGE TO REGEX!
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailError.setText("Please enter a valid email address!");
            }
            // Send Data
            else {

                DBHelper dbHelper = new DBHelper(requireContext());

                boolean inserted = dbHelper.insertSubscriber(
                        name,
                        email,
                        option1Checked,
                        option3Checked,
                        option4Checked
                );

                if (inserted) {
                    Toast.makeText(requireContext(),
                            "Thank you, " + name + "! your rewards has been sent to " + email + ".",
                            Toast.LENGTH_LONG).show();

                    // Reset errors on click
                    nameError.setText("");
                    emailError.setText("");
                    option1.setChecked(true);
                    option3.setChecked(false);
                    option4.setChecked(false);
                } else {
                    Toast.makeText(requireContext(),
                            "Failed to save subscription.",
                            Toast.LENGTH_LONG).show();
                }

                if (getActivity() != null) {
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