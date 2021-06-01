package com.example.garchingnews.restaurant;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garchingnews.R;

public class RestaurantsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(getView());
    }

    RecyclerView recyclerView;
    RestaurantListAdapter restaurantListAdapter = new RestaurantListAdapter();


    public void initViews(View view) {
        recyclerView = view.findViewById(R.id.restaurant_list);

        if (recyclerView == null) {
            Log.e("Restaurant", "NULL");
        } else
            Log.e("Restaurant", "NON-NULL");


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(restaurantListAdapter);

        restaurantListAdapter.initRestaurantList();



    }


}
