package Proiect_PAO.Players;

public interface Player extends Comparable<Player> {
    int getId();
    void setId(int id);
    String getName();
    void setName(String name);
    int getAge();
    void setAge(int age);
    int getTeamId();
    void setTeamId(int teamId);
}
