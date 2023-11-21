package com.example.mgetestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;


public class StartMatchActivity extends AppCompatActivity {

    private EditText Player1Name;
    private EditText Player2Name;
    private Button startMatchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_match);


        startMatchButton = findViewById(R.id.startmatchbutton);
        Player1Name = findViewById(R.id.startmatch_nameP1);
        Player2Name = findViewById(R.id.startmatch_nameP2);

        Player1Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                String name = Player1Name.getText().toString();
                if (name.length() < 15 && name.length() > 2){
                    Player1Name.setError(null);
                }else {
                    Player1Name.setError("Invalid Name");
                }
                UpdateStartMatchbutton();
            }
        });

        Player2Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                String name = Player2Name.getText().toString();
                if (name.length() < 15 && name.length() > 2){
                    Player2Name.setError(null);
                }else {
                    Player2Name.setError("Invalid Name");
                }
                UpdateStartMatchbutton(); //Rausnehmen
            }
        });


        startMatchButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(this, MatchActivity.class);
            myIntent.putExtra("Player1Name", Player1Name.getText().toString().substring(0, 1).toUpperCase()
                                                        + Player1Name.getText().toString().substring(1));
            myIntent.putExtra("Player2Name", Player2Name.getText().toString().substring(0, 1).toUpperCase()
                                                        + Player2Name.getText().toString().substring(1));
            startActivity(myIntent);
        });

        UpdateStartMatchbutton();

    }
    public void UpdateStartMatchbutton () {
        if (Player1Name.getError() == null && Player2Name.getError() == null && Player1Name.getText().length() != 0 && Player2Name.getText().length() != 0){
            startMatchButton.setEnabled(true);
        }else {
            startMatchButton.setEnabled(false);
        }
    }


}