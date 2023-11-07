package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import Model.Match;
import Model.Set;
import Model.Game;

public class MatchActivity extends AppCompatActivity {

    private Match Match;
    private TextView gameScore;
    private TextView setScore;
    private Game game;
    private Set set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);



        Button addPointP1 = findViewById(R.id.addPointP1);
        Button addPointP2 = findViewById(R.id.addPointP2);
        gameScore = findViewById(R.id.gameScore);
        setScore = findViewById(R.id.setScore);

        Match = new Match();
        set = new Set();
        game = new Game();

        setScore.setText(String.format(getString(R.string.default_setscore), set.getPointsPlayer1(), set.getPointsPlayer2()));

        addPointP1.setOnClickListener(v -> {
            String score = game.evalScore(set, 1);
            updateScore(score);
        });

        addPointP2.setOnClickListener(v -> {
            String score = game.evalScore(set, 2);
            updateScore(score);
        });

    }

    private void updateScore(String score) {
        if (game.getNewGame()){
            this.game = new Game();
            score = "0 : 0";
            setScore.setText(String.format(getString(R.string.default_setscore), set.getPointsPlayer1(), set.getPointsPlayer2()));
        }
        gameScore.setText(score);
    }
}