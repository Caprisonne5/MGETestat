package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import Adapter.MatchAdapter;
import Model.MatchRepository;

public class MainActivity extends AppCompatActivity {
    private MatchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createMatchButton = findViewById(R.id.creatematchbutton);


        createMatchButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, StartMatchActivity.class);
            //myIntent.putExtra("key", value); //Optional parameters
            startActivity(myIntent);
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MatchAdapter();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        RecyclerView recyclerView = findViewById(R.id.playedMatches);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateMatches(MatchRepository.getMatches());
    }
}