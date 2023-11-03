package Model;

import java.util.ArrayList;

public class Match {

    private int setsPlayer1;
    private int setsPlayer2;
    private ArrayList<Game> games;

    public Match(){
        this.setsPlayer1 = 0;
        this.setsPlayer2 = 0;
        this.games = new ArrayList<Game>();
    }

    public int getSetsPlayer1(){return setsPlayer1;}
    public int getSetsPlayer2(){return setsPlayer2;}
    public ArrayList<Game> getGames(){return games;}
    
}
