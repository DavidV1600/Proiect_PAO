package Proiect_PAO;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Players.Player;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;

/*
Adăugarea unui nou turneu în sistem.
Ștergerea unui turneu din sistem.
Actualizarea datelor unui turneu existent.
Adăugarea unei echipe în cadrul unui turneu.
Ștergerea unei echipe din cadrul unui turneu.
Afișarea tuturor echipelor participante la un anumit turneu.
Afișarea tuturor meciurilor dintr-un anumit turneu.
Afișarea detaliilor despre un anumit meci.
Calcularea scorului unui meci și determinarea câștigătorului.
Afișarea clasamentului echipelor în cadrul unui turneu.
 */

/*
Turneu (Tournament): Reprezintă un eveniment sportiv organizat în care echipele concurează între ele.
Echipă (Team): Grup de jucători care concurează împreună în cadrul unui turneu.
Jucător (Player): Persoană care face parte dintr-o echipă și participă la meciuri.
Meci (Match): Confruntare între două echipe în cadrul unui turneu.
Stadion (Stadium): Locul unde se desfășoară meciurile din cadrul turneului.
Arbitru (Referee): Persoană responsabilă cu aplicarea regulilor și supervizarea meciurilor.
Trofeu (Trophy): Premiu acordat echipei câștigătoare a turneului.
Spectator (Spectator): Persoană care asistă la meciuri în tribunele stadionului.
 */
import Proiect_PAO.Players.Player;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;
import Proiect_PAO.Players.PlayerService;
import Proiect_PAO.Teams.TeamService;
import Proiect_PAO.Tournaments.TournamentService;

public class Main {
    public static void main(String[] args) {

        PlayerService playerService = new PlayerService();
        TeamService teamService = TeamService.getInstance();
        TournamentService<Team, Match> tournamentService = TournamentService.getInstance();

        Player player1 = new Player("Adi Popescu", 25);
        Player player2 = new Player("Marius Ionescu", 28);
        playerService.addPlayer(player1);
        playerService.addPlayer(player2);

        Team team1 = new Team("Team A");
        Team team2 = new Team("Team B");
        teamService.addTeam(team1);
        teamService.addTeam(team2);

        Tournament<Team, Match> tournament1 = new Tournament<>("Tournament 1");
        Tournament<Team, Match> tournament2 = new Tournament<>("Tournament 2");
        tournamentService.addTournament(tournament1);
        tournamentService.addTournament(tournament2);

        System.out.println("All players:");
        for (Player player : playerService.getAllPlayers()) {
            System.out.println(player);
        }

        System.out.println("\nAll teams:");
        for (Team team : teamService.getAllTeams()) {
            System.out.println(team);
        }

        System.out.println("\nAll tournaments:");
        for (Tournament<Team, Match> tournament : tournamentService.getAllTournaments()) {
            System.out.println(tournament);
        }
    }
}

