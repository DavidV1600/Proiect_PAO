package Proiect_PAO.Teams;

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
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

    public List<Team> getAllTeams() {
        return teams;
    }
}
