package Proiect_PAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

    ActionsManager manager = ActionsManager.getInstance();
    manager.startMenu();

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
    }
}

