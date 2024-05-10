package Proiect_PAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

    ActionsManager manager = ActionsManager.getInstance();
    manager.startMenu();

    }
}

