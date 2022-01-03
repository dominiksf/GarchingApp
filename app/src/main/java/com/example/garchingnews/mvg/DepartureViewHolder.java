package com.example.garchingnews.mvg;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

import org.jetbrains.annotations.NotNull;

public class DepartureViewHolder extends RecyclerView.ViewHolder {

    TextView destinationTextView;
    TextView departureTextView;

    public DepartureViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        destinationTextView = itemView.findViewById(R.id.departure_destination);
        departureTextView = itemView.findViewById(R.id.departure_time);
    }


}
