package Proiect_PAO.Matches;

import Proiect_PAO.Stadiums.Stadium;
import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class BasketballMatch extends Match{
    public BasketballMatch(Team teamA, Team teamB, LocalDateTime localDateTime, Stadium stadium) {
        super(teamA, teamB, localDateTime, stadium);
    }

}

