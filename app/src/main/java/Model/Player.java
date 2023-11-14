package Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "players")
public final class Player {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo
    public String name;
    public Player(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public int getId() {return id;}
}
