package Proiect_PAO.Teams;

public class BasketballTeam extends Team {
    private int totalPoints;

    public BasketballTeam(String name, int tournamentId, int totalPoints) {
        super(name, tournamentId);
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}
