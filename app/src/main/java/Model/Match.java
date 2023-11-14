package Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "matches")
public final class Match {
    @PrimaryKey(autoGenerate = true)
    public int MatchId;
    @Ignore
    public List<MatchSet> matchSets;
    @Ignore//@Embedded(prefix = "p1_")
    public Player P1;
    @Ignore//@Embedded(prefix = "p2_")
    public Player P2;

    public Match(){
        this.matchSets = new ArrayList<>();
    }

    public List<MatchSet> getSets(){return matchSets;}
    public void addSet(MatchSet matchSet){this.matchSets.add(matchSet);}
    public Player getP1(){return this.P1;}
    public Player getP2(){return this.P2;}
}


