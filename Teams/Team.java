package Proiect_PAO.Teams;

import Proiect_PAO.Players.Player;

import java.util.Scanner;
import java.util.Set;

public interface Team extends Comparable<Team> {
  void addPlayer(Player player);
  void removePlayer(Player player);
  Set<Player> getPlayers();
  String getName();
  void setName(String name);
  void setPlayers(Set<Player> players);
  int getWins();
  void setWins(int wins);
  void incrementWins();
  int getTournamentId();
  void setTournamentId(int tournamentId);
  static Team createTeamFromInput(int teamId, Scanner scanner, int tournamentId) {
    // Method body will be implemented in the TeamLogic class
    return null;
  }
  void displayMembers();
  int getId();
  void setId(int id);
}
