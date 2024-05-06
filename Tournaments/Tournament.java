package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;

import java.util.ArrayList;
import java.util.List;

public class Tournament<T extends Team, M extends Match> {
    private String name;
    private int tournamentId; // New field for the tournament ID
    private List<T> teams;
    private List<M> matches;

    public Tournament(String name, int tournamentId) {
        this.name = name;
        this.tournamentId = tournamentId;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    public void addTeam(T team) {
        team.setTournamentId(tournamentId); // Set the tournament ID for the team
        teams.add(team);
    }

    // Getter and setter for tournament ID
    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    // Other methods remain unchanged...
}
