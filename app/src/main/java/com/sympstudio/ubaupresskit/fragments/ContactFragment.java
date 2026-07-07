package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sympstudio.ubaupresskit.R;

public class ContactFragment extends Fragment {


    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        TextView recentMessages = view.findViewById(R.id.contact_view_recent_messages);

        recentMessages.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new MessagesFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }
}