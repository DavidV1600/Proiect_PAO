package Proiect_PAO;

import Proiect_PAO.Players.Player;
import Proiect_PAO.Services.PlayerService;
import Proiect_PAO.Services.TeamService;
import Proiect_PAO.Services.TournamentService;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

    // ActionsManager manager = ActionsManager.getInstance();
    // manager.startMenu();

    //
    //        String url = "jdbc:oracle:thin:@localhost:1521:xe";
    //        String user = "c##Piele";
    //        String password = "20030616";
    //
    //        try (Connection connection = DriverManager.getConnection(url, user, password)) {
    //            System.out.println("Conexiunea la baza de date s-a stabilit cu succes!");
    //
    //            // Exemplu de interogare a bazei de date
    //            Statement statement = connection.createStatement();
    //            ResultSet resultSet = statement.executeQuery("SELECT * FROM Players");
    //
    //            // Procesați rezultatele
    //            while (resultSet.next()) {
    //                System.out.println(resultSet.getString("id") + ", " +
    // resultSet.getString("Name"));
    //            }
    //        } catch (SQLException e) {
    //            System.out.println("A apărut o eroare de conexiune: " + e.getMessage());
    //        }

        TournamentService tournamentService = TournamentService.getInstance();
        //tournamentService.addTournament("turneu1");
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        for(Tournament tournament : tournaments){
            System.out.println(tournament);
        }
    }
}

