package com.example.garchingnews.facilities;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;
import com.example.garchingnews.restaurant.RestaurantItem;
import com.example.garchingnews.restaurant.RestaurantsViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FacilitiesListAdapter extends RecyclerView.Adapter<FacilitiesViewHolder> {

    ArrayList<FacilitiesItem> facilitiesItemList;
    ViewGroup parent;

    @NonNull
    @NotNull
    @Override
    public FacilitiesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        this.parent = parent;
        return new FacilitiesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.facilities_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FacilitiesViewHolder holder, int position) {

        initFacilitiesData();

        holder.facilityName.setText(facilitiesItemList.get(position).name);
        holder.facilityOpeningHours.setText(facilitiesItemList.get(position).openingHours);

        holder.facilityWebLinkIcon.setOnClickListener(click -> onWebLinkIconClicked(facilitiesItemList.get(position).webLink));
        holder.facilityPhoneCallIcon.setOnClickListener(click -> onPhoneCallIconClicked(facilitiesItemList.get(position).phoneNumber));
        holder.facilityNavigationIcon.setOnClickListener(click -> onNavIconClicked(facilitiesItemList.get(position).address));
    }

    public void onWebLinkIconClicked(String webLink) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webLink));
        parent.getContext().startActivity(intent);
    }

    public void onPhoneCallIconClicked(String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
        parent.getContext().startActivity(intent);
    }

    public void onNavIconClicked(String address) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        parent.getContext().startActivity(intent);
    }

    // facilities data
    protected void initFacilitiesData() {
        facilitiesItemList = new ArrayList<>();
        facilitiesItemList.add(new FacilitiesItem("Werstoffhof", "Montag: 16:00 - 19:00 Uhr \nMittwoch: 09:00 - 12:00 Uhr \nDonnerstag: 16:00 - 19:00 Uhr \nFreitag14:00 - 17:00 Uhr \nSamstag: 09:00 - 13:00 Uhr", "www.google.com", "01748704076", "https://www.google.com/maps/dir//Garchinger+Wertstoffhof,+Brunnenweg,+Garching+bei+München/@48.2504532,11.6567168,12z/data=!3m1!4b1!4m9!4m8!1m0!1m5!1m1!1s0x479e72fc4f4285bb:0x2b364134c375488e!2m2!1d11.6567168!2d48.2504532!3e2", R.drawable.garching_image));
        facilitiesItemList.add(new FacilitiesItem("Stadtbücherei", "Montag: 11:00 - 20:00 Uhr \nDienstag - Freitag: 11:00 - 18:00 Uhr \n1.Samstag im Monat: 09:00 - 13:00 Uhr", "http://stadtbuechereigarching.de", "01748704076", "https://www.google.com/maps/dir//Stadtbücherei+Garching,+Bürgerplatz,+Garching+bei+München/@48.2502775,11.6537762,17z/data=!4m9!4m8!1m0!1m5!1m1!1s0x41090579d9a846af:0x59482b2b481cf201!2m2!1d11.6505212!2d48.2504378!3e2", R.drawable.garching_image));
    }

    @Override
    public int getItemCount() {
        return this.facilitiesItemList.size();
    }
}
