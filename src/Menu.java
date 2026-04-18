import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class Menu<E extends Player> {
    private MatchSchedule schedule = new MatchSchedule();
    private Team team = new Team();
    private Striker striker = new Striker();
    private Midfielder midfielder = new Midfielder();
    private Defender defender = new Defender();
    private Goalkeeper goalkeeper = new Goalkeeper();
    private Coach coach = new Coach();
    private AllPlayerList<E> playerList = new AllPlayerList();

    public void playerMenu(Scanner input) {
        boolean playerMenuActive = true;
        do {
            System.out.println("\n\nWelcome to Player Menu");
            System.out.println("\nMain Menu:");
            System.out.println("1. Display Player Details.");
            System.out.println("2. Display All Player Details.");
            System.out.println("3. Display Striker Details.");
            System.out.println("4. Display All Striker Details.");
            System.out.println("5. Display Midfielder Details.");
            System.out.println("6. Display All Midfielder Details.");
            System.out.println("7. Display Defender Details.");
            System.out.println("8. Display All Defender Details.");
            System.out.println("9. Display Goalkeeper Details.");
            System.out.println("10. Display All Goalkeeper Details.");
            System.out.println("11. Display Match Schedule.");
            System.out.println("12. Exit.");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter player name: ");
                    String name = input.nextLine();
                    if (striker.isExist(name))
                        striker.displayDetails(name);
                    else if (midfielder.isExist(name))
                        midfielder.displayDetails(name);
                    else if (defender.isExist(name))
                        defender.displayDetails(name);
                    else if (goalkeeper.isExist(name))
                        goalkeeper.displayDetails(name);
                    else
                        System.out.println("Player not Found");
                    break;
                case 2:
                    Striker.displayAllStrikersDetails();
                    Midfielder.displayAllMidfieldersDetails();
                    Defender.displayAllDefendersDetails();
                    Goalkeeper.displayAllGoalkeepersDetails();
                    break;
                case 3:
                    input.nextLine();
                    System.out.print("Enter Striker name: ");
                    String strikerName = input.nextLine();
                    striker.displayDetails(strikerName);
                    break;
                case 4:
                    Striker.displayAllStrikersDetails();
                    break;
                case 5:
                    input.nextLine();
                    System.out.print("Enter Midfielder name: ");
                    String midfielderName = input.nextLine();
                    midfielder.displayDetails(midfielderName);
                    break;
                case 6:
                    Midfielder.displayAllMidfieldersDetails();
                    break;
                case 7:
                    input.nextLine();
                    System.out.print("Enter Defender name: ");
                    String defenderName = input.nextLine();
                    defender.displayDetails(defenderName);
                    break;
                case 8:
                    Defender.displayAllDefendersDetails();
                    break;
                case 9:
                    input.nextLine();
                    System.out.print("Enter Goalkeeper name: ");
                    String goalkeeperName = input.nextLine();
                    goalkeeper.displayDetails(goalkeeperName);
                    break;
                case 10:
                    Goalkeeper.displayAllGoalkeepersDetails();
                    break;
                case 11:
                    input.nextLine();
                    LocalDate matchDate = null;
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    boolean validDate = false;

                    while (!validDate) {
                        System.out.print("Enter Match Date (yyyy-MM-dd): ");
                        String dateString = input.nextLine();

                        try {
                            matchDate = LocalDate.parse(dateString, dateFormatter);
                            validDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }
                    schedule.displayMatchDetails(matchDate);
                    break;
                case 12:
                    playerMenuActive = false;
                    System.out.println("\n\tExiting Player Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        } while (playerMenuActive);
    }

    public void coachMenu(Scanner input) {
        boolean coachMenuActive = true;
        do {
            System.out.println("\n\nWelcome to Coach Menu.");
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Player.");
            System.out.println("2. Remove Player.");
            System.out.println("3. Display Coach Details.");
            System.out.println("4. Assign Coach to Team.");
            System.out.println("5. Remove Coach from Team.");
            System.out.println("6. Display Full Team.");
            System.out.println("7. Add Player to Team.");
            System.out.println("8. Remove Player from Team.");
            System.out.println("9. Exit.");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Which type of player you want to add?\n1.Striker\n2.Midfielder\n3.Defender\n4.Goalkeeper");
                    int n = input.nextInt();
                    while (n > 4 || n < 1)
                        System.out.println("Invalid Input, Try again:");
                    if (n == 1)
                        striker.add();
                    else if (n == 2)
                        midfielder.add();
                    else if (n == 3)
                        defender.add();
                    else
                        goalkeeper.add();
                    break;
                case 2:
                    System.out.println("Enter the player name you want to remove: ");
                    String name = input.nextLine();
                    if (striker.isExist(name))
                        striker.remove(name);
                    else if (midfielder.isExist(name))
                        midfielder.remove(name);
                    else if (defender.isExist(name))
                        defender.remove(name);
                    else if (goalkeeper.isExist(name))
                        goalkeeper.remove(name);
                    else
                        System.out.println("The name is not found!");
                    break;
                case 3:
                    Coach.displayAllCoachDetails();
                    break;
                case 4:
                    input.nextLine();
                    System.out.print("Enter Coach Name to Assign: ");
                    String coachName = input.nextLine();
                    System.out.print("Enter Coach Type: ");
                    String coachType = input.nextLine();
                    team.assignCoach(coachName, coachType, Coach.getCoachList());
                    break;
                case 5:
                    input.nextLine();
                    System.out.print("Enter Coach Name to Remove: ");
                    String coachToRemove = input.nextLine();
                    team.removeTeamCoach(coachToRemove);
                    break;
                case 6:
                    team.displayTeamPlayers();
                    break;
                case 7:
                    input.nextLine();
                    System.out.print("Enter Player Name to Add: ");
                    String newPlayer = input.nextLine();
                    playerList.setPlayersList();
                    team.addPlayer(newPlayer, playerList.getPlayersList());
                    break;
                case 8:
                    input.nextLine();
                    System.out.print("Enter Player Name to Remove: ");
                    String removePlayer = input.nextLine();
                    team.removePlayerFromTeam(removePlayer);
                    break;
                case 9:
                    coachMenuActive = false;
                    System.out.println("\n\tExiting Coach Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        } while (coachMenuActive);
    }

    public void adminMenu(Scanner input) {
        boolean adminMenuActive = true;
        do {
            System.out.println("\n\nWelcome to Admin Menu");
            System.out.println("\nMain Menu:");
            System.out.println("1. Add Player.");
            System.out.println("2. Remove Player.");
            System.out.println("3. Add Coach.");
            System.out.println("4. Remove Coach.");
            System.out.println("5. Display Full Team.");
            System.out.println("6. Add New Match Schedule.");
            System.out.println("7. Display Match Schedule.");
            System.out.println("8. Exit.");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();


            switch (choice) {
                case 1:
                    System.out.println("Which type of player you want to add?\n1.Striker\n2.Midfielder\n3.Defender\n4.Goalkeeper");
                    int n = input.nextInt();
                    while (n > 4 || n < 1)
                        System.out.println("Invalid Input, Try again:");
                    if (n == 1)
                        striker.add();
                    else if (n == 2)
                        midfielder.add();
                    else if (n == 3)
                        defender.add();
                    else
                        goalkeeper.add();
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Enter the player name you want to remove: ");
                    String name = input.nextLine();
                    if (striker.isExist(name))
                        striker.remove(name);
                    else if (midfielder.isExist(name))
                        midfielder.remove(name);
                    else if (defender.isExist(name))
                        defender.remove(name);
                    else if (goalkeeper.isExist(name))
                        goalkeeper.remove(name);
                    else
                        System.out.println("The name is not found!");
                case 3:
                    coach.addCoach();
                    break;
                case 4:
                    input.nextLine();
                    System.out.print("Enter Coach Name to Remove: ");
                    String coachName = input.nextLine();
                    coach.removeCoach(coachName);
                    break;
                case 5:
                    team.displayTeamPlayers();
                    break;
                case 6:
                    schedule.addMatchSchedule();
                    break;
                case 7:
                    input.nextLine();
                    LocalDate matchDate = null;
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    boolean validDate = false;

                    while (!validDate) {
                        System.out.print("Enter Match Date (yyyy-MM-dd): ");
                        String dateString = input.nextLine();

                        try {
                            matchDate = LocalDate.parse(dateString, dateFormatter);
                            validDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    }
                    schedule.displayMatchDetails(matchDate);
                    break;
                case 8:
                    adminMenuActive = false;
                    System.out.println("\n\tExiting Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        } while (adminMenuActive);
    }
}