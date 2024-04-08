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

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        ActionsManager manager = ActionsManager.getInstance();
        manager.startMenu();
    }
}

