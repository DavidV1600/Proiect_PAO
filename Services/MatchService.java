package Proiect_PAO.Services;

import Proiect_PAO.CsvWriterService;
import Proiect_PAO.DatabaseManager;
import Proiect_PAO.Matches.Match;
import Proiect_PAO.Matches.MatchLogic;
import Proiect_PAO.Teams.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MatchService {
    private static MatchService instance;
    private List<Match> matches;

    // Private constructor to prevent instantiation from outside
    private MatchService() {
        this.matches = new ArrayList<>();
        loadMatchesFromDatabase();
    }

    // Method to get the singleton instance
    public static MatchService getInstance() {
        if (instance == null) {
            instance = new MatchService();
        }
        return instance;
    }

    private void loadMatchesFromDatabase() {
        String query = "SELECT * FROM Matches";
        try {
            ResultSet resultSet = DatabaseManager.executeQuery(query);
            while (resultSet.next()) {
                int teamAId = resultSet.getInt("team1_id");
                int teamBId = resultSet.getInt("team2_id");
                int teamAScore = resultSet.getInt("team1_score");
                int teamBScore = resultSet.getInt("team2_score");
                Team teamA = TeamService.getInstance().getTeamById(teamAId);
                Team teamB = TeamService.getInstance().getTeamById(teamBId);
                Match match = new MatchLogic(teamA, teamB);
                match.setTeamAScore(teamAScore);
                match.setTeamBScore(teamBScore);
                matches.add(match);
            }
            CsvWriterService.writeCsv("load_matches_from_database");
        } catch (SQLException e) {
            System.out.println("Error loading matches from the database: " + e.getMessage());
        }
    }

    public void createMatch(Team teamA, Team teamB, LocalDateTime dateTime) throws SQLException {
        Match match = new MatchLogic(teamA, teamB, dateTime);
        addMatch(match);
    }

    public void addMatch(Match match) throws SQLException {
        matches.add(match);
        addMatchToDatabase(match);
    }

    private void addMatchToDatabase(Match match) throws SQLException {
        String query = "INSERT INTO Matches VALUES ('" + match.getTeamA().getId() +
                "', '" + match.getTeamB().getId() +
                "', '" + match.getTeamAScore() +
                "', '" + match.getTeamBScore() + "')";
        DatabaseManager.executeQuery(query);
        CsvWriterService.writeCsv("match_inserted");
    }

    public List<Match> getAllMatches() {
        return matches;
    }

    public Match getMatchById(int team1_id, int team2_id) {
        for (Match match : matches) {
            if (match.getTeamA().getId() == team1_id && match.getTeamB().getId() == team2_id) {
                return match;
            }
        }
        return null; // Match not found
    }

    public void updateMatch(Match oldMatch) throws SQLException {
        Match match = getMatchById(oldMatch.getTeamA().getId(), oldMatch.getTeamB().getId());
        if (match != null) {
            match.setTeamAScore(oldMatch.getTeamAScore());
            match.setTeamBScore(oldMatch.getTeamBScore());
            updateMatchInDatabase(match);
            CsvWriterService.writeCsv("match_updated");
        }
    }

    private void updateMatchInDatabase(Match match) throws SQLException {
        String query = "UPDATE Matches SET team1_score = " + match.getTeamAScore() + ", team2_score = " +
                match.getTeamBScore() + " WHERE team1_id = " + match.getTeamA().getId() + " and " +
                "team2_id = " + match.getTeamB().getId();
        DatabaseManager.executeQuery(query);
    }

    public void deleteMatch(int team1_id, int team2_id) throws SQLException {
        Iterator<Match> iterator = matches.iterator();
        while (iterator.hasNext()) {
            Match match = iterator.next();
            if (match.getTeamA().getId() == team1_id && match.getTeamB().getId() == team2_id) {
                iterator.remove();
                deleteMatchFromDatabase(match);
                break;
            }
        }
    }

    private void deleteMatchFromDatabase(Match match) throws SQLException {
        String query = "DELETE FROM Matches WHERE team1_id = " + match.getTeamA().getId() + " and " +
                "team2_id = " + match.getTeamB().getId() ;
        DatabaseManager.executeQuery(query);
        CsvWriterService.writeCsv("match_deleted");
    }

    public void removeMatchFromTeam(Team team) throws SQLException {
        Iterator<Match> iterator = matches.iterator();
        while (iterator.hasNext()) {
            Match match = iterator.next();
            if (match.getTeamA().getId() == team.getId() || match.getTeamB().getId() == team.getId()) {
                iterator.remove(); // Use iterator's remove method to avoid ConcurrentModificationException
                deleteMatchFromDatabase(match);
            }
        }
    }



}
