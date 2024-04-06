package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;
import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private List<Team> teams;

    private TeamService() {
        teams = new ArrayList<>();
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

