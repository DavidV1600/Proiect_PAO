package Proiect_PAO.Teams;

public class FootballTeam extends Team {
    private String coachName;

    public FootballTeam(String name, int tournamentId, String coachName) {
        super(name, tournamentId);
        this.coachName = coachName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
