package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.FootballMatch;
import Proiect_PAO.Teams.FootballTeam;

public class FootballTournament extends Tournament<FootballTeam, FootballMatch> {
    private String location;
    private String organizer;

    public FootballTournament(String name, int tournamentId, String location, String organizer) {
        super(name, tournamentId);
        this.location = location;
        this.organizer = organizer;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}

