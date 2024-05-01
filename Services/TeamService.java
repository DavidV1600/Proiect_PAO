package Proiect_PAO.Services;

import Proiect_PAO.CsvWriterService;
import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Teams.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private static TeamService instance;
    private List<Team> teams;

    private TeamService() {
        teams = new ArrayList<>();
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
        CsvWriterService.writeCsv("add_team");

        // Insert the team into the database
        insertTeamIntoDatabase(team);
    }

    private void insertTeamIntoDatabase(Team team) {
        String query = "INSERT INTO Teams (name) VALUES ('" + team.getName() + "')";
        try {
            DatabaseManager.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void removeTeam(Team team) {
        teams.remove(team);
        // Log the action in CSV
        CsvWriterService.writeCsv("remove_team");

        // Delete the team from the database
        deleteTeamFromDatabase(team);
    }

    public void deleteTeamFromDatabase(Team team) {
        String query = "DELETE FROM Teams WHERE name = '" + team.getName() + "'";
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
                allTeams.add(new Team(teamName));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return allTeams;
    }
}
