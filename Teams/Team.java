package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;

import java.util.*;

public class Team {
    private String name;
    private Set<Player> players;

    public Team(String name) {
        this.name = name;
    this.players = new TreeSet<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public Set<Player> getPlayers() {
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

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
