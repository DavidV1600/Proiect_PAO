package Proiect_PAO.Matches;

import Proiect_PAO.Stadiums.Stadium;
import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class FootballMatch extends Match {
    public FootballMatch(Team teamA, Team teamB, LocalDateTime dateTime, Stadium stadium) {
        super(teamA, teamB, dateTime, stadium);
    }
}
