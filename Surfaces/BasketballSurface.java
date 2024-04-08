package Proiect_PAO.Surfaces;

public enum BasketballSurface {
    HARDWOOD(1, "Hardwood"),
    ASPHALT(2, "Asphalt"),
    CONCRETE(3, "Concrete"),
    RUBBER(4, "Rubber"),
    SYNTHETIC(5, "Synthetic"),
    GRASS(6, "Grass"),
    TURF(7, "Turf");

    private final int id;
    private final String surfaceName;

    BasketballSurface(int id, String surfaceName) {
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

