package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;

import java.util.*;

public class Team implements Comparable<Team>{
    private String name;
    private Set<Player> players;

    private int wins;

    public Team(String name) {
        this.name = name;
    this.players = new TreeSet<>();
    wins = 0;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Team name: ").append(name).append("\nPlayers:\n");
        for (Player player : players){
            stringBuilder.append(player.getName()).append(", ");
        }
        return stringBuilder.toString();
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

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void incrementWins(){
        this.wins++;
    }

    public static Team createTeamFromInput(Scanner scanner){
        System.out.println("Enter team name: ");
        String teamName = scanner.nextLine();
        return new Team(teamName);
    }

    @Override
    public int compareTo(Team o) {
        if(this.wins > o.wins){
            return 1;
        } else if(this.wins < o.wins){
            return -1;
        } else {
            return this.name.compareTo(o.name);//if their score is equal then sort them alphabetically
        }
    }
}
