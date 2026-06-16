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

import com.sympstudio.ubaupresskit.R;

public class SubscriptionFragment extends Fragment {

    // Обязательный пустой конструктор для фрагментов
    public SubscriptionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. Привязываем XML разметку к этому фрагменту
        View view = inflater.inflate(R.layout.fragment_subscription, container, false);

        // 2. Находим все элементы интерфейса (ОБЯЗАТЕЛЬНО через view.findViewById)
        EditText nameInput = view.findViewById(R.id.name_input);
        EditText emailInput = view.findViewById(R.id.email_input);

        CheckBox option1 = view.findViewById(R.id.subscription_option_1);
        CheckBox option2 = view.findViewById(R.id.subscription_option_2);
        CheckBox option3 = view.findViewById(R.id.subscription_option_3);
        CheckBox option4 = view.findViewById(R.id.subscription_option_4);

        Button subscribeButton = view.findViewById(R.id.subscribe_button);

        // 3. Вешаем обработчик клика на кнопку
        subscribeButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();

            // Простая проверка на заполнение полей
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(getContext(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                // Здесь будет твоя логика (отправка на сервер или бэкап)
                String message = "Спасибо, " + name + "! Подписка оформлена.";
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}