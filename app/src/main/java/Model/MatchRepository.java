package Model;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import Model.storage.MatchDatabase;
import Model.storage.MatchesWithSets;

public class MatchRepository {
    private static MatchDatabase database;
    public static void initialize(Context context) {
        database = Room.databaseBuilder(context, MatchDatabase.class, "match.db").allowMainThreadQueries().build();
    }

    public static List<MatchesWithSets> getMatches() {
        return database.matchDao().getMatchesWithSets();
    }
    public static void addMatch(Match match) {
        database.matchDao().insertMatch(match);
    }
    public static void addSet (MatchSet set) { database.matchDao().insertMatchSet(set); }
    public static Match addMatch () {
        Match match = new Match(1);

        MatchSet matchSet1 = new MatchSet(match.MatchId);
        MatchSet matchSet2 = new MatchSet(match.MatchId);


        matchSet1.setPointsPlayer1(6);
        matchSet1.setPointsPlayer2(7);

        matchSet2.setPointsPlayer1(6);
        matchSet2.setPointsPlayer2(4);

        match.P1 = "Markus";
        match.P2 = "Robert";

        addSet(matchSet1);
        addSet(matchSet2);
        addMatch(match);
        return match;
    }
}

