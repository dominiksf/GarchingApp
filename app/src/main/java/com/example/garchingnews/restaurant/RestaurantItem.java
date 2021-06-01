package com.example.garchingnews.restaurant;

import android.media.Image;
import android.widget.ImageView;

public class RestaurantItem {

    String name;
    String description;
    String webLink;
    int imgID;


    public RestaurantItem(String name,String description,String webLink, int imgID) {
        this.name = name;
        this.description = description;
        this.webLink = webLink;

        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWebLink() {
        return webLink;
    }

    public int getImgID() {
        return imgID;
    }

}
