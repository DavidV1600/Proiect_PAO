package Proiect_PAO.Players;

import javax.swing.text.Position;

public class BasketballPlayer extends Player {
    private Position position;

    public BasketballPlayer(String name, int age,Position position) {
        super(name, age);
        this.position = position;
    }

    public  Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
