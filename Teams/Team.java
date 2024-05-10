package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;

import java.util.Scanner;

public interface Team extends Comparable<Team> {
  void addPlayer(Player player);
  String getName();
  int getWins();
  void incrementWins();
  int getTournamentId();
  void setTournamentId(int tournamentId);
  static Team createTeamFromInput(int teamId, Scanner scanner, int tournamentId) {
    // Method body will be implemented in the TeamLogic class
    return null;
  }
  void displayMembers();
  int getId();

}
