package com.sympstudio.ubaupresskit.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sympstudio.ubaupresskit.R;

public class developerAdapter extends BaseAdapter {

    int [] images;
    String[] names;
    String[] descriptions;

    String[] githubLinks;
    String[] linkedinLinks;
    LayoutInflater inflater;
    Context context;

    developerAdapter(Context context,
                     int[] images,
                     String[] names,
                     String[] descriptions,
                     String[] githubLinks,
                     String[] linkedinLinks) {

        this.context = context;
        this.images = images;
        this.names = names;
        this.descriptions = descriptions;
        this.githubLinks = githubLinks;
        this.linkedinLinks = linkedinLinks;

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

        convertView = inflater.inflate(R.layout.developer_adapter, parent, false);


        ImageView image = convertView.findViewById(R.id.developer_image);
        TextView name = convertView.findViewById(R.id.developer_name);
        TextView description = convertView.findViewById(R.id.developer_desc);
        ImageView github = convertView.findViewById(R.id.dev_github);
        ImageView linkedin = convertView.findViewById(R.id.dev_linkedin);


        image.setImageResource(images[position]);

        name.setText(names[position]);

        description.setText(descriptions[position]);

        github.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(githubLinks[position])
            );
            context.startActivity(intent);
        });

        linkedin.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(linkedinLinks[position])
            );
            context.startActivity(intent);
        });


        return convertView;
    }




}

