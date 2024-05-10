package Proiect_PAO.Matches;

import Proiect_PAO.Teams.Team;

import java.time.LocalDateTime;

public interface Match {
    Team getTeamA();
    void setTeamA(Team teamA);
    Team getTeamB();
    void setTeamB(Team teamB);
    int getTeamAScore();
    void setTeamAScore(int teamAScore);
    int getTeamBScore();
    void setTeamBScore(int teamBScore);
    LocalDateTime getDateTime();
    void setDateTime(LocalDateTime dateTime);
}
