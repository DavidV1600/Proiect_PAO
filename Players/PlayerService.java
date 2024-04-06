package Proiect_PAO.Players;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private List<Player> players;

    public PlayerService() {
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null; // Player not found
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public void updatePlayer(String oldName, Player newPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(oldName)) {
                players.set(i, newPlayer);
                return;
            }
        }
        // Player with oldName not found
    }

    public void removePlayer(String name) {
        players.removeIf(player -> player.getName().equals(name));
    }

}

