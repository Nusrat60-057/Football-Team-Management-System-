import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MatchSchedule extends Team {
    private String homeTeam;
    private String awyTeam;
    private LocalDate matchDate;
    private String location;

    private final File fileTeam = new File("E:\\Coading Java\\Football Team Managment\\src\\schedule.txt");

    public MatchSchedule() {}

    public MatchSchedule(String homeTeam, String awyTeam, LocalDate matchDate, String location) {
        this.homeTeam = homeTeam;
        this.awyTeam = awyTeam;
        this.matchDate = matchDate;
        this.location = location;
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwyTeam() {
        return this.awyTeam;
    }
    public void setAwyTeam(String awyTeam) {
        this.awyTeam = awyTeam;
    }

    public LocalDate getMatchDate() {
        return this.matchDate;
    }
    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public String getLocation() {
        return this.location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return matchDate + ": " + homeTeam + " vs " + awyTeam + " at " + location;
    }

    public void addMatchSchedule() {
        Scanner inp = new Scanner(System.in);

        System.out.print("Enter the Home Team: ");
        String home = inp.nextLine();

        System.out.print("Enter the Away Team: ");
        String away = inp.nextLine();

        System.out.print("Enter the Location: ");
        String location = inp.nextLine();

        LocalDate matchDate = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        boolean validDate = false;

        while (!validDate) {
            System.out.print("Enter Match Date (yyyy-MM-dd): ");
            String dateString = inp.nextLine();

            try {
                matchDate = LocalDate.parse(dateString, dateFormatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        MatchSchedule schedule = new MatchSchedule(home, away, matchDate, location);

        // Save the match to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileTeam, true))) {
            writer.write(matchDate + "," + home + "," + away + "," + location);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the match schedule: " + e.getMessage());
        }

        System.out.println("New Match Schedule Added: " + home + " vs " + away + " at " + location);
    }

    public void displayMatchDetails(LocalDate matchDate) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileTeam))) {
            String line;
            boolean dateFound = false;
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        LocalDate date = LocalDate.parse(parts[0], dateFormatter);
                        if (date.equals(matchDate)) {
                            dateFound = true;
                            System.out.println(date + ": " + parts[1] + " vs " + parts[2] + " at " + parts[3]);
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format in schedule: " + parts[0]);
                    }
                }
            }

            if (!dateFound) {
                System.out.println("No match schedule found for the date: " + matchDate);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the schedule file: " + e.getMessage());
        }
    }
}