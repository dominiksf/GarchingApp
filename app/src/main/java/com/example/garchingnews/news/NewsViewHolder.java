package com.example.garchingnews.news;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleTextView;
    TextView dateTextView;
    TextView descriptionTextView;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        titleTextView = itemView.findViewById(R.id.title);
        dateTextView = itemView.findViewById(R.id.publish_date);
        descriptionTextView = itemView.findViewById(R.id.description);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            descriptionTextView.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getDateTextView() {
        return dateTextView;
    }

    public TextView getDescriptionTextView() {
        return descriptionTextView;
    }
}
