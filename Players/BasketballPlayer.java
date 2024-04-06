package Proiect_PAO.Players;

public class BasketballPlayer extends Player {
    private int pointsPerGame;

    public BasketballPlayer(String name, int age, int pointsPerGame) {
        super(name, age);
        this.pointsPerGame = pointsPerGame;
    }

    public int getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(int pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }
}
