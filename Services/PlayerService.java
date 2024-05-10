package Proiect_PAO.Services;

import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Players.Player;
import Proiect_PAO.CsvWriterService;
import Proiect_PAO.Players.PlayerImpl;
import Proiect_PAO.Teams.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private static PlayerService instance;
    private final List<Player> players;
    private int nextPlayerId; // Next available player ID

    private PlayerService() {
        players = new ArrayList<>();
        loadPlayersFromDatabase();
        // Determine the next available player ID based on existing players
        nextPlayerId = players.isEmpty() ? 1 : players.stream().mapToInt(Player::getId).max().getAsInt() + 1;
    }

    // Method to get the singleton instance
    public static PlayerService getInstance() {
        if (instance == null) {
            instance = new PlayerService();
        }
        return instance;
    }

    private void loadPlayersFromDatabase() {
        String query = "SELECT * FROM Players";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String playerName = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int teamId = resultSet.getInt("team_id");
                players.add(new PlayerImpl(id, playerName, age, teamId));
            }
            CsvWriterService.writeCsv("load_players_from_database");
        } catch (SQLException e) {
            System.out.println("Error loading players from the database: " + e.getMessage());
        }
    }

    public void addPlayer(Player player) {
        player.setId(nextPlayerId); // Assign the next available ID to the player
        players.add(player);
        insertPlayerIntoDatabase(player);
        CsvWriterService.writeCsv("add_player");
        // Increment the next player ID for future additions
        nextPlayerId++;
    }

    private void insertPlayerIntoDatabase(Player player) {
        String query = "INSERT INTO Players (id, name, age, team_id) VALUES (" +
                player.getId() + ", '" + player.getName() + "', " +
                player.getAge() + ", " + player.getTeamId() + ")";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public List<Player> getAllPlayers() {
        List<Player> allPlayers = new ArrayList<>();
        String query = "SELECT * FROM Players";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);

            CsvWriterService.writeCsv("get_players");
            while (resultSet.next()) {
                String playerName = resultSet.getString("name");
                int playerAge = resultSet.getInt("age");
                allPlayers.add(new PlayerImpl(nextPlayerId, playerName, playerAge, 1)); //tre modificat
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allPlayers;
    }

    public void removePlayer(Player player){
        deletePlayerFromDatabase(player);
        players.remove(player);
        // Log the action in CSV
        CsvWriterService.writeCsv("player_removed");
    }
    private void deletePlayerFromDatabase(Player player) {
        String query = "DELETE FROM Players WHERE id = '" + player.getId() + "'";
        try {
            DatabaseManager.executeQuery(query);
            // Log the action in CSV
            CsvWriterService.writeCsv("remove_player");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void removePlayersFromTeam(Team team) {
        List<Player> playersToRemove = new ArrayList<>();
        for(Player player : players) {
            if(player.getTeamId() == team.getId()){
                playersToRemove.add(player);
            }
        }
        for(Player player : playersToRemove) {
            removePlayer(player);
        }
    }


    public int getNextPlayerId() {
        int maxId = 0;
        for (Player player : players) {
            if (player.getId() > maxId) {
                maxId = player.getId();
            }
        }
        return maxId + 1;
    }
}
