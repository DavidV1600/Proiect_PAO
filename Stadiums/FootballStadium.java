package Proiect_PAO.Stadiums;

import Proiect_PAO.Surfaces.FootballSurface;

public class FootballStadium extends Stadium {
    private FootballSurface surfaceType;//maybe change to enum

    public FootballStadium(String name, String location, int capacity, FootballSurface surfaceType) {
        super(name, location, capacity);
        this.surfaceType = surfaceType;
    }

    public FootballSurface getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(FootballSurface surfaceType) {
        this.surfaceType = surfaceType;
    }
}
