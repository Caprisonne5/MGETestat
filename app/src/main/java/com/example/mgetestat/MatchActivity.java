package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import Model.Match;
import Model.Set;
import Model.Game;
import Model.Tiebreak;
import Services.SetCounter;

public class MatchActivity extends AppCompatActivity {

    private Match Match;
    private TextView gameScore;
    private TextView setScore;
    private TextView setScoreTitle;
    private Game game;
    private Set set;
    private TableLayout setOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Button addPointP1 = findViewById(R.id.addPointP1);
        Button addPointP2 = findViewById(R.id.addPointP2);
        setOverview = findViewById(R.id.setOverview);
        TextView nameP1Table = findViewById(R.id.nameP1Table);
        TextView nameP2Table = findViewById(R.id.nameP2Table);

        gameScore = findViewById(R.id.gameScore);
        setScore = findViewById(R.id.setScore);
        setScoreTitle = findViewById(R.id.scoreTitle);



        Match = new Match();
        set = new Set();
        game = new Game();

        setScore.setText(String.format(getString(R.string.default_setscore), set.getPointsPlayer1(), set.getPointsPlayer2()));
        nameP1Table.setText("Peter"); //Rausnehmen
        nameP2Table.setText("Frank");



        addPointP1.setOnClickListener(v -> {
            String score = "";
            if (set.getTiebreak() != null && !(set.getTiebreak().getTiebreakFinished())){
                score = set.getTiebreak().evalScore(1, set);
                updateScore(score);
            }else {
                score = game.evalScore(set, 1);
                updateScore(score);
            }
        });

        addPointP2.setOnClickListener(v -> {
            String score = "";
            if (set.getTiebreak() != null && !(set.getTiebreak().getTiebreakFinished())){
                score = set.getTiebreak().evalScore(2, set);
                updateScore(score);
            }else {
                score = game.evalScore(set, 2);
                updateScore(score);
            }
        });

    }

    private void updateScore(String score) {
        if (game.getNewGame() && !(set.getTiebreak() != null && set.getTiebreak().getTiebreakFinished())){
            this.game = new Game();
            score = "0 : 0";
            setScore.setText(String.format(getString(R.string.default_setscore), set.getPointsPlayer1(), set.getPointsPlayer2()));
        }
        if (SetCounter.needsTiebreak(set) && set.getTiebreak() == null){
            this.set.setTiebreak();
            setScoreTitle.setText(getString(R.string.tiebreak_scoretitle));
        }
        if (set.getNewSet() || (set.getTiebreak() != null && set.getTiebreak().getTiebreakFinished())){
            setScore.setText(String.format(getString(R.string.default_setscore), 0, 0));
            setScoreTitle.setText(getString(R.string.default_scoretitle));

            addSetToOverview();

            this.set = new Set();
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

        TextView cell1 = createTextView(String.valueOf(set.getPointsPlayer1()));
        TextView cell2 = createTextView(String.valueOf(set.getPointsPlayer2()));

        newRow.addView(cell1);
        newRow.addView(cell2);

        setOverview.addView(newRow);
    }
}