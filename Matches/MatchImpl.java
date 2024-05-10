package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;


public class MatchImpl implements Match {
    private final Team teamA;
    private final Team teamB;
    private int teamAScore;
    private int teamBScore;

    public MatchImpl(Team teamA, Team teamB) {
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
    public Team getTeamB() {
        return teamB;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(teamA.getName()).append(" -VS- ").append(teamB.getName());
        if (teamAScore != -1 && teamBScore == -1) {
            stringBuilder.append("\n").append(teamAScore).append(" - ").append(teamBScore);
        }
        return stringBuilder.toString();
    }
}
