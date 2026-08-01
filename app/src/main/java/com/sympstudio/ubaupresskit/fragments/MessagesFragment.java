package com.sympstudio.ubaupresskit.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sympstudio.ubaupresskit.DBHelper;
import com.sympstudio.ubaupresskit.R;

public class MessagesFragment extends Fragment {

    private DBHelper dbHelper;
    private LinearLayout messagesContainer;
    private Context ctx;

    public MessagesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_messages, container, false);

        ctx = requireContext();
        messagesContainer = view.findViewById(R.id.messages_container);
        dbHelper = new DBHelper(ctx);

        loadMessages();

        return view;
    }

    private void loadMessages() {
        messagesContainer.removeAllViews();

        Cursor cursor = dbHelper.getAllMessages();

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String message = cursor.getString(3);

                messagesContainer.addView(buildCard(id, name, email, message));

            } while (cursor.moveToNext());
        } else {
            TextView emptyText = new TextView(ctx);
            emptyText.setText("No messages yet");
            emptyText.setTextSize(16);
            emptyText.setPadding(16, 40, 16, 16);
            messagesContainer.addView(emptyText);
        }

        cursor.close();
    }

    // Build one message card using plain LinearLayout, TextView and Button
    private View buildCard(int id, String name, String email, String message) {

        LinearLayout card = new LinearLayout(ctx);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(Color.WHITE);
        card.setPadding(24, 24, 24, 24);

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        cardParams.bottomMargin = 24;
        card.setLayoutParams(cardParams);

        TextView nameView = new TextView(ctx);
        nameView.setText(name);
        nameView.setTextSize(16);
        card.addView(nameView);

        TextView emailView = new TextView(ctx);
        emailView.setText(email);
        emailView.setTextSize(13);
        emailView.setTextColor(Color.GRAY);
        card.addView(emailView);

        TextView messageView = new TextView(ctx);
        messageView.setText(message);
        messageView.setTextSize(14);
        messageView.setPadding(0, 16, 0, 0);
        card.addView(messageView);

        LinearLayout buttonRow = new LinearLayout(ctx);
        buttonRow.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        rowParams.topMargin = 16;
        buttonRow.setLayoutParams(rowParams);

        Button editButton = new Button(ctx);
        editButton.setText("Edit");
        editButton.setTextColor(Color.WHITE);
        editButton.setBackgroundColor(Color.parseColor("#2196F3"));
        editButton.setOnClickListener(v -> showEditDialog(id, name, email, message));

        Button deleteButton = new Button(ctx);
        deleteButton.setText("Delete");
        deleteButton.setTextColor(Color.WHITE);
        deleteButton.setBackgroundColor(Color.parseColor("#F44336"));
        deleteButton.setOnClickListener(v -> showDeleteConfirm(id, name));

        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        buttonParams.rightMargin = 8;

        buttonRow.addView(editButton, buttonParams);
        buttonRow.addView(deleteButton, new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        card.addView(buttonRow);

        return card;
    }

    // Simple edit popup built with plain EditText fields
    private void showEditDialog(int id, String currentName, String currentEmail, String currentMessage) {

        LinearLayout dialogLayout = new LinearLayout(ctx);
        dialogLayout.setOrientation(LinearLayout.VERTICAL);
        dialogLayout.setPadding(32, 32, 32, 32);

        EditText nameInput = new EditText(ctx);
        nameInput.setHint("Name");
        nameInput.setText(currentName);

        EditText emailInput = new EditText(ctx);
        emailInput.setHint("Email");
        emailInput.setText(currentEmail);

        EditText messageInput = new EditText(ctx);
        messageInput.setHint("Message");
        messageInput.setText(currentMessage);

        dialogLayout.addView(nameInput);
        dialogLayout.addView(emailInput);
        dialogLayout.addView(messageInput);

        AlertDialog dialog = new AlertDialog.Builder(ctx)
                .setTitle("Edit message")
                .setView(dialogLayout)
                .setPositiveButton("Save", null)
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .create();

        dialog.setOnShowListener(d -> {
            Button saveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            saveButton.setOnClickListener(v -> {

                String name = nameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String message = messageInput.getText().toString().trim();

                if (TextUtils.isEmpty(name) || name.length() < 2) {
                    nameInput.setError("Name too short");
                    return;
                }
                if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailInput.setError("Invalid email");
                    return;
                }
                if (TextUtils.isEmpty(message) || message.length() < 5) {
                    messageInput.setError("Message too short");
                    return;
                }

                boolean updated = dbHelper.updateContactMessage(id, name, email, message);

                if (updated) {
                    Toast.makeText(ctx, "Message updated", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    loadMessages();
                } else {
                    Toast.makeText(ctx, "Update failed", Toast.LENGTH_SHORT).show();
                }
            });
        });

        dialog.show();
    }

    private void showDeleteConfirm(int id, String name) {
        new AlertDialog.Builder(ctx)
                .setTitle("Delete message")
                .setMessage("Delete message from " + name + "?")
                .setPositiveButton("Delete", (d, which) -> {
                    boolean deleted = dbHelper.deleteContactMessage(id);
                    if (deleted) {
                        Toast.makeText(ctx, "Deleted", Toast.LENGTH_SHORT).show();
                        loadMessages();
                    } else {
                        Toast.makeText(ctx, "Delete failed", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}