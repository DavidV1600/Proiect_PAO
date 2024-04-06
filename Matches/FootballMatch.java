package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class FootballMatch extends Match {
    private int teamAScore;
    private int teamBScore;//trebuie modificat ca am pus deja in clasa de baza scorurile

    public FootballMatch(Team teamA, Team teamB, LocalDateTime dateTime, int teamAScore, int teamBScore) {
        super(teamA, teamB, dateTime);
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    public String getWinner() {
        if (teamAScore > teamBScore) {
      return getTeamA().getName();
        } else if (teamAScore < teamBScore) {
            return getTeamB().getName();
        } else {
            return "Draw";
        }
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
