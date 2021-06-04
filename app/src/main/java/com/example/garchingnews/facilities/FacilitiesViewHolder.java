package com.example.garchingnews.facilities;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

import org.jetbrains.annotations.NotNull;

public class FacilitiesViewHolder extends RecyclerView.ViewHolder {

    TextView facilityName;
    TextView facilityOpeningHours;

    ImageView facilityWebLinkIcon;
    ImageView facilityPhoneCallIcon;
    ImageView facilityNavigationIcon;

    public FacilitiesViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        this.facilityName = itemView.findViewById(R.id.facility_name);
        this.facilityOpeningHours = itemView.findViewById(R.id.facility_opening_hours);
        this.facilityWebLinkIcon = itemView.findViewById(R.id.facilities_web_icon);
        this.facilityPhoneCallIcon = itemView.findViewById(R.id.facilities_phone_icon);
        this.facilityNavigationIcon = itemView.findViewById(R.id.facilities_navigation_icon);

    }
}
