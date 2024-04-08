package Proiect_PAO.Surfaces;

public enum FootballSurface {
    GRASS(1, "Grass"),
    ARTIFICIAL_TURF(2, "Artificial Turf"),
    CLAY(3, "Clay"),
    GRAVEL(4, "Gravel"),
    SAND(5, "Sand"),
    TARMAC(6, "Tarmac"),
    CONCRETE(7, "Concrete");

    private final int id;
    private final String surfaceName;

    FootballSurface(int id, String surfaceName) {
        this.id = id;
        this.surfaceName = surfaceName;
    }

    public int getId() {
        return id;
    }

    public String getSurfaceName() {
        return surfaceName;
    }
}

