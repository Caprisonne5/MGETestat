package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addPlayerButton = findViewById(R.id.addplayerbutton);
        Button startGameButton = findViewById(R.id.creatematchbutton);


        startGameButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, StartGame.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        });

        addPlayerButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, AddPlayer.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        });
    }
}