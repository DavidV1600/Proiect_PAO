package Proiect_PAO.Stadiums;

import Proiect_PAO.Surfaces.BasketballSurface;

public class BasketballStadium extends Stadium{
    private BasketballSurface surfaceType;//maybe change to enum

    public BasketballStadium(String name, String location, int capacity, BasketballSurface surfaceType) {
        super(name, location, capacity);
        this.surfaceType = surfaceType;
    }

    public BasketballSurface getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(BasketballSurface surfaceType) {
        this.surfaceType = surfaceType;
    }
}

