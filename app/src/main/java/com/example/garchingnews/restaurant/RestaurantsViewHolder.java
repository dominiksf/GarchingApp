package com.example.garchingnews.restaurant;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

public class RestaurantsViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView description;
    TextView webLink;
    ImageView image;



    public RestaurantsViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.titleRestaurant);
        description = itemView.findViewById(R.id.descriptionRestaurant);
        webLink = itemView.findViewById(R.id.webLinkRestaurant);
        image = itemView.findViewById(R.id.restaurant_img);

    }

    public TextView getName() {
        return name;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getWebLink() {
        return webLink;
    }

    public ImageView getImage() {
        return image;
    }


}
