import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Goalkeeper extends Player{
    private int shotStopping;
    private int positioning;
    private int distribution;
    private int handling;
    private int diving;
    private int commandOfArea;
    private static final ArrayList<Goalkeeper> goalkeepers = new ArrayList<>();
    public static File goalkeeperFile = new File("E:\\Coading Java\\Football Team Managment\\src\\goalkeepers.txt");
    public Goalkeeper(){}
    public Goalkeeper(String name, int age, LocalDate birthDate, String nationality, int jerseyNumber, int goalScored,
                      int assist, int matchPlayed, int yellowCard, int redCard, String position, int shotStopping,
                      int positioning, int distribution, int handling, int diving, int commandOfArea){
        super(name, age, birthDate, nationality, jerseyNumber, goalScored, assist, matchPlayed,
                yellowCard, redCard, position);
        this.shotStopping = shotStopping;
        this.positioning = positioning;
        this.distribution = distribution;
        this.handling = handling;
        this.diving = diving;
        this.commandOfArea = commandOfArea;
    }

    public void setShotStopping(int shotStopping) {
        this.shotStopping = shotStopping;
    }
    public int getShotStopping() {
        return this.shotStopping;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }
    public int getPositioning() {
        return this.positioning;
    }

    public void setDistribution(int distribution) {
        this.distribution = distribution;
    }
    public int getDistribution() {
        return this.distribution;
    }

    public void setHandling(int handling){
        this.handling = handling;
    }
    public int getHandling(){
        return this.handling;
    }

    public void setDiving(int diving){
        this.diving = diving;
    }
    public int getDiving(){
        return this.diving;
    }

    public int getCommandOfArea() {
        return this.commandOfArea;
    }
    public void setCommandOfArea(int commandOfArea) {
        this.commandOfArea = commandOfArea;
    }

    @Override
    public void add(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter Goalkeeper name: ");
        String name = inp.nextLine();
        System.out.println("Enter Goalkeeper age: ");
        int age = inp.nextInt();
        inp.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter the Goalkeeper's Birth Date(yy-MM-dd): ");
            String birthDay = inp.nextLine();
            try {
                birthDate = LocalDate.parse(birthDay, dateTimeFormatter);
                validDate = true;
            } catch (DateTimeParseException d) {
                System.out.println("Invalid Date format, try again!");
            }
        }
        inp.nextLine();
        System.out.println("Enter the Goalkeeper Nationality: ");
        String nationality = inp.nextLine();
        System.out.println("Enter the Goalkeeper Jersey Number: ");
        int jerseyNumber = inp.nextInt();
        System.out.println("Enter the Goalkeeper goal scored: ");
        int goalScored = inp.nextInt();
        System.out.println("Enter the Goalkeeper Assist: ");
        int assist = inp.nextInt();
        System.out.println("Number of match the Goalkeeper played: ");
        int matchPlayed = inp.nextInt();
        System.out.println("Yellow card number: ");
        int yellowCard = inp.nextInt();
        System.out.println("Red Card number: ");
        int redCard = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter the position: ");
        String position = inp.next();
        System.out.print("Shot Stopping: ");
        int shotStopping = inp.nextInt();
        System.out.print("Positioning: ");
        int positioning = inp.nextInt();
        System.out.print("Distribution: ");
        int distribution = inp.nextInt();
        System.out.print("Handling: ");
        int handling = inp.nextInt();
        System.out.print("Diving: ");
        int diving = inp.nextInt();
        System.out.print("command Of Area: ");
        int commandOfArea = inp.nextInt();
        Goalkeeper g = new Goalkeeper(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                redCard,position, shotStopping, positioning, distribution, handling, diving, commandOfArea);
        goalkeepers.add(g);
        addGoalkeeperToFile();
        System.out.println("Player Added successfully.");
    }

    @Override
    public void remove(String name) {
        boolean found = false;
        for (int i = 0; i < goalkeepers.size(); i++) {
            if (goalkeepers.get(i).getName().equalsIgnoreCase(name)) {
                 goalkeepers.remove(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found!");
            return;
        }
        Goalkeeper.addGoalkeeperToFile();
        System.out.println("Removed Successfully");
    }


    @Override
    public void displayDetails(String name){
        boolean found = false;
        for (Goalkeeper g : goalkeepers)
            if (g.getName().equalsIgnoreCase(name)){
                System.out.println(g.toString());
                found = true;
                break;
            }
        if (!found)
            System.out.println("Not found!");
    }

    public static void addGoalkeeperToFile(){
        try (FileWriter fw = new FileWriter(goalkeeperFile)){
            for (Goalkeeper g : goalkeepers){
                fw.write(g.getName()+","+ g.getAge()+","+g.getBirthdate()+","+g.getNationality()+","+g.getJerseyNumber()
                        +','+g.getGoalScored()+","+g.getAssist()+","+g.getMatchPlayed()+","+g.getYellowCard()+","+g.getRedCard()+","+g.getPosition()+","
                        +g.getShotStopping()+","+ g.getPositioning()+","+ g.getDistribution()+","+ g.getHandling()+","+ g.getDiving()
                        +","+g.getCommandOfArea()+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadGoalkeeperFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(goalkeeperFile))){
            String line;
            goalkeepers.clear();
            while ((line = br.readLine()) != null){
                String data[] = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                String nationality = data[3];
                int jerseyNumber = Integer.parseInt(data[4]);
                int goalScored = Integer.parseInt(data[5]);
                int assist = Integer.parseInt(data[6]);
                int matchPlayed = Integer.parseInt(data[7]);
                int yellowCard = Integer.parseInt(data[8]);
                int redCard = Integer.parseInt(data[9]);
                String position = data[10];
                int shotStopping = Integer.parseInt(data[11]);
                int positioning = Integer.parseInt(data[12]);
                int distribution = Integer.parseInt(data[13]);
                int handling = Integer.parseInt(data[14]);
                int diving = Integer.parseInt(data[15]);
                int commandOfArea = Integer.parseInt(data[16]);
                Goalkeeper g = new Goalkeeper(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                        redCard,position, shotStopping, positioning, distribution, handling, diving, commandOfArea);
                goalkeepers.add(g);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void displayAllGoalkeepersDetails(){
        try (BufferedReader br = new BufferedReader(new FileReader(goalkeeperFile))){
            String line;
            while ((line = br.readLine()) != null){
                String data[] = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                String nationality = data[3];
                int jerseyNumber = Integer.parseInt(data[4]);
                int goalScored = Integer.parseInt(data[5]);
                int assist = Integer.parseInt(data[6]);
                int matchPlayed = Integer.parseInt(data[7]);
                int yellowCard = Integer.parseInt(data[8]);
                int redCard = Integer.parseInt(data[9]);
                String position = data[10];
                int shotStopping = Integer.parseInt(data[11]);
                int positioning = Integer.parseInt(data[12]);
                int distribution = Integer.parseInt(data[13]);
                int handling = Integer.parseInt(data[14]);
                int diving = Integer.parseInt(data[15]);
                int commandOfArea = Integer.parseInt(data[16]);
                System.out.println("Goalkeeper's name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Birth Date: " + birthDate);
                System.out.println("nationality: " + nationality);
                System.out.println("jersey Number: " + jerseyNumber);
                System.out.println("Goal Scored: " + goalScored);
                System.out.println("Assist: " + assist);
                System.out.println("Match Played: " + matchPlayed);
                System.out.println("Yellow Card: " + yellowCard);
                System.out.println("Red Card: " + redCard);
                System.out.println("Position: " + position);
                System.out.println("Shot Stopping: " + shotStopping);
                System.out.println("Positioning: " + positioning);
                System.out.println("Distribution: " + distribution);
                System.out.println("Handling: " + handling);
                System.out.println("Diving: " + diving);
                System.out.println("Command of Area: " + commandOfArea);
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExist(String name){
        for (Goalkeeper g : goalkeepers)
            if (g.getName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    public static ArrayList<Goalkeeper> getGoalkeepers(){
        return goalkeepers;
    }

    public String toString(){
        return  "Name: " + this.getName() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Birth Date: " + this.getBirthdate() + "\n" +
                "Nationality: " + this.getNationality() + "\n" +
                "Jersey Number: " + this.getJerseyNumber() + "\n" +
                "Goal Scored: " + this.getGoalScored() + "\n" +
                "Assist: " + this.getAssist() + "\n" +
                "Match Played: " + this.getMatchPlayed() +
                "Yellow Card: " + this.getYellowCard() + "\n" +
                "Red Card: " + this.getRedCard() + "\n" +
                "Position: " + this.getPosition() + "\n" +
                "Shot Stopping: " + this.getShotStopping() + "\n" +
                "Positioning: " + this.getPositioning() + "\n" +
                "Distribution: " + this.getDistribution() + "\n" +
                "Handling: " + this.getHandling() + "\n" +
                "Diving: " + this.getDiving() + "\n" +
                "Command Of Area: " + this.getCommandOfArea() + "\n";
    }
}
