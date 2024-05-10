package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;

public interface Match {
    Team getTeamA();
    Team getTeamB();
    int getTeamAScore();
    void setTeamAScore(int teamAScore);
    int getTeamBScore();
    void setTeamBScore(int teamBScore);
}
