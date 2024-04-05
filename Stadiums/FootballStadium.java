package Proiect_PAO.Stadiums;

public class FootballStadium extends Stadium {
    private String surfaceType;//maybe change to enum

    public FootballStadium(String name, String location, int capacity, String surfaceType) {
        super(name, location, capacity);
        this.surfaceType = surfaceType;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }
}
