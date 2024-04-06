package Proiect_PAO.Players;

public class FootballPlayer extends Player {
    private String position;

    public FootballPlayer(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}