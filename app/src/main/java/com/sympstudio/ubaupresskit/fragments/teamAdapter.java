package com.sympstudio.ubaupresskit.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sympstudio.ubaupresskit.R;

public class teamAdapter extends BaseAdapter {

    int [] images;
    String[] names;
    String[] descriptions;
    LayoutInflater inflater;
    Context context;

    teamAdapter(Context context, int[] images, String[] names, String[] descriptions)
    {
        this.context = context;
        this.images = images;
        this.names = names;
        this.descriptions = descriptions;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter, parent, false);


        ImageView image = convertView.findViewById(R.id.team_image);
        TextView name = convertView.findViewById(R.id.team_name);
        TextView description = convertView.findViewById(R.id.team_description);


        image.setImageResource(images[position]);

        name.setText(names[position]);

        description.setText(descriptions[position]);


        return convertView;
    }




}

