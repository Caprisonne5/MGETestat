package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import Adapter.MatchAdapter;
import Model.MatchRepository;
import Model.storage.MatchesWithSets;

public class MainActivity extends AppCompatActivity {
    private MatchAdapter adapter;
    private TextView emptyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createMatchButton = findViewById(R.id.creatematchbutton);
        emptyList = findViewById(R.id.emptyList);


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
        List<MatchesWithSets> matches = MatchRepository.getMatches();
        if (matches.size() != 0) {
            emptyList.setVisibility(View.INVISIBLE);
        }
        adapter.updateMatches(matches);
    }
}