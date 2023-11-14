package Model;

import java.util.ArrayList;

public class PlayerRepository {
    private static ArrayList <Player> players;
    static {
        players = new ArrayList<>();
        players.add(new Player("Robert"));
        players.add(new Player("Kevin"));
    }

    public static ArrayList<Player> getPlayers(){return players;};

    public static void addPlayer(Player player){players.add(player);}
}
