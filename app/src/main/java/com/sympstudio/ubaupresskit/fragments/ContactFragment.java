package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sympstudio.ubaupresskit.DBHelper;
import com.sympstudio.ubaupresskit.R;

public class ContactFragment extends Fragment {

    public ContactFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        EditText nameInput = view.findViewById(R.id.contact_name_input);
        EditText emailInput = view.findViewById(R.id.contact_email_input);
        EditText messageInput = view.findViewById(R.id.contact_message_input);

        TextView nameError = view.findViewById(R.id.contact_name_error);
        TextView emailError = view.findViewById(R.id.contact_email_error);
        TextView messageError = view.findViewById(R.id.contact_message_error);

        Button contactButton = view.findViewById(R.id.contact_button);

        contactButton.setOnClickListener(v -> {

            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String message = messageInput.getText().toString().trim();

            // Reset previous errors
            nameError.setText("");
            emailError.setText("");
            messageError.setText("");

            // Validate Name
            if (name.isEmpty() || name.length() < 2) {
                nameError.setText("Name must contain at least 2 characters!");
            }
            // Validate Email is not empty
            else if (email.isEmpty()) {
                emailError.setText("Please enter your email!");
            }
            // Check if email matches standard patterns
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailError.setText("Please enter a valid email address!");
            }
            // Validate Message
            else if (message.isEmpty() || message.length() < 5) {
                messageError.setText("Message must contain at least 5 characters!");
            }
            // Send Data
            else {

                DBHelper dbHelper = new DBHelper(requireContext());

                boolean inserted = dbHelper.insertContactMessage(
                        name,
                        email,
                        message
                );

                if (inserted) {
                    Toast.makeText(requireContext(),
                            "Thank you, " + name + "! Your message has been sent.",
                            Toast.LENGTH_LONG).show();

                    // Clear inputs on success
                    nameInput.setText("");
                    emailInput.setText("");
                    messageInput.setText("");
                } else {
                    Toast.makeText(requireContext(),
                            "Failed to send message.",
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