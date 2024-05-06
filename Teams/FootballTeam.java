package Proiect_PAO.Teams;

public class FootballTeam extends Team {
    private String coachName;

    public FootballTeam(int id, String name, int tournamentId, String coachName) {
        super(id, name, tournamentId);
        this.coachName = coachName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
