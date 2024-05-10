package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;
import Proiect_PAO.Players.PlayerImpl;
import Proiect_PAO.Services.PlayerService;
import Proiect_PAO.Services.TeamService;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TeamImpl implements Team {
    private final int id;
    private String name;
    private final Set<Player> players;
    private int wins;
    private int tournamentId; // New field to store the tournament ID

    public TeamImpl(int id, String name, int tournamentId) {
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
    public String getName() {
        return name;
    }

    @Override
    public int getWins() {
        return wins;
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

    // Implementing the createTeamFromInput method
    public static Team createTeamFromInput(int teamId, Scanner scanner, int tournamentId) {
        System.out.print("Enter team name: ");
        String teamName = scanner.nextLine();
        Team newTeam = new TeamImpl(teamId, teamName, tournamentId);
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
            Player newPlayer = new PlayerImpl(playerId, playerName, playerAge, teamId);
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

    @Override
    public void updateTeam(Scanner scanner) {
        int option;

        do {
            displayMenu();
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    updateNameByInput(scanner);
                    break;
                case 2:
                    addPlayerByInput(scanner);
                    break;
                case 3:
                    removePlayerByInput(scanner);
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (option != 0);
    }

    private void displayMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Change name of the team");
        System.out.println("2. Add player to the team");
        System.out.println("3. Remove player from the team");
        System.out.println("0. Exit");
    }

    private void updateNameByInput(Scanner scanner) {
        System.out.print("Enter new name for the team: ");
        String newName = scanner.nextLine();
        TeamService.getInstance().updateTeamNameInDatabase(name, newName);
        this.setName(newName);
        System.out.println("Team name updated successfully!");
    }

    public void setName(String newName) {
        name = newName;
    }
    private void addPlayerByInput(Scanner scanner) {
        System.out.print("Enter name for new player: ");
        String playerName = scanner.nextLine();
        System.out.print("Enter age for the player: ");
        int playerAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        int playerId = PlayerService.getInstance().getNextPlayerId();
        Player newPlayer = new PlayerImpl(playerId, playerName, playerAge, this.getId());
        this.addPlayer(newPlayer);
        PlayerService.getInstance().addPlayer(newPlayer);
        System.out.println("Player added to the team successfully!");
    }

    private void removePlayerByInput(Scanner scanner) {
        System.out.println("Current Players:");
        displayMembers();
        System.out.print("Enter name of player to remove: ");
        String playerToRemove = scanner.nextLine();
        Player player = null;
        for (Player p : getPlayers()) {
            if (p.getName().equals(playerToRemove)) {
                player = p;
                break;
            }
        }
        if (player != null) {
            PlayerService.getInstance().removePlayer(player);
            players.remove(player);
            System.out.println("Player removed from the team successfully!");
        } else {
            System.out.println("Player not found!");
        }

    }

    public Set<Player> getPlayers() {
        return players;
    }
}
