package Proiect_PAO.Stadiums;

import Proiect_PAO.Matches.BasketballMatch;

import java.util.ArrayList;
import java.util.List;

public class BasketballStadium extends Stadium{
    private String surfaceType;//maybe change to enum

    public BasketballStadium(String name, String location, int capacity, String surfaceType) {
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

