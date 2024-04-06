package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MatchService {
    private List<Match> matches;

    public MatchService() {
        this.matches = new ArrayList<>();
    }

    public void addMatch(Team teamA, Team teamB, LocalDateTime dateTime) {
        Match match = new Match(teamA, teamB, dateTime);
        matches.add(match);
    }

    public List<Match> getAllMatches() {
        return matches;
    }
}
