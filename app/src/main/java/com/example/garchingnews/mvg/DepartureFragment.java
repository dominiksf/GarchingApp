package com.example.garchingnews.mvg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.garchingnews.R;

public class DepartureFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_departures, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(getView());
    }

    SwipeRefreshLayout swipeRefreshLayout;

    RecyclerView recyclerView;
    DepartureListAdapter departureListAdapter = new DepartureListAdapter();


    public void initViews(View view) {
        recyclerView = view.findViewById(R.id.departure_list);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_departures);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(departureListAdapter);

        swipeRefreshLayout.setOnRefreshListener(() -> onRefresh());
        swipeRefreshLayout.setRefreshing(false);

        departureListAdapter.initDepartureList();


    }

    private void onRefresh() {
        departureListAdapter.initDepartureList();
    }
}
