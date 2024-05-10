package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Services.MatchService;
import Proiect_PAO.Services.TeamService;
import Proiect_PAO.Teams.Team;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public interface Tournament<T extends Team, M extends Match> {
    String getName();
    void setName(String name);
    int getId();
    void setId(int id);
    List<T> getTeams();
    void setTeams(List<T> teams);
    List<M> getMatches();
    void setMatches(List<M> matches);
    void addTeam(T team);
    void addMatch(M match);
    void generateMatches() throws SQLException;
    void setMatchScore(M match, int teamAScore, int teamBScore);
    void printStandings();
    boolean removeTeam(Scanner scanner) throws SQLException;
    void displayTeams();
    void displayMatches();
    void playMatches(Scanner scanner) throws SQLException;
    void displayTeamsComposition(Scanner scanner);
}
