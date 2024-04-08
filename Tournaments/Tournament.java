package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Matches.MatchService;
import Proiect_PAO.Teams.Team;

import java.util.*;

public class Tournament<T extends Team, M extends Match> {
    private String name;
    private List<T> teams;
    private List<M> matches;

    public Tournament(String name) {
        this.name = name;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tournament name: ").append(name).append("\nTeams:\n");
        for(Team team : teams){
            stringBuilder.append(team.getName()).append(", ");
        }
        return stringBuilder.toString();
    }

    public void generateMatches() {
        matches.clear();

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                M match = (M) new Match(teams.get(i), teams.get(j));
                matches.add(match);
            }
        }
    }

    public void setMatchScore(M match, int teamAScore, int teamBScore) {
        match.setTeamAScore(teamAScore);
        match.setTeamBScore(teamBScore);
    }

    public void printFinalStandings() {
        for (M match : matches) {
            T homeTeam = (T) match.getTeamA();
            T awayTeam = (T) match.getTeamB();
            if (match.getTeamAScore() > match.getTeamBScore()) {
                homeTeam.incrementWins();
            } else if (match.getTeamBScore() > match.getTeamAScore()) {
                awayTeam.incrementWins();
            }
        }

        Collections.sort(teams);
        Collections.reverse(teams);

        System.out.println("Final Standings for Tournament: " + name);
        int rank = 1;
        for (T team : teams) {
            System.out.println(rank + ". " + team.getName() + " - Wins: " + team.getWins());
            rank++;
        }
    }

}
