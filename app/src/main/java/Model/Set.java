package Model;

import android.view.View;

public class Set {
    private int pointsPlayer1;
    private int pointsPlayer2;

    public Set(){
        this.pointsPlayer1 = 0;
        this.pointsPlayer2 = 0;
    }

    public int getPointsPlayer1(){return pointsPlayer1;}
    public int getPointsPlayer2(){return pointsPlayer2;}
    public int incPointsPlayer1(){
        pointsPlayer1++;
        return pointsPlayer1;
    }
    public int incPointsPlayer2(){
        pointsPlayer2++;
        return pointsPlayer2;
    }
}
