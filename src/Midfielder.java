import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Midfielder extends Player {
    private int passingAccuracy;
    private int vision;
    private int stamina;
    private int ballControl;
    private int tackling;
    private int creativity;
    private static final ArrayList<Midfielder> midfielders  = new ArrayList<>();
    public static File midfielderFile = new File("E:\\Coading Java\\Football Team Managment\\src\\midfielders.txt");
    public Midfielder(){}
    public Midfielder(String name, int age, LocalDate birthDate, String nationality, int jerseyNumber, int goalScored,
                      int assist, int matchPlayed, int yellowCard, int redCard, String position, int passingAccuracy,
                      int vision, int stamina, int ballControl, int tackling, int creativity){
        super(name, age, birthDate, nationality, jerseyNumber, goalScored, assist, matchPlayed,
                yellowCard, redCard, position);
        this.passingAccuracy = passingAccuracy;
        this.vision = vision;
        this.stamina = stamina;
        this.ballControl = ballControl;
        this.tackling = tackling;
        this.creativity = creativity;
    }

    public void setPassingAccuracy(int passingAccuracy) {
        this.passingAccuracy = passingAccuracy;
    }
    public int getPassingAccuracy() {
        return this.passingAccuracy;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }
    public int getVision() {
        return this.vision;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public int getStamina() {
        return this.stamina;
    }

    public void setBallControl(int ballControl) {
        this.ballControl = ballControl;
    }
    public int getBallControl() {
        return this.ballControl;
    }

    public int getTackling() {
        return this.tackling;
    }
    public void setTackling(int tackling) {
        this.tackling = tackling;
    }

    public int getCreativity() {
        return this.creativity;
    }
    public void setCreativity(int creativity) {
        this.creativity = creativity;
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
        System.out.print("Passing Accuracy: ");
        int passingAccuracy = inp.nextInt();
        System.out.print("Vision: ");
        int vision = inp.nextInt();
        System.out.print("Stamina: ");
        int stamina = inp.nextInt();
        System.out.print("Ball Control: ");
        int ballControl = inp.nextInt();
        System.out.print("Tackling: ");
        int tackling = inp.nextInt();
        System.out.print("Creativity: ");
        int creativity = inp.nextInt();
        Midfielder m = new Midfielder(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                redCard,position, passingAccuracy, vision, stamina, ballControl, tackling, creativity);
        midfielders.add(m);
       addMidfielderToFile();
        System.out.println("Player Added successfully.");
    }
    @Override
    public void remove(String name) {
        boolean found = false;
        for (int i = 0; i < midfielders.size(); i++) {
            if (midfielders.get(i).getName().equalsIgnoreCase(name)) {
                midfielders.remove(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found!");
            return;
        }
        Midfielder.addMidfielderToFile();
        System.out.println("Removed Successfully");
    }


    @Override
    public void displayDetails(String name){
        boolean found = false;
        for (Midfielder m : midfielders)
            if (m.getName().equalsIgnoreCase(name)){
                System.out.println(m.toString());
                found = true;
                break;
            }
        if (!found)
            System.out.println("Not found!");
    }

    public static void addMidfielderToFile(){
        try (FileWriter fw = new FileWriter(midfielderFile)){
            for (Midfielder m : midfielders){
                fw.write(m.getName()+","+ m.getAge()+","+m.getBirthdate()+","+m.getNationality()+","+m.getJerseyNumber()
                        +','+m.getGoalScored()+","+m.getAssist()+","+m.getMatchPlayed()+","+m.getYellowCard()+","+m.getRedCard()+","+m.getPosition()+","
                        +m.getPassingAccuracy()+","+ m.getVision()+","+ m.getStamina()+","+ m.getBallControl()+","+ m.getTackling()
                        +","+m.getCreativity()+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadMidfieldersFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(midfielderFile))){
            String line;
            midfielders.clear();
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
                int passingAccuracy = Integer.parseInt(data[11]);
                int vision = Integer.parseInt(data[12]);
                int stamina = Integer.parseInt(data[13]);
                int ballControl = Integer.parseInt(data[14]);
                int tackling = Integer.parseInt(data[15]);
                int creativity = Integer.parseInt(data[16]);
                Midfielder m = new Midfielder(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                        redCard,position, passingAccuracy, vision, stamina, ballControl, tackling, creativity);
                midfielders.add(m);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void displayAllMidfieldersDetails(){
        try (BufferedReader br = new BufferedReader(new FileReader(midfielderFile))){
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
                int passingAccuracy = Integer.parseInt(data[11]);
                int vision = Integer.parseInt(data[12]);
                int stamina = Integer.parseInt(data[13]);
                int ballControl = Integer.parseInt(data[14]);
                int tackling = Integer.parseInt(data[15]);
                int creativity = Integer.parseInt(data[16]);
                System.out.println("Midfielders name: " + name);
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
                System.out.println("Passing Accuracy: " + passingAccuracy);
                System.out.println("Vision: " + vision);
                System.out.println("Stamina: " + stamina);
                System.out.println("Ball Control: " + ballControl);
                System.out.println("Tackling: " + tackling);
                System.out.println("Creativity: " + creativity);
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExist(String name){
        for (Midfielder m : midfielders)
            if (m.getName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    public static ArrayList<Midfielder> getMidfielders(){
        return midfielders;
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
                "Passing Accuracy: " + this.getPassingAccuracy() + "\n" +
                "Vision: " + this.getVision() + "\n" +
                "Stamina: " + this.getStamina() + "\n" +
                "Ball Control: " + this.getBallControl() + "\n" +
                "Tackling: " + this.getTackling() + "\n" +
                "Creativity: " + this.getCreativity() + "\n";
    }
}
