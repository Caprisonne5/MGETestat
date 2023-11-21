package Model.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import Model.Match;
import Model.MatchSet;

@Database(entities = { Match.class, MatchSet.class }, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class MatchDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();
}
