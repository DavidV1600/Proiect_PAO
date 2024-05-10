package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Matches.MatchLogic;
import Proiect_PAO.Services.MatchService;
import Proiect_PAO.Services.TeamService;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Teams.TeamLogic;

import java.sql.SQLException;
import java.util.*;

public class TournamentLogic<T extends Team, M extends Match> implements Tournament<T, M> {
    private String name;
    private int id;
    private List<T> teams;
    private List<M> matches;

    public TournamentLogic(String name, int id) {
        this.name = name;
        this.id = id;
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public void addTeam(T team) {
        team.setTournamentId(id); // Set the tournament ID for the team
        teams.add(team);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void generateMatches() throws SQLException {
        matches.clear();

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                M match = (M) new MatchLogic(teams.get(i), teams.get(j));
                matches.add(match);
                MatchService.getInstance().addMatch(match);
            }
        }
    }

    @Override
    public void setMatchScore(M match, int teamAScore, int teamBScore) {
        match.setTeamAScore(teamAScore);
        match.setTeamBScore(teamBScore);
    }

    @Override
    public void printStandings() {
        Collections.sort(teams);
        Collections.reverse(teams);

        System.out.println("Standings for Tournament: " + name);
        int rank = 1;
        for (T team : teams) {
            System.out.println(rank + ". " + (((TeamLogic) team).getName() + " - Wins: " + ((TeamLogic) team).getWins()));
            rank++;
        }
    }

    @Override
    public boolean removeTeam(Scanner scanner) throws SQLException {
        System.out.print("Enter team name to be removed: ");
        String teamName = scanner.nextLine();
        Iterator<T> iterator = teams.iterator();
        while (iterator.hasNext()) {
            T team = iterator.next();
            if (((TeamLogic) team).getName().equals(teamName)) {
                TeamService.getInstance().removeTeam(team);
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayTeams() {
        System.out.println("Teams in Tournament '" + name + "':");
        for (T team : teams) {
            System.out.println("- " + ((TeamLogic) team).getName());
        }
    }

    @Override
    public void displayMatches() {
        System.out.println("Matches in Tournament '" + name + "':");
        for (M match : matches) {
            System.out.println("- " + match.toString());
        }
    }

    @Override
    public void playMatches(Scanner scanner) throws SQLException {
        for (M match : matches) {
            System.out.println(match);
            System.out.print("Add score for " + match.getTeamA().getName() + ": ");
            int scoreA = scanner.nextInt();
            System.out.print("Add score for " + match.getTeamB().getName() + ": ");
            int scoreB = scanner.nextInt();
            match.setTeamAScore(scoreA);
            match.setTeamBScore(scoreB);
            MatchService.getInstance().updateMatch(match);
            if (scoreA >= scoreB) {//= is for now unhandled case
                match.getTeamA().incrementWins();
                TeamService.getInstance().updateTeamWinsInDatabase(match.getTeamA());
            } else {
                match.getTeamB().incrementWins();
                TeamService.getInstance().updateTeamWinsInDatabase(match.getTeamB());
            }
        }
    }

    @Override
    public void displayTeamsComposition(Scanner scanner) {
        String option;
        while (true) {
            displayTeams();
            System.out.println("\nEnter the team name you want too see the composition or enter 0 if you want to exit: ");
            option = scanner.nextLine();
            if (option.compareTo("0") == 0)
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
            if (!teamFound) {
                System.out.println("Team name not found");
            }
        }
    }
}
