package Services;

import Model.MatchSet;

public class SetCounter {

    public static boolean needsTiebreak(MatchSet matchSet){
        return matchSet.getPointsPlayer1() == 6 && matchSet.getPointsPlayer2() == 6;
    }
    public static void evalScore (MatchSet matchSet, int PlayerToInc){
        int pointsP1 = matchSet.getPointsPlayer1();
        int pointsP2 = matchSet.getPointsPlayer2();

        if (pointsP1 == 6 && pointsP2 == 5){
            if (PlayerToInc == 1) {
                matchSet.incPointsPlayer1();
                matchSet.setNewSet(true);
            }
        }

        if (pointsP1 == 5 && pointsP2 == 6){
            if (PlayerToInc == 2){
                matchSet.incPointsPlayer2();
                matchSet.setNewSet(true);
            }
        }

        if(pointsP1 == 5 && PlayerToInc == 1){
            matchSet.incPointsPlayer1();
            if (pointsP2 < 5){
                matchSet.setNewSet(true);
            }
        }

        if(pointsP2 == 5 && PlayerToInc == 2){
            matchSet.incPointsPlayer2();
            if (pointsP1 < 5){
                matchSet.setNewSet(true);
            }
        }

        if(pointsP1 < 5 || pointsP2 < 5){
            if (PlayerToInc == 1 && pointsP1 < 5){
                matchSet.incPointsPlayer1();
            }
            if (PlayerToInc == 2 && pointsP2 < 5){
                matchSet.incPointsPlayer2();
            }
        }
    }
}
