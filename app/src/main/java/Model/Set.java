package Model;

public class Set {
    private int pointsPlayer1;
    private int pointsPlayer2;
    private boolean newSet;
    private Tiebreak tiebreak;

    public Set(){
        this.pointsPlayer1 = 0;
        this.pointsPlayer2 = 0;
        this.newSet = false;
    }

    public boolean getNewSet(){ return this.newSet; }
    public void setNewSet (boolean newSet) { this.newSet = newSet; }
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
    public void setTiebreak() {
        this.tiebreak = new Tiebreak();
    }
    public Tiebreak getTiebreak() {
        if (this.tiebreak != null) {
            return this.tiebreak;
        }else return null;
    }
}
