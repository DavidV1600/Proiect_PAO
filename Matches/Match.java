package Proiect_PAO.Matches;

import Proiect_PAO.Stadiums.Stadium;
import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class Match {
    private Team teamA;
    private Team teamB;
    private int teamAScore;
    private int teamBScore;
    private LocalDateTime dateTime;
    private Stadium stadium;

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Match(Team teamA, Team teamB, LocalDateTime dateTime, Stadium stadium) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateTime = dateTime;
        this.stadium = stadium;
    }

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    @Override
    public String toString() {
        return  teamA.getName() +
                " -VS- " +
                teamB.getName() +
                "\nDate: " + dateTime;
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

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }
}

