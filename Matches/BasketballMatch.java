package Proiect_PAO.Matches;

import Proiect_PAO.Teams.BasketballTeam;
import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public class BasketballMatch extends Match{
    private int teamAScore;
    private int teamBScore;

    public BasketballMatch(Team teamA, Team teamB, LocalDateTime localDateTime, int teamAScore, int teamBScore) {
        super(teamA, teamB, localDateTime);
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
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

    public String getWinner() {
        if (teamAScore > teamBScore) {
            return getTeamA().getName();
        } else if (teamAScore < teamBScore) {
            return getTeamB().getName();
        } else {
            return "Draw";
        }
    }
}

