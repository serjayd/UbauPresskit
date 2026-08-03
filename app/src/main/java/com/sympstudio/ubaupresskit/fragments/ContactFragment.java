package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

import java.util.regex.Pattern;

public class ContactFragment extends Fragment {

    public ContactFragment() {
    }

    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s'-]{2,50}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView viewRecentMessages = view.findViewById(R.id.contact_view_recent_messages);

        View card1 = view.findViewById(R.id.contact_form_name);
        View card2 = view.findViewById(R.id.contact_form_email);
        View card3 = view.findViewById(R.id.contact_form_message);

        EditText nameInput = view.findViewById(R.id.contact_name_input);
        EditText emailInput = view.findViewById(R.id.contact_email_input);
        EditText messageInput = view.findViewById(R.id.contact_message_input);

        TextView nameError = view.findViewById(R.id.contact_name_error);
        TextView emailError = view.findViewById(R.id.contact_email_error);
        TextView messageError = view.findViewById(R.id.contact_message_error);

        Button contactButton = view.findViewById(R.id.contact_button);

        Animation anim1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim1.setStartOffset(0);

        Animation anim2 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim2.setStartOffset(150);

        Animation anim3 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim3.setStartOffset(300);

        Animation anim4 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        anim4.setStartOffset(450);


        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        card1.startAnimation(anim1);
        card2.startAnimation(anim2);
        card3.startAnimation(anim3);
        contactButton.startAnimation(anim4);
        view.startAnimation(animPage);

        contactButton.setOnClickListener(v -> {

            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String message = messageInput.getText().toString().trim();


            nameError.setText("");
            emailError.setText("");
            messageError.setText("");


            if (name.isEmpty() || !NAME_PATTERN.matcher(name).matches()) {
                nameError.setText("Name must contain at least 2 characters!");
            }

            else if (email.isEmpty()) {
                emailError.setText("Please enter your email!");
            }

            else if (!EMAIL_PATTERN.matcher(email).matches()) {
                emailError.setText("Please enter a valid email address!");
            }

            else if (message.isEmpty() || message.length() < 5) {
                messageError.setText("Message must contain at least 5 characters!");
            }

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

        viewRecentMessages.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new MessagesFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

}