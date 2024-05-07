package Proiect_PAO;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Players.Player;
import Proiect_PAO.Services.MatchService;
import Proiect_PAO.Services.PlayerService;
import Proiect_PAO.Services.TeamService;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;
import Proiect_PAO.Services.TournamentService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ActionsManager {
    private static ActionsManager instance = null;
    private final TournamentService<Team, Match> tournamentService;
    private final TeamService teamService;
    private final PlayerService playerService;
    private final MatchService matchService;

    private ActionsManager() {
        tournamentService = TournamentService.getInstance();
        playerService = PlayerService.getInstance();
        teamService = TeamService.getInstance();
        matchService = MatchService.getInstance();
        setupTournaments();
    }

    private void setupTournaments() {
        for(Tournament tournament : tournamentService.getTournaments()){
            setupTournament(tournament);
        }
    }
    private void setupTournament(Tournament<Team, Match> tournament) {
        // Add teams to the tournament
        addTeamsToTournament(tournament);

        // Add players to each team
        List<Team> teams = tournament.getTeams();
        for (Team team : teams) {
            addPlayersToTeam(team);
        }

        // Generate matches between teams
        addMatchesFromTournament(tournament);
    }
    private void addPlayersToTeam(Team team) {
        // Retrieve players from the database or user input
        List<Player> players = playerService.getAllPlayers(); // Example: Assuming you have a method to get all players

        // Add players to the team
        for (Player player : players) {
            if (player.getTeamId() == team.getId())
                team.addPlayer(player);
        }
    }

    private void addMatchesFromTournament(Tournament<Team, Match> tournament) {
        // Get teams assigned to the tournament
        List<Team> teams = tournament.getTeams();

        // Generate matches between teams
        for (Match match : matchService.getAllMatches()){
            if(match.getTeamA().getTournamentId() == tournament.getId())
                tournament.addMatch(match);
        }
    }

    private void addTeamsToTournament(Tournament<Team, Match> tournament) {
        // Retrieve teams from the database or user input
        List<Team> teams = teamService.getTeams(); // Example: Assuming you have a method to get all teams

        // Assign teams to the tournament
        for (Team team : teams) {
            if (team.getTournamentId() == tournament.getId()) {
                tournament.addTeam(team);
            }
        }
    }
    public static ActionsManager getInstance() {
        if (instance == null) {
            instance = new ActionsManager();
        }
        return instance;
    }

    public void startMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addTournament(scanner);
                    break;
                case 2:
                    deleteTournament(scanner);
                    break;
                case 3:
                    updateTournament(scanner);
                    break;
                case 4:
                    addTeamToTournament(scanner);
                    break;
                case 5:
                    removeTeamFromTournament(scanner);
                    break;
                case 6:
                    displayTeamsInTournament(scanner);
                    break;
                case 7:
                    displayMatchesInTournament(scanner);
                    break;
                case 8:
                    displayTournamentStandings(scanner);
                    break;
                case 9:
                    displayTournaments();
                    break;
                case 10:
                    generateMatches(scanner);
                    break;
                case 11:
                    playTournaments(scanner);
                    break;
                case 0:
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        } while (option != 0);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n===== Menu =====");
        System.out.println("1. Add tournament");
        System.out.println("2. Delete tournament");
        System.out.println("3. Update tournament name");
        System.out.println("4. Add team to tournament");
        System.out.println("5. Remove team from tournament");
        System.out.println("6. Display teams in tournament");
        System.out.println("7. Display matches in tournament");
        System.out.println("8. Display tournament standings");
        System.out.println("9. Display tournaments");
        System.out.println("10. Generate matches for tournaments");
        System.out.println("11. Play tournaments");
        System.out.println("0. Exit");
        System.out.println("================\n");
    }
    private int generateNewTournamentId() {
        // Get all existing tournaments
        List<Tournament<Team, Match>> allTournaments = tournamentService.getAllTournaments();

        // Find the maximum ID among existing tournaments
        int maxId = 0;
        for (Tournament<Team, Match> tournament : allTournaments) {
            int currentId = tournament.getId(); // Assuming tournament names start with 'T' followed by an ID
            if (currentId > maxId) {
                maxId = currentId;
            }
        }

        // Increment the maximum ID to get the new ID
        return maxId + 1;
    }

    private int generateNewTeamId() {
        // Get all existing tournaments
        List<Team> allTeams = TeamService.getInstance().getAllTeams();

        // Find the maximum ID among existing tournaments
        int maxId = 0;
        for (Team team : allTeams) {
            int currentId = team.getId(); // Assuming tournament names start with 'T' followed by an ID
            if (currentId > maxId) {
                maxId = currentId;
            }
        }

        // Increment the maximum ID to get the new ID
        return maxId + 1;
    }

    private void addTournament(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String name = scanner.nextLine();
        int tournamentId = generateNewTournamentId();
        Tournament<Team, Match> tournament = new Tournament<>(name,tournamentId);//tre modifict
        tournamentService.addTournament(tournament);
        System.out.println("Tournament added successfully.");
    }

    private void deleteTournament(Scanner scanner) throws SQLException {
        System.out.print("Enter tournament name to delete: ");
        String name = scanner.nextLine();
        if (tournamentService.deleteTournamentByName(name)) {
            System.out.println("Tournament deleted successfully.");
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void updateTournament(Scanner scanner) {//name for now
        System.out.print("Enter tournament name to update: ");
        String oldName = scanner.nextLine();
        System.out.print("Enter new tournament name: ");
        String newName = scanner.nextLine();
        tournamentService.updateTournamentName(oldName, newName);
    }

    private void addTeamToTournament(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            int teamId = generateNewTeamId();
            tournament.addTeam(Team.createTeamFromInput(teamId, scanner, tournament.getId()));
            System.out.println("Team added to tournament successfully.");
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void removeTeamFromTournament(Scanner scanner) throws SQLException {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            if (tournament.removeTeam(scanner)) {
                System.out.println("Team removed from tournament successfully.");
            } else {
                System.out.println("Team not name found");
            }
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void displayTeamsInTournament(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.displayTeams();
            System.out.println("Want to see players of a team? [y/n]");
            String wantToSeeTeams = scanner.nextLine();
            if(wantToSeeTeams.compareTo("y") == 0){
                tournament.displayTeamsComposition(scanner);
            }
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void displayMatchesInTournament(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.displayMatches();
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void displayTournamentStandings(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.printStandings();
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void displayTournaments(){
        System.out.println("Tournaments: ");
        tournamentService.displayAllTournaments();
    }

    private void generateMatches(Scanner scanner) throws SQLException {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.generateMatches();
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void playTournaments(Scanner scanner) throws SQLException {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.playMatches(scanner);
        } else {
            System.out.println("Tournament not found.");
        }
    }

}

