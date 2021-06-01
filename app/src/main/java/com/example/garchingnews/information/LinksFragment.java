package com.example.garchingnews.information;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.garchingnews.R;
import com.google.android.material.button.MaterialButton;

public class LinksFragment extends Fragment {

    MaterialButton serviceInformationButton;
    MaterialButton eventsButton;
    MaterialButton buergerserviceButton;
    MaterialButton mvgMessagesButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_links, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(getView());
    }


    protected void initViews(View v) {
        serviceInformationButton = v.findViewById(R.id.service);
        serviceInformationButton.setOnClickListener(view -> onServiceButtonClick());
        eventsButton = v.findViewById(R.id.events);
        eventsButton.setOnClickListener(view -> onEventsButtonClick());
        buergerserviceButton = v.findViewById(R.id.buerger_service);
        buergerserviceButton.setOnClickListener(view -> onBuergerServiceButtonClick());
        mvgMessagesButton = v.findViewById(R.id.mvg_messages);
        mvgMessagesButton.setOnClickListener(view -> onMVGButtonClick());
    }

    protected void onServiceButtonClick() {
        Uri uri = Uri.parse("https://www.garching.de/Rathaus+_+Service.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void onEventsButtonClick() {
        Uri uri = Uri.parse("https://www.garching.de/Leben+in+Garching/Veranstaltungen/Alle+Veranstaltungen.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void onBuergerServiceButtonClick() {
        Uri uri = Uri.parse("https://www.buergerserviceportal.de/bayern/garching");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void onMVGButtonClick() {
        Uri uri = Uri.parse("https://www.mvg.de/dienste/betriebsaenderungen.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}
