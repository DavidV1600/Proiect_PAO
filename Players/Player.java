package Proiect_PAO.Players;

public class Player implements Comparable<Player>{
    private String name;
    private int age;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
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
