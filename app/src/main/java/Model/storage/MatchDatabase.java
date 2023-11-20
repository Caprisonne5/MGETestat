package Model.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Model.Match;
import Model.MatchSet;

@Database(entities = { Match.class, MatchSet.class }, version = 1, exportSchema = false)
public abstract class MatchDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();
}
