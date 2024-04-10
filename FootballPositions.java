package Proiect_PAO;

public enum FootballPositions {
    GOALKEEPER(1, "Goalkeeper"),
    DEFENDER(2, "Defender"),
    MIDFIELDER(3, "Midfielder"),
    FORWARD(4, "Forward");

    private final int id;
    private final String position;

    FootballPositions(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }
}
