package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;

import java.util.*;

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

    public void printStandings() {
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

        System.out.println("Standings for Tournament: " + name);
        int rank = 1;
        for (T team : teams) {
            System.out.println(rank + ". " + team.getName() + " - Wins: " + team.getWins());
            rank++;
        }
    }

    public boolean removeTeam(Scanner scanner) {
        System.out.println("Enter team name to be removed: ");
        String teamName = scanner.nextLine();
        Iterator<T> iterator = teams.iterator();
        while (iterator.hasNext()) {
            T team = iterator.next();
            if (team.getName().equals(teamName)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void displayTeams() {
        System.out.println("Teams in Tournament '" + name + "':");
        for (T team : teams) {
            System.out.println("- " + team.getName());
        }
    }

    public void displayMatches() {
        System.out.println("Matches in Tournament '" + name + "':");
        for (M match : matches) {
            System.out.println("- " + match.toString());
        }
    }

    public void playMatches(Scanner scanner){
        for(M match : matches){
            System.out.println(match);
            System.out.println("Add score for " + match.getTeamA().getName());
            int scoreA = scanner.nextInt();
            System.out.println("Add score for " + match.getTeamB().getName());
            int scoreB = scanner.nextInt();
            match.setTeamAScore(scoreA);
            match.setTeamBScore(scoreB);
        }
    }

    public void displayTeamsComposition(Scanner scanner){
        String option;
        while (true){
            displayTeams();
            System.out.println("\nEnter the team name you want too see the composition or enter 0 if you want to exit: ");
            option = scanner.nextLine();
            if(option.compareTo("0") == 0)
                return;
            Iterator<T> iterator = teams.iterator();
            boolean teamFound = false;
            while (iterator.hasNext()) {
                T team = iterator.next();
                if (team.getName().equals(option)) {
                    team.displayMembers();
                    teamFound = true;
                }
            }
            if(!teamFound){
                System.out.println("Team name not found");
            }
        }
    }
}
