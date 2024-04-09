package Proiect_PAO;

import Proiect_PAO.Matches.Match;
import Proiect_PAO.Teams.Team;
import Proiect_PAO.Tournaments.Tournament;
import Proiect_PAO.Tournaments.TournamentService;

import java.util.Scanner;

public class ActionsManager {
    private static ActionsManager instance = null;
    private final TournamentService<Team, Match> tournamentService;

    private ActionsManager() {
        tournamentService = TournamentService.getInstance();
    }

    public static ActionsManager getInstance() {
        if (instance == null) {
            instance = new ActionsManager();
        }
        return instance;
    }

    public void startMenu() {
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

    private void addTournament(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String name = scanner.nextLine();
        Tournament<Team, Match> tournament = new Tournament<>(name);
        tournamentService.addTournament(tournament);
        System.out.println("Tournament added successfully.");
    }

    private void deleteTournament(Scanner scanner) {
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
        String name = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(name);
        if (tournament != null) {
            System.out.println("Enter new tournament name: ");
            String newName = scanner.nextLine();
            tournament.setName(newName);
            System.out.println("Tournament details updated successfully.");
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void addTeamToTournament(Scanner scanner) {
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.addTeam(Team.createTeamFromInput(scanner));
            System.out.println("Team added to tournament successfully.");
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void removeTeamFromTournament(Scanner scanner) {
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

    private void generateMatches(Scanner scanner){
        System.out.print("Enter tournament name: ");
        String tournamentName = scanner.nextLine();
        Tournament<Team, Match> tournament = tournamentService.getTournamentByName(tournamentName);
        if (tournament != null) {
            tournament.generateMatches();
        } else {
            System.out.println("Tournament not found.");
        }
    }

    private void playTournaments(Scanner scanner){
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

