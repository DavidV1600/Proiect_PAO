package Proiect_PAO;

public enum BasketballPositions {
    POINT_GUARD(1, "Point Guard"),
    SHOOTING_GUARD(2, "Shooting Guard"),
    SMALL_FORWARD(3, "Small Forward"),
    POWER_FORWARD(4, "Power Forward"),
    CENTER(5, "Center");

    private final int id;
    private final String position;

    BasketballPositions(int id, String position) {
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
