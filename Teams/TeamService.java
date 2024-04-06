package Proiect_PAO.Teams;

import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private static TeamService instance;
    private List<Team> teams;

    // Private constructor to prevent instantiation from outside
    private TeamService() {
        teams = new ArrayList<>();
    }

    // Static method to get the singleton instance
    public static TeamService getInstance() {
        if (instance == null) {
            instance = new TeamService();
        }
        return instance;
    }

    // Other methods for adding/removing teams, etc.
    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

    public List<Team> getAllTeams() {
        return teams;
    }
}
