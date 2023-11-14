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
            addMatch();
    }

    public static List<MatchesWithSets> getMatches() {
        return database.matchDao().getMatchesWithSets();
    }
    public static void addMatch(Match match) {
        database.matchDao().insertMatch(match);
    }
    public static Match addMatch () {
        Match match = new Match();
        MatchSet matchSet1 = new MatchSet(match.MatchId);
        MatchSet matchSet2 = new MatchSet(match.MatchId);
        Player p1 = new Player("Kevin");
        Player p2 = new Player("Markus");

        match.matchSets.add(matchSet1);
        match.matchSets.add(matchSet2);

        match.P1 = p1;
        match.P2 = p2;

        addMatch(match);
        return match;
    }
}
