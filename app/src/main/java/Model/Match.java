package Model;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(tableName = "matches")
public final class Match {
    @PrimaryKey
    public int MatchId;
    @Ignore
    public List<MatchSet> matchSets;
    @ColumnInfo
    public String P1;
    @ColumnInfo
    public String P2;

    public Match(int MatchId){
        this.MatchId = MatchId;
        this.matchSets = new ArrayList<>();
    }

    public List<MatchSet> getSets(){return matchSets;}
    public void addSet(MatchSet matchSet){this.matchSets.add(matchSet);}
}


