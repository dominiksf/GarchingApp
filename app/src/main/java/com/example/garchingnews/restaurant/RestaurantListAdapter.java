package com.example.garchingnews.restaurant;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

import java.util.ArrayList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantsViewHolder> {

    ArrayList<RestaurantItem> restaurantItemList;
    ViewGroup parent;

    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        return new RestaurantsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {

        initRestaurantList();

        // set itemView information
        holder.name.setText(restaurantItemList.get(position).name);
        holder.description.setText(restaurantItemList.get(position).description);
        holder.webLink.setText(restaurantItemList.get(position).webLink);
        holder.image.setImageResource(restaurantItemList.get(position).imgID);

        // set click Listener
        holder.webLink.setOnClickListener(click -> openWebLink(restaurantItemList.get(position).webLink));
        holder.itemView.setOnClickListener(click -> openWebLink(restaurantItemList.get(position).webLink));

    }

    public void openWebLink(String webLink) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webLink));
        parent.getContext().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return restaurantItemList != null ? restaurantItemList.size() : 0;
    }

    // restaurant data
    protected void initRestaurantList() {
        restaurantItemList = new ArrayList<>();
        restaurantItemList.add(new RestaurantItem("Garchinger Augustiner", "deutsche Küche", "http://www.garchinger-augustiner.com", R.drawable.flag_germany));
        restaurantItemList.add(new RestaurantItem("Gasthof Neuwirt", "deutsche Küche", "http://gasthof-neuwirt.org", R.drawable.flag_germany));
        restaurantItemList.add(new RestaurantItem("El Greco", "griechische Küche", "el-greco-garching.metro.biz", R.drawable.flag_greek));
        restaurantItemList.add(new RestaurantItem("Farmers Steakhouse", "internationale Küche", "http://www.farmerscafeandsteakhouse.de/", R.drawable.flag_blank));
        restaurantItemList.add(new RestaurantItem("Mei Wirtshaus", "bayrische Küche", "https://mei-wirtshaus.de/?lang=de", R.drawable.flag_germany));
        restaurantItemList.add(new RestaurantItem("Chi Anh Sushibar", "chinesische Küche", "https://www.chi-anh-garching.de/", R.drawable.flag_china));
        restaurantItemList.add(new RestaurantItem("Poseidon", "griechische Küche", "http://www.poseidon-garching.de/", R.drawable.flag_greek));
        restaurantItemList.add(new RestaurantItem("China Restaurant Global Wok", "chinesische Küche", "http://global-wok.de/m.html", R.drawable.flag_china));
        restaurantItemList.add(new RestaurantItem("Yam Yam", "asiatische Küche", "https://asiayamyamimbiss.netlify.com/", R.drawable.flag_blank));
        restaurantItemList.add(new RestaurantItem("Nano Sushi", "japanische Küche", "http://www.nanosushi.de/", R.drawable.flag_japan));
    }

    public ArrayList<RestaurantItem> getRestaurantItemList() {
        return restaurantItemList;
    }
}
