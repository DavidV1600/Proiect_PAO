package Proiect_PAO.Services;

import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Players.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Proiect_PAO.CsvWriterService;

public class PlayerService {
    private static PlayerService instance;
    private List<Player> players;

    // Private constructor to prevent instantiation from outside
    private PlayerService() {
        players = new ArrayList<>();
    }

    // Method to get the singleton instance
    public static PlayerService getInstance() {
        if (instance == null) {
            instance = new PlayerService();
        }
        return instance;
    }

    public void addPlayer(Player player) {
        players.add(player);
        // Log the action in CSV
        CsvWriterService.writeCsv("add_player");

        // Insert the player into the database
        insertPlayerIntoDatabase(player);
    }

    private void insertPlayerIntoDatabase(Player player) {
        String query = "INSERT INTO Players (name, age) VALUES ('" + player.getName() + "', " + player.getAge() + ")";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public Player getPlayerByName(String name) {
        String query = "SELECT * FROM Players WHERE name = '" + name + "'";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);

            CsvWriterService.writeCsv("get_player");
            if (resultSet.next()) {
                String playerName = resultSet.getString("name");
                int playerAge = resultSet.getInt("age");
                return new Player(playerName, playerAge);
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        // Player not found
        return null;
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
                allPlayers.add(new Player(playerName, playerAge));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allPlayers;
    }

    public void updatePlayer(String oldName, Player newPlayer) {
        String query = "UPDATE Players SET name = '" + newPlayer.getName() + "', age = " + newPlayer.getAge() + "' WHERE name = '" + oldName + "'";
        try {
            DatabaseManager.executeQuery(query);
            // Log the action in CSV
            CsvWriterService.writeCsv("update_player");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void removePlayer(String name) {
        String query = "DELETE FROM Players WHERE name = '" + name + "'";
        try {
            DatabaseManager.executeQuery(query);
            // Log the action in CSV
            CsvWriterService.writeCsv("remove_player");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}
