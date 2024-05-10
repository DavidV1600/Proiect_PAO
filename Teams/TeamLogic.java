package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;
import Proiect_PAO.Players.PlayerLogic;
import Proiect_PAO.Services.PlayerService;
import Proiect_PAO.Services.TeamService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TeamLogic implements Team {
    private int id;
    private String name;
    private Set<Player> players;
    private int wins;
    private int tournamentId; // New field to store the tournament ID

    public TeamLogic(int id, String name, int tournamentId) {
        this.id = id;
        this.name = name;
        this.tournamentId = tournamentId;
        this.players = new TreeSet<>();
        wins = 0;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public int getWins() {
        return wins;
    }

    @Override
    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public void incrementWins() {
        this.wins++;
    }

    @Override
    public int getTournamentId() {
        return tournamentId;
    }

    @Override
    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public void displayMembers() {
        int index = 1;
        for (Player player : players) {
            System.out.println(index + ". " + player.getName());
            index++;
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Implementing the createTeamFromInput method
    public static Team createTeamFromInput(int teamId, Scanner scanner, int tournamentId) {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        Team newTeam = new TeamLogic(teamId, teamName, tournamentId);
        TeamService.getInstance().insertTeamIntoDatabase(newTeam);
        System.out.print("Enter number of players in the team: ");
        int playersNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 1; i <= playersNumber; ++i) {
            System.out.print(i + ". Enter name for player: ");
            String playerName = scanner.nextLine();
            System.out.print("Enter age for the player: ");
            int playerAge = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            int playerId = PlayerService.getInstance().getNextPlayerId();
            Player newPlayer = new PlayerLogic(playerId, playerName, playerAge, teamId);
            newTeam.addPlayer(newPlayer);
            PlayerService.getInstance().addPlayer(newPlayer);
        }
        TeamService.getInstance().addTeam(newTeam);
        return newTeam;
    }

    @Override
    public int compareTo(Team o) {
        if (this.wins > o.getWins()) {
            return 1;
        } else if (this.wins < o.getWins()) {
            return -1;
        } else {
            return this.name.compareTo(o.getName()); // if their score is equal then sort them alphabetically
        }
    }
}
