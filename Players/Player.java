package Proiect_PAO.Players;

public class Player implements Comparable<Player>{
    private String name;
    private int age;
    private int teamId; // New field to store the team ID

    public Player(String name, int age, int teamId) {
        this.name = name;
        this.age = age;
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nAge: " + age;
    }

    @Override
    public int compareTo(Player player) {
        return this.name.compareTo(player.getName());
    }
}
