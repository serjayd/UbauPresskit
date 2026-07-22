package com.sympstudio.ubaupresskit.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sympstudio.ubaupresskit.R;

import java.util.ArrayList;
import java.util.List;

public class FaqFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_faq, container, false);

        RecyclerView gameplayRecycler = view.findViewById(R.id.gameplayRecycler);
        RecyclerView purchaseRecycler = view.findViewById(R.id.purchaseRecycler);
        RecyclerView goodiesRecycler = view.findViewById(R.id.goodiesRecycler);
        RecyclerView technicalRecycler = view.findViewById(R.id.technicalRecycler);

        gameplayRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        purchaseRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        goodiesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        technicalRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        gameplayRecycler.setAdapter(new FaqAdapter(getGameplay()));
        purchaseRecycler.setAdapter(new FaqAdapter(getPurchase()));
        goodiesRecycler.setAdapter(new FaqAdapter(getGoodies()));
        technicalRecycler.setAdapter(new FaqAdapter(getTechnical()));

        return view;
    }

    private List<FaqItem> getGameplay() {

        List<FaqItem> list = new ArrayList<>();

        list.add(new FaqItem(
                getString(R.string.faq_question_1),
                getString(R.string.faq_answer_1)));

        list.add(new FaqItem(
                getString(R.string.faq_question_2),
                getString(R.string.faq_answer_2)));

        list.add(new FaqItem(
                getString(R.string.faq_question_3),
                getString(R.string.faq_answer_3)));

        list.add(new FaqItem(
                getString(R.string.faq_question_4),
                getString(R.string.faq_answer_4)));

        list.add(new FaqItem(
                getString(R.string.faq_question_5),
                getString(R.string.faq_answer_5)));

        return list;
    }

    private List<FaqItem> getPurchase() {

        List<FaqItem> list = new ArrayList<>();

        list.add(new FaqItem(
                getString(R.string.faq_purchase_question_1),
                getString(R.string.faq_purchase_answer_1)));

        list.add(new FaqItem(
                getString(R.string.faq_purchase_question_2),
                getString(R.string.faq_purchase_answer_2)));

        list.add(new FaqItem(
                getString(R.string.faq_purchase_question_3),
                getString(R.string.faq_purchase_answer_3)));

        list.add(new FaqItem(
                getString(R.string.faq_purchase_question_4),
                getString(R.string.faq_purchase_answer_4)));

        return list;
    }

    private List<FaqItem> getGoodies() {

        List<FaqItem> list = new ArrayList<>();

        list.add(new FaqItem(
                getString(R.string.faq_goodies_question_1),
                getString(R.string.faq_goodies_answer_1)));

        list.add(new FaqItem(
                getString(R.string.faq_goodies_question_2),
                getString(R.string.faq_goodies_answer_2)));

        list.add(new FaqItem(
                getString(R.string.faq_goodies_question_3),
                getString(R.string.faq_goodies_answer_3)));

        return list;
    }

    private List<FaqItem> getTechnical() {

        List<FaqItem> list = new ArrayList<>();

        list.add(new FaqItem(
                getString(R.string.faq_technical_question_1),
                getString(R.string.faq_technical_answer_1)));

        list.add(new FaqItem(
                getString(R.string.faq_technical_question_2),
                getString(R.string.faq_technical_answer_2)));

        list.add(new FaqItem(
                getString(R.string.faq_technical_question_3),
                getString(R.string.faq_technical_answer_3)));

        return list;
    }
}