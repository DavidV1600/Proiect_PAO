package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class MatchLogic implements Match {
    private Team teamA;
    private Team teamB;
    private int teamAScore;
    private int teamBScore;
    private LocalDateTime dateTime;

    public MatchLogic(Team teamA, Team teamB, LocalDateTime dateTime) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.dateTime = dateTime;
        this.teamAScore = -1;
        this.teamBScore = -1;
    }

    public MatchLogic(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAScore = -1;
        this.teamBScore = -1;
    }

    @Override
    public Team getTeamA() {
        return teamA;
    }

    @Override
    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    @Override
    public Team getTeamB() {
        return teamB;
    }

    @Override
    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    @Override
    public int getTeamAScore() {
        return teamAScore;
    }

    @Override
    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    @Override
    public int getTeamBScore() {
        return teamBScore;
    }

    @Override
    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(teamA.getName()).append(" -VS- ").append(teamB.getName());
        if (teamAScore != -1 && teamBScore == -1) {
            stringBuilder.append("\n").append(teamAScore).append(" - ").append(teamBScore);
        }
        stringBuilder.append("\nDate: ").append(dateTime);
        return stringBuilder.toString();
    }
}
