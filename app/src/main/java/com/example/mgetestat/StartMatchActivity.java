package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import Model.Match;

public class StartMatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);


        Button startMatchButton = findViewById(R.id.startmatchbutton);

        startMatchButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, MatchActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        });
    }

}