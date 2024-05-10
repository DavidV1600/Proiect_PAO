package Proiect_PAO.Players;

public class PlayerImpl implements Player {
    private int id;
    private final String name;
    private final int age;
    private final int teamId;

    public PlayerImpl(int id, String name, int age, int teamId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.teamId = teamId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getTeamId() {
        return teamId;
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
