package Proiect_PAO.Services;

import Proiect_PAO.CsvWriterService;
import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;
import Proiect_PAO.Tournaments.TournamentLogic;

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

  public static void setInstance(TournamentService instance) {
    TournamentService.instance = instance;
  }

  public List<Tournament<T, M>> getTournaments() {
    return tournaments;
  }

  public void setTournaments(List<Tournament<T, M>> tournaments) {
    this.tournaments = tournaments;
  }

  private void loadTournamentsFromDatabase() {
    String query = "SELECT * FROM Tournaments";
    try {
      ResultSet resultSet = DatabaseManager.executeQuery(query);
      while (resultSet.next()) {
        String tournamentName = resultSet.getString("name");
        int tournamentId = resultSet.getInt("id");
        // Create a tournament object and add it to the list
        tournaments.add(new TournamentLogic<>(tournamentName, tournamentId));
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
    String query =
        "INSERT INTO Tournaments VALUES ('"
            + tournament.getId()
            + "', '"
            + tournament.getName()
            + "')";
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
        allTournaments.add(new TournamentLogic<>(tournamentName, 1));
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

  public boolean deleteTournamentByName(String name) throws SQLException {
    for (Tournament<T, M> tournament : tournaments) {
      if (tournament.getName().equals(name)) {
        TeamService.getInstance().removeTeamsFromTournament(tournament);
        deleteTournamentFromDatabase(tournament);
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

  public void updateTournamentName(String oldName, String newName) {
    Tournament<T, M> tournament = getTournamentByName(oldName);
    if (tournament != null) {
        updateTournamentNameInDatabase(tournament, newName);
        tournament.setName(newName);

    } else {
      System.out.println("Tournament with name '" + oldName + "' not found.");
    }
  }

  private void updateTournamentNameInDatabase(Tournament<T, M> tournament, String newName) {
    String query =
        "UPDATE Tournaments SET name = '"
            + newName
            + "' WHERE name = '"
            + tournament.getName()
            + "'";
    try {
      DatabaseManager.executeQuery(query);
      CsvWriterService.writeCsv("tournament_updated");
    } catch (SQLException e) {
      System.out.println("Error executing query: " + e.getMessage());
    }
  }
}