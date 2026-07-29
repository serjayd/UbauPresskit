package com.sympstudio.ubaupresskit.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.DBHelper;
import com.sympstudio.ubaupresskit.R;

public class MessagesFragment extends Fragment {

    public MessagesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_messages,
                container,
                false);

        Animation animPage = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);

        view.startAnimation(animPage);

        LinearLayout messagesContainer =
                view.findViewById(R.id.messages_container);

        DBHelper dbHelper = new DBHelper(requireContext());

        Cursor cursor = dbHelper.getAllMessages();

        if (cursor.moveToFirst()) {

            do {

                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String message = cursor.getString(3);

                TextView textView = new TextView(requireContext());

                textView.setText(
                        "Name: " + name +
                                "Email: " + email +
                                "Message: " + message +
                                "----------------------------"
                );

                textView.setTextSize(16);
                textView.setPadding(20, 20, 20, 20);

                messagesContainer.addView(textView);

            } while (cursor.moveToNext());

        } else {

            TextView textView = new TextView(requireContext());
            textView.setText("No messages found.");
            textView.setTextSize(16);

            messagesContainer.addView(textView);
        }

        cursor.close();

        return view;
    }
}