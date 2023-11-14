package com.example.mgetestat;

import android.app.Application;
import android.content.Context;

import Model.MatchRepository;

public class TennisScoreApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Context context = getApplicationContext();

        MatchRepository.initialize(context);
    }
}
