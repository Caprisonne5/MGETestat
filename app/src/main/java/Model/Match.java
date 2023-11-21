package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
    @ColumnInfo
    public Date date;

    public Match(int MatchId){
        this.date = new Date();
        this.MatchId = MatchId;
        this.matchSets = new ArrayList<>();
    }

    public List<MatchSet> getSets(){return matchSets;}
    public void addSet(MatchSet matchSet){this.matchSets.add(matchSet);}
}


