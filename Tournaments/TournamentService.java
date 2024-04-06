package Proiect_PAO.Tournaments;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;

import java.util.ArrayList;
import java.util.List;

public class TournamentService<T extends Team, M extends Match> {
    private static TournamentService instance;
    private List<Tournament<T, M>> tournaments;

    private TournamentService() {
        tournaments = new ArrayList<>();
    }
    public static TournamentService getInstance() {
        if (instance == null) {
            instance = new TournamentService();
        }
        return instance;
    }

    public void addTournament(Tournament<T, M> tournament) {
        tournaments.add(tournament);
    }

    public void removeTournament(Tournament<T, M> tournament) {
        tournaments.remove(tournament);
    }

    public List<Tournament<T, M>> getAllTournaments() {
        return tournaments;
    }

}

