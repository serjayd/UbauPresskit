package com.sympstudio.ubaupresskit.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sympstudio.ubaupresskit.R;

import java.util.List;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {

    private final List<FaqItem> faqList;

    public FaqAdapter(List<FaqItem> faqList) {
        this.faqList = faqList;
    }

    @NonNull
    @Override
    public FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faq_item, parent, false);

        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqViewHolder holder, int position) {

        FaqItem item = faqList.get(position);

        holder.question.setText(item.getQuestion());
        holder.answer.setText(item.getAnswer());

        if (item.isExpanded()) {
            holder.answer.setVisibility(View.VISIBLE);
            holder.arrow.setRotation(90f);
        } else {
            holder.answer.setVisibility(View.GONE);
            holder.arrow.setRotation(0f);
        }

        holder.itemView.setOnClickListener(v -> {

            item.setExpanded(!item.isExpanded());

            notifyItemChanged(position);

        });
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }

    static class FaqViewHolder extends RecyclerView.ViewHolder {

        TextView question;
        TextView answer;
        ImageView arrow;

        public FaqViewHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question);
            answer = itemView.findViewById(R.id.answer);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}