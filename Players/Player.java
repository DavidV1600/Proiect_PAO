package Proiect_PAO.Players;

public interface Player extends Comparable<Player> {
    int getId();
    void setId(int id);
    String getName();
    int getAge();
    int getTeamId();
}
