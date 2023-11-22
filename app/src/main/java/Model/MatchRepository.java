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
}

