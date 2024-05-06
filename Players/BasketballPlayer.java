package Proiect_PAO.Players;

import javax.swing.text.Position;

public class BasketballPlayer extends Player {
    private Position position;
    private int teamId; // New field to store the team ID

    public BasketballPlayer(String name, int age, Position position, int teamId) {
        super(name, age, teamId);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
