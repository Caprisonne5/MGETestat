package Model;


public class Tiebreak {

    public int pointsP1;
    public int pointsP2;
    private boolean tieBreakFinished;

    public Tiebreak (){
        this.pointsP1 = 0;
        this.pointsP2 = 0;
        this.tieBreakFinished = false;
    }

    public int getPointsP1 () {return this.pointsP1;}
    public int getPointsP2 () {return this.pointsP2;}
    public boolean getTiebreakFinished() {return this.tieBreakFinished;}
    public void setTieBreakFinished(boolean tieBreakFinished) {this.tieBreakFinished = tieBreakFinished;}
    public void incPoint (int PlayerToInc) {
        if (PlayerToInc == 1){
            this.pointsP1++;
            return;
        }else {
            this.pointsP2++;
        }
    }

    public String evalScore (int PlayerToInc, MatchSet matchSet) {
        if ((pointsP1 >= 6 && (pointsP1-pointsP2) >= 1 && PlayerToInc == 1) || ((pointsP2-pointsP1) >= 1 && pointsP2 >= 6 && PlayerToInc == 2)){
            incPoint(PlayerToInc);
            setTieBreakFinished(true);
            if (PlayerToInc == 1){
                matchSet.incPointsPlayer1();
            }else {
                matchSet.incPointsPlayer2();
            }
        } else {
            incPoint(PlayerToInc);
        }
        return String.format("%s : %2d", pointsP1, pointsP2);
    }

}
