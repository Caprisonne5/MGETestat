package Model.storage;

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
            entityColumn = "MatchId"
    )
    public List<MatchSet> matchSets;

}
