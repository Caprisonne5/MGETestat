package Model.storage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.Set;

import Model.Match;
import Model.MatchSet;
import Model.Player;

@Database(entities = { Match.class, MatchSet.class, Player.class }, version = 1, exportSchema = false)
public abstract class MatchDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();
}
