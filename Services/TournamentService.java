package Proiect_PAO.Services;

import Proiect_PAO.CsvWriterService;
import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournamentService<T extends Team, M extends Match> {
    private static TournamentService instance;
    private List<Tournament<T, M>> tournaments;

    private TournamentService() {
        tournaments = new ArrayList<>();

        loadTournamentsFromDatabase();
    }

    public static TournamentService getInstance() {
        if (instance == null) {
            instance = new TournamentService();
        }
        return instance;
    }

    private void loadTournamentsFromDatabase() {
        String query = "SELECT * FROM Tournaments";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);
            while (resultSet.next()) {
                String tournamentName = resultSet.getString("name");
                int tournamentId = resultSet.getInt("id");
                // Create a tournament object and add it to the list
                tournaments.add(new Tournament<>(tournamentName, tournamentId));
            }
            CsvWriterService.writeCsv("load_tournaments_from_database");
        } catch (SQLException e) {
            System.out.println("Error loading tournaments from the database: " + e.getMessage());
        }
    }
    public void addTournament(Tournament<T, M> tournament) {
        tournaments.add(tournament);
        // Log the action in CSV
        CsvWriterService.writeCsv("add_tournament");

        // Insert the tournament into the database
        insertTournamentIntoDatabase(tournament);
    }

    private void insertTournamentIntoDatabase(Tournament<T, M> tournament) {
        String query = "INSERT INTO Tournaments (name, tournament_id) VALUES ('" + tournament.getName() + "', '" + tournament.getId() + "')";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void removeTournament(Tournament<T, M> tournament) {
        tournaments.remove(tournament);
        // Log the action in CSV
        CsvWriterService.writeCsv("remove_tournament");

        // Delete the tournament from the database
        deleteTournamentFromDatabase(tournament);
    }

    private void deleteTournamentFromDatabase(Tournament<T, M> tournament) {
        String query = "DELETE FROM Tournaments WHERE name = '" + tournament.getName() + "'";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public List<Tournament<T, M>> getAllTournaments() {
        List<Tournament<T, M>> allTournaments = new ArrayList<>();
        String query = "SELECT * FROM Tournaments";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);

            CsvWriterService.writeCsv("get_tournaments");
            while (resultSet.next()) {
                String tournamentName = resultSet.getString("name");
                allTournaments.add(new Tournament<>(tournamentName,1));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allTournaments;
    }

    public void displayAllTournaments() {
        System.out.println("All Tournaments:");
        for (int i = 0; i < tournaments.size(); i++) {
            System.out.println((i + 1) + ". " + tournaments.get(i).getName());
        }
    }

    public boolean deleteTournamentByName(String name) {
        for (Tournament<T, M> tournament : tournaments) {
            if (tournament.getName().equals(name)) {
                tournaments.remove(tournament);
                return true;
            }
        }
        return false;
    }

    public Tournament<T, M> getTournamentByName(String name) {
        for (Tournament<T, M> tournament : tournaments) {
            if (tournament.getName().equals(name)) {
                return tournament;
            }
        }
        return null;
    }
}
