package Proiect_PAO.Teams;

public class FootballTeam extends Team {
    private String coachName;

    public FootballTeam(String name, String coachName) {
        super(name);
        this.coachName = coachName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}

