package com.example.garchingnews.mvg;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateHandler {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long getTimeUntil(LocalDateTime departureTime) {

        LocalDateTime timeNow = LocalDateTime.now();
        Duration duration = Duration.between(timeNow, departureTime);

        return duration.toMinutes();
    }

}
