package Services;

import Model.Player;
import Model.Set;

public class SetCounter {

    public static boolean needsTiebreak(Set set){
        return set.getPointsPlayer1() == 6 && set.getPointsPlayer2() == 6;
    }
    public static void evalScore (Set set, int PlayerToInc){
        int pointsP1 = set.getPointsPlayer1();
        int pointsP2 = set.getPointsPlayer2();

        if (pointsP1 == 6 && pointsP2 == 5){
            if (PlayerToInc == 1) {
                set.incPointsPlayer1();
                set.setNewSet(true);
            }
        }

        if (pointsP1 == 5 && pointsP2 == 6){
            if (PlayerToInc == 2){
                set.incPointsPlayer2();
                set.setNewSet(true);
            }
        }

        if(pointsP1 == 5 && PlayerToInc == 1){
            set.incPointsPlayer1();
            if (pointsP2 < 5){
                set.setNewSet(true);
            }
        }

        if(pointsP2 == 5 && PlayerToInc == 2){
            set.incPointsPlayer2();
            if (pointsP1 < 5){
                set.setNewSet(true);
            }
        }

        if(pointsP1 < 5 || pointsP2 < 5){
            if (PlayerToInc == 1 && pointsP1 < 5){
                set.incPointsPlayer1();
            }
            if (PlayerToInc == 2 && pointsP2 < 5){
                set.incPointsPlayer2();
            }
        }
    }
}
