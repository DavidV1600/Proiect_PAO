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
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        Team newTeam = new Team(teamName);
        System.out.print("Enter number of players in the team: ");
        int playersNumber = scanner.nextInt();
        scanner.nextLine();
        for(int i=1; i<=playersNumber; ++i){
            System.out.print(i + ". Enter name for player: ");
            String playerName = scanner.nextLine();
            System.out.print("Enter age for the player: ");
            int playerAge = scanner.nextInt();
            scanner.nextLine();
            newTeam.addPlayer(new Player(playerName, playerAge));
        }
        return newTeam;
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
    public void displayMembers() {
        int index = 1;
        for(Player player : players){
            System.out.println(index + ". " + player.getName());
            index++;
        }
    }
}
