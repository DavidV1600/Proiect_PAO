package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    // Add a player to the team
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Remove a player from the team
    public void removePlayer(Player player) {
        players.remove(player);
    }

    // Get all players in the team
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
