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
        Button createMatchButton = findViewById(R.id.creatematchbutton);


        createMatchButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, StartMatchActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        });

        addPlayerButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, AddPlayerActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        });
    }
}