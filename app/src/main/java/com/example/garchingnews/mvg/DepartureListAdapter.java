package com.example.garchingnews.mvg;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureListAdapter extends RecyclerView.Adapter<DepartureViewHolder> {

    List<DepartureItem> departureItemList;
    ViewGroup parent;
    DataRequester dataRequester = new DataRequester();

    @NonNull
    @Override
    public DepartureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.parent = parent;
        return new DepartureViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.departure_card, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull DepartureViewHolder holder, int position) {

        initDepartureList();

        if (this.departureItemList != null) {
            holder.departureTextView.setText(setDepartureTimeText(departureItemList.get(position)));
            holder.destinationTextView.setText(this.departureItemList.get(position).destination);
            holder.itemView.setOnClickListener(view -> onDepartureItemClick(view, departureItemList.get(position)));
        } else {
            Log.e("DepartureListAdapter", "DepartureItemList is NULL");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onDepartureItemClick(View view, DepartureItem departureItem) {

        String time = LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + " Uhr";

        Toast.makeText(view.getContext(), departureItem.destination + " | " + departureItem.getDeparture() + " min. | Stand: " + time, Toast.LENGTH_SHORT).show();

    }

    private String setDepartureTimeText(DepartureItem departureItem) {

        if (departureItem.getDeparture() == 0) {
            return "Jetzt";
        } else {
            return departureItem.departure + "\nMinuten";
        }


    }

    @Override
    public int getItemCount() {
        return departureItemList != null ? departureItemList.size() : 0;
    }

    protected void initDepartureList() {

        Log.d("Departure", "Departure List initiated");

        DataRequester dataRequester = new DataRequester();

        (new Thread(dataRequester)).start();

        dataRequester.getDepartures();

        this.departureItemList = dataRequester.getDepatureItemList();


        /*

        //Dummy implementation
        this.departureItemList = new ArrayList<>();

        departureItemList.add(new DepartureItem(Destination.GARCHINGFZ, 0));
        departureItemList.add(new DepartureItem(Destination.GARCHINGFZ, 3));
        departureItemList.add(new DepartureItem(Destination.KLINIKUM, 5));
        departureItemList.add(new DepartureItem(Destination.GARCHINGFZ, 10));
        departureItemList.add(new DepartureItem(Destination.KLINIKUM, 12));
        departureItemList.add(new DepartureItem(Destination.GARCHINGFZ, 13));
        departureItemList.add(new DepartureItem(Destination.GARCHINGFZ, 15));
        departureItemList.add(new DepartureItem(Destination.KLINIKUM, 20));
        departureItemList.add(new DepartureItem(Destination.GARCHINGFZ, 23));
        departureItemList.add(new DepartureItem(Destination.KLINIKUM, 30));
        */
    }


}
