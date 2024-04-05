package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;

import java.util.ArrayList;
import java.util.List;

public class Tournament<T extends Team, M extends Match> {
    private String name;
    private List<T> teams;
    private List<M> matches;

    public Tournament(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

    // Methods to add teams and matches
    public void addTeam(T team) {
        teams.add(team);
    }

    public void addMatch(M match) {
        matches.add(match);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getTeams() {
        return teams;
    }

    public void setTeams(List<T> teams) {
        this.teams = teams;
    }

    public List<M> getMatches() {
        return matches;
    }

    public void setMatches(List<M> matches) {
        this.matches = matches;
    }
}
