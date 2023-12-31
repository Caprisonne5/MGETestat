package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import Model.Match;
import Model.MatchRepository;
import Model.MatchSet;
import Model.Game;
import Services.SetCounter;
import Services.RandomId;

public class MatchActivity extends AppCompatActivity {

    private Match match;
    private TextView gameScore;
    private TextView setScore;
    private TextView setScoreTitle;
    private Game game;
    private MatchSet matchSet;
    private TableLayout setOverview;
    private Button endMatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Button addPointP1 = findViewById(R.id.addPointP1);
        Button addPointP2 = findViewById(R.id.addPointP2);
        endMatchButton = findViewById(R.id.endMatchButton);
        setOverview = findViewById(R.id.setOverview);
        TextView nameP1Table = findViewById(R.id.nameP1Table);
        TextView nameP2Table = findViewById(R.id.nameP2Table);
        TextView nameP1Button = findViewById(R.id.nameP1);
        TextView nameP2Button = findViewById(R.id.nameP2);

        gameScore = findViewById(R.id.gameScore);
        setScore = findViewById(R.id.setScore);
        setScoreTitle = findViewById(R.id.scoreTitle);


        match = new Match(RandomId.generateId());
        matchSet = new MatchSet(match.MatchId);
        game = new Game();

        //Alle Werte setzen
        String NamePlayer1 = getIntent().getStringExtra("Player1Name");
        String NamePlayer2 = getIntent().getStringExtra("Player2Name");

        setScore.setText(String.format(getString(R.string.default_setscore), matchSet.getPointsPlayer1(), matchSet.getPointsPlayer2()));

        nameP1Table.setText(NamePlayer1);
        nameP2Table.setText(NamePlayer2);
        nameP1Button.setText(NamePlayer1);
        nameP2Button.setText(NamePlayer2);
        match.P1 = NamePlayer1;
        match.P2 = NamePlayer2;



        addPointP1.setOnClickListener(v -> {
            String score = "";
            if (matchSet.getTiebreak() != null && !(matchSet.getTiebreak().getTiebreakFinished())){
                score = matchSet.getTiebreak().evalScore(1, matchSet);
                updateScore(score);
            }else {
                score = game.evalScore(matchSet, 1);
                updateScore(score);
            }
        });

        addPointP2.setOnClickListener(v -> {
            String score = "";
            if (matchSet.getTiebreak() != null && !(matchSet.getTiebreak().getTiebreakFinished())){
                score = matchSet.getTiebreak().evalScore(2, matchSet);
                updateScore(score);
            }else {
                score = game.evalScore(matchSet, 2);
                updateScore(score);
            }
        });

        endMatchButton.setOnClickListener(v -> {
            MatchRepository.addMatch(match);
            persistMatchSets();
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
        });

    }

    private void updateScore(String score) {
        if (game.getNewGame() && !(matchSet.getTiebreak() != null && matchSet.getTiebreak().getTiebreakFinished())){
            this.game = new Game();
            score = "0 : 0";
            setScore.setText(String.format(getString(R.string.default_setscore), matchSet.getPointsPlayer1(), matchSet.getPointsPlayer2()));
        }
        if (SetCounter.needsTiebreak(matchSet) && matchSet.getTiebreak() == null){
            this.matchSet.setTiebreak();
            setScoreTitle.setText(getString(R.string.tiebreak_scoretitle));
        }
        if (matchSet.getNewSet() || (matchSet.getTiebreak() != null && matchSet.getTiebreak().getTiebreakFinished())){
            setScore.setText(String.format(getString(R.string.default_setscore), 0, 0));
            setScoreTitle.setText(getString(R.string.default_scoretitle));

            match.addSet(matchSet);
            addSetToOverview();

            endMatchButton.setEnabled(true);

            this.matchSet = new MatchSet(match.MatchId);
            score = "0 : 0";
        }
        gameScore.setText(score);
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(8, 8, 8, 8);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    private void addSetToOverview(){
        TableRow newRow = new TableRow(this);

        TextView cell1 = createTextView(String.valueOf(matchSet.getPointsPlayer1()));
        TextView cell2 = createTextView(String.valueOf(matchSet.getPointsPlayer2()));

        newRow.addView(cell1);
        newRow.addView(cell2);

        setOverview.addView(newRow);
    }
    private void persistMatchSets () {
        for (MatchSet set : this.match.matchSets) {
            MatchRepository.addSet(set);
        }
    }
}