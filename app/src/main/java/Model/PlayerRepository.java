package Model;

import java.util.ArrayList;

public class PlayerRepository {
    private static ArrayList <Player> players;
    static {
        players = new ArrayList<>();
        players.add(new Player("Robert", 1));
        players.add(new Player("Kevin", 2));
    }

    public static ArrayList<Player> getPlayers(){return players;};

    public static void addPlayer(Player player){players.add(player);}
}
