package Proiect_PAO.Stadiums;

import java.util.ArrayList;
import java.util.List;

public class StadiumService {
    private List<Stadium> stadiums;

    private StadiumService() {
        stadiums = new ArrayList<>();
    }

    public void addStadium(Stadium stadium) {
        stadiums.add(stadium);
    }

    public void removeStadium(Stadium stadium) {
        stadiums.remove(stadium);
    }

    public List<Stadium> getAllStadiums() {
        return stadiums;
    }

}

