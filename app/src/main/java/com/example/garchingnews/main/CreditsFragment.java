package com.example.garchingnews.main;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.garchingnews.R;
import com.example.garchingnews.main.MainActivity;
import com.google.android.material.button.MaterialButton;

public class CreditsFragment extends Fragment {

    MaterialButton shareButton;
    MaterialButton gPlayButton;
    MaterialButton featureRequestButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_credits_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(getView());
    }

    protected void initViews(View view) {
        shareButton = view.findViewById(R.id.shareApp);
        shareButton.setOnClickListener(x -> onShareButtonClick());
        gPlayButton = view.findViewById(R.id.GooglePlay);
        gPlayButton.setOnClickListener(x -> onGPlayButtonClick());
        featureRequestButton = view.findViewById(R.id.featureRequest);
        featureRequestButton.setOnClickListener(x -> onFeatureRequestButtonClick());
    }

    protected void onShareButtonClick() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Link der App");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent shareIntent = Intent.createChooser(intent, "Teilen");
        startActivity(shareIntent);
    }


    protected void onGPlayButtonClick() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    protected void onFeatureRequestButtonClick() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:dominik.scharpf@tum.de"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback zur Stadt Garching App");
        startActivity(Intent.createChooser(intent, "E-Mail"));
    }
}
