package Proiect_PAO.Services;

import Proiect_PAO.CsvWriterService;
import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private static TeamService instance;
    private List<Team> teams;

    private TeamService() {
        teams = new ArrayList<>();

        loadTeamsFromDatabase();
    }

    public static TeamService getInstance() {
        if (instance == null) {
            instance = new TeamService();
        }
        return instance;
    }

    public void addTeam(Team team) {
        teams.add(team);
        // Log the action in CSV
        //insertTeamIntoDatabase(team);
        CsvWriterService.writeCsv("add_team");

        // Insert the team into the database

    }

    public void insertTeamIntoDatabase(Team team) {
        String query = "INSERT INTO Teams (id, name, wins, tournament_id) VALUES ('" + team.getId() + "', '" +
                team.getName() + "', '" + team.getWins() + "', '" + team.getTournamentId() + "')";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void removeTeam(Team team) throws SQLException {

        PlayerService.getInstance().removePlayersFromTeam(team);
        MatchService.getInstance().removeMatchFromTeam(team);
        teams.remove(team);
        // Log the action in CSV
        deleteTeamFromDatabase(team);
        CsvWriterService.writeCsv("remove_team");

        // Delete the team from the database

    }

    private void loadTeamsFromDatabase() {
        String query = "SELECT * FROM Teams";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);
            while (resultSet.next()) {
                String teamName = resultSet.getString("name");
                int teamId = resultSet.getInt("id");
                //int wins = resultSet.getInt("wins");
                int tournamentId = resultSet.getInt("tournament_id");
                // Create a tournament object and add it to the list
                teams.add(new Team(teamId, teamName, tournamentId));
            }
            CsvWriterService.writeCsv("load_tournaments_from_database");
        } catch (SQLException e) {
            System.out.println("Error loading tournaments from the database: " + e.getMessage());
        }
    }

    public void removeTeamsFromTournament(Tournament tournament) throws SQLException {
        for(Team team: teams) {
            if(team.getTournamentId() == tournament.getId()) {
                removeTeam(team);
            }
        }
    }
    public void deleteTeamFromDatabase(Team team) {
        String query = "DELETE FROM Teams WHERE id = '" + team.getId() + "'";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public List<Team> getAllTeams() {
        List<Team> allTeams = new ArrayList<>();
        String query = "SELECT * FROM Teams";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);

            CsvWriterService.writeCsv("get_teams");
            while (resultSet.next()) {
                String teamName = resultSet.getString("name");
                allTeams.add(new Team(1, teamName, 2));//tre modificat
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allTeams;
    }
    public void updateTeamWinsInDatabase(Team team) {
        String query = "UPDATE Teams SET wins = '" + team.getWins() + "' WHERE id = '" + team.getId() + "'";
        try {
            DatabaseManager.executeQuery(query);
            CsvWriterService.writeCsv("team_updated");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
    private Team getTeamById(int teamId) {
        for (Team team : teams) {
            if (team.getId() == teamId) {
                return team;
            }
        }
        return null;
    }
}
