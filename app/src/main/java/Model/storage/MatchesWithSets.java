package Model.storage;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;

import Model.MatchSet;

import Model.Match;

public class MatchesWithSets {
    @Embedded
    public Match match;
    @Relation(entity = MatchSet.class,
            parentColumn = "MatchId",
            entityColumn = "matchId"
    )
    public List<MatchSet> matchSets = new ArrayList<>();

    public String setsToString (int Player) {
        StringBuilder res = new StringBuilder();
        if (this.matchSets.size() == 0){
            return "No Sets Available";
        }
        if (Player == 1){
            for (MatchSet set : this.matchSets){
                res.append(String.format("%s  ", Integer.toString(set.getPointsPlayer1())));
            }
            return res.toString();
        } else {
            for (MatchSet set : this.matchSets){
                res.append(String.format("%s  ", Integer.toString(set.getPointsPlayer2())));
            }
        }
        return res.toString();
    }

    public String getPlayer1() {
        return this.match.P1 + determineWinner(1);
    }

    public String getPlayer2() {
        return this.match.P2 + determineWinner(2);
    }

    private String determineWinner (int Player) {
        int winsP1 = 0;
        int winsP2 = 0;
        String winner = " (Winner)";

        for (MatchSet set : matchSets) {
            if (set.getPointsPlayer1() > set.getPointsPlayer2()){
                ++winsP1;
            } else {
                ++winsP2;
            }
        }
        if (winsP1 > winsP2 && Player == 1) {
            return winner;
        } else if (winsP2 > winsP1 && Player == 2) {
            return winner;
        }else {
            return "";
        }

    }
}
