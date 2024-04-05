package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class Match {
    private Team teamA;
    private Team teamB;
    private LocalDateTime dateTime;

    public Match(Team teamA, Team teamB, LocalDateTime dateTime) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateTime = dateTime;
    }
    @Override
    public String toString() {
        return "Match{" +
                "homeTeam=" + teamA.getName() +
                ", awayTeam=" + teamB.getName() +
                ", dateTime=" + dateTime +
                '}';
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }
}

