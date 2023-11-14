package Model;

import Services.SetCounter;

public class Game {
    private int pointsP1;
    private int pointsP2;
    private boolean newGame;

    public Game() {
        pointsP1 = 0;
        pointsP2 = 0;
        newGame = false;
    }

    public boolean getNewGame(){
        return this.newGame;
    }

    public String evalScore(Set set, int PlayerToInc) {
        String score = "";
        adjustScore(PlayerToInc);

        if (newGame) {
            SetCounter.evalScore(set, PlayerToInc);
            return score;
        }

        int p1 = getTennisScore(pointsP1);
        int p2 = getTennisScore(pointsP2);

        if (pointsP1 == 3 && pointsP2 == 3){
            score = "Deu : Deu";
            return score;
        }
        if (pointsP1 == 4 && pointsP2 == 3){
            score = "Adv : 40";
            return score;
        }
        if (pointsP2 == 4 && pointsP1 == 3){
            score = "40 : Adv";
            return score;
        }
        score = String.format("%s : %2d", p1, p2);
        return score;
    }
    
    public int getTennisScore(int points){
        switch (points) {
            case 0:
                return 0;
            case 1:
                return 15;
            case 2:
                return 30;
            case 3:
                return 40;
        }
        return points;
    }
    
    public void adjustScore(int PlayerToInc){
        if ((pointsP1 == 3 && pointsP2 < 3 && PlayerToInc == 1) ||
                (pointsP2 == 3 && pointsP1 < 3 && PlayerToInc == 2) ||
                (pointsP1 == 4 && PlayerToInc == 1) ||
                (pointsP2 == 4 && PlayerToInc == 2)) {
            newGame = true;
            return;
        }
        if(pointsP1 == 4 && PlayerToInc == 2){
            --pointsP1;
            return;
        }
        if (pointsP2 == 4 && PlayerToInc == 1){
            --pointsP2;
            return;
        }
        if (PlayerToInc == 1){
            ++pointsP1;
        }else {
            ++pointsP2;
        }
    }
}
