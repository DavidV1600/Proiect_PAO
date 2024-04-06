package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.BasketballMatch;
import Proiect_PAO.Teams.BasketballTeam;

public class BasketballTournament extends Tournament<BasketballTeam, BasketballMatch> {
    private String type; // e.g., "Regional", "National"
    private String sponsor;

    public BasketballTournament(String name, String type, String sponsor) {
        super(name);
        this.type = type;
        this.sponsor = sponsor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }
}

