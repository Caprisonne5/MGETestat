package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "matchsets")
public final class MatchSet {
    @PrimaryKey(autoGenerate = true)
    public int SetId;
    @ColumnInfo
    public int matchId;
    @ColumnInfo
    private int pointsPlayer1;
    @ColumnInfo
    private int pointsPlayer2;
    @Ignore
    private boolean newSet;
    @Ignore
    private Tiebreak tiebreak;
    public MatchSet(int matchId){
        this.matchId = matchId;
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
    public void setPointsPlayer1(int points){
        this.pointsPlayer1 = points;
    }

    public void setPointsPlayer2(int points){
        this.pointsPlayer2 = points;
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
