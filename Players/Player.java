package Proiect_PAO.Players;

public class Player implements Comparable<Player> {
    private int id; // New field to store the player ID
    private String name;
    private int age;
    private int teamId; // New field to store the team ID

    public Player(int id, String name, int age, int teamId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "ID: " + id +
                "\nName: " + name +
                "\nAge: " + age;
    }

    @Override
    public int compareTo(Player player) {
        return this.name.compareTo(player.getName());
    }
}
