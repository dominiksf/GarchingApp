package com.example.garchingnews.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.garchingnews.R;
import com.example.garchingnews.main.DarkModeManager;

public class SettingsFragment extends Fragment {

    DarkModeManager darkModeManager;

    Switch darkMode;
    Switch sounds;
    Switch vibrations;
    Switch notifications;

    boolean DarkModeOnOff;

    public final static String SHARED_PREFS = "settings";
    public final static String SWITCH_DARKMODE = "switchDarkMode";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(getView());

    }

    protected void initViews(View view) {
        darkModeManager = new DarkModeManager(getContext());
        darkMode = view.findViewById(R.id.darkMode);
        sounds = view.findViewById(R.id.sounds);
        vibrations = view.findViewById(R.id.vibrations);
        notifications = view.findViewById(R.id.notifications);

    }

    protected void onThemeButtonClick() {
        darkModeManager.setMode(DarkModeManager.NIGHT);
    }




}
