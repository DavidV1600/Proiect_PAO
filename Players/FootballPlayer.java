package Proiect_PAO.Players;

import javax.swing.text.Position;

public class FootballPlayer extends Player {
    private Position position;

    public FootballPlayer(String name, int age, Position position) {
        super(name, age);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}