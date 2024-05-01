package Proiect_PAO.Services;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Stadiums.Stadium;
import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MatchService {
    private List<Match> matches;

    public MatchService() {
        this.matches = new ArrayList<>();
    }

    public void addMatch(Team teamA, Team teamB, LocalDateTime dateTime, Stadium stadium) {
        Match match = new Match(teamA, teamB, dateTime, stadium);
        matches.add(match);
    }

    public List<Match> getAllMatches() {
        return matches;
    }
}
