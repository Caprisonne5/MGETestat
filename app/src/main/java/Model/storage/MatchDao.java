package Model.storage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import Model.Match;
import Model.MatchSet;


@Dao
public interface MatchDao {
        @Transaction
        @Query("SELECT * FROM matches")
        List<MatchesWithSets> getMatchesWithSets();
        @Query("SELECT * FROM matchsets WHERE MatchId = :matchId")
        List<MatchSet> getSetsForMatch(int matchId);

        @Insert
        void insertMatch(Match match);
        @Insert
        void insertMatchSet(MatchSet set);

    }
