import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Striker extends Player{
    private int finishing;
    private int positioning;
    private int shootingPower;
    private int dribbling;
    private int speed;
    private int heading;
    private static final ArrayList<Striker> strikers = new ArrayList<>();
    private static File strikerFile = new File("E:\\Coading Java\\Football Team Managment\\src\\strikers.txt");
    public Striker(){}
    public Striker(String name, int age, LocalDate birthDate, String nationality, int jerseyNumber, int goalScored,
                   int assist, int matchPlayed, int yellowCard, int redCard, String position, int finishing,
                   int positioning, int shootingPower, int dribbling, int speed, int heading){
        super(name, age, birthDate, nationality, jerseyNumber, goalScored, assist, matchPlayed,
                yellowCard, redCard, position);
        this.finishing = finishing;
        this.positioning = positioning;
        this.shootingPower = shootingPower;
        this.dribbling = dribbling;
        this.speed = speed;
        this.heading = heading;
    }

    public void setFinishing(int finishing) {
        this.finishing = finishing;
    }
    public int getFinishing() {
        return this.finishing;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }
    public int getPositioning() {
        return this.positioning;
    }

    public void setShootingPower(int shootingPower) {
        this.shootingPower = shootingPower;
    }
    public int getShootingPower() {
        return this.shootingPower;
    }

    public void setDribbling(int dribbling) {
        this.dribbling = dribbling;
    }
    public int getDribbling() {
        return this.dribbling;
    }

    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHeading() {
        return this.heading;
    }
    public void setHeading(int heading) {
        this.heading = heading;
    }

    @Override
    public void add(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter Midfilder name: ");
        String name = inp.nextLine();
        System.out.println("Enter Midfilder age: ");
        int age = inp.nextInt();
        inp.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter the Midfilder's Birth Date(yyyy-MM-dd): ");
            String birthDay = inp.nextLine();
            try {
                birthDate = LocalDate.parse(birthDay, dateTimeFormatter);
                validDate = true;
            } catch (DateTimeParseException d) {
                System.out.println("Invalid Date format, try again!");
            }
        }
        inp.nextLine();
        System.out.println("Enter the Midfilder Nationality: ");
        String nationality = inp.nextLine();
        System.out.println("Enter the Midfilder Jersey Number: ");
        int jerseyNumber = inp.nextInt();
        System.out.println("Enter the Midfilder goal scored: ");
        int goalScored = inp.nextInt();
        System.out.println("Enter the Midfilder Assist: ");
        int assist = inp.nextInt();
        System.out.println("Number of match the striker played: ");
        int matchPlayed = inp.nextInt();
        System.out.println("Yellow card number: ");
        int yellowCard = inp.nextInt();
        System.out.println("Red Card number: ");
        int redCard = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter the position: ");
        String position = inp.next();
        System.out.print("Finishing: ");
        int finishing = inp.nextInt();
        System.out.print("Positioning: ");
        int positioning = inp.nextInt();
        System.out.print("Shooting Power: ");
        int shootingPower = inp.nextInt();
        System.out.print("Dribbling: ");
        int dribbling = inp.nextInt();
        System.out.print("Speed: ");
        int speed = inp.nextInt();
        System.out.print("Heading: ");
        int heading = inp.nextInt();
        Striker s = new Striker(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                redCard,position,finishing,positioning,shootingPower,dribbling,speed,heading);
        strikers.add(s);
        addStrikerToFile();
        System.out.println("Player Added successfully.");
    }

    @Override
    public void remove(String name) {
        boolean found = false;
        for (int i = 0; i < strikers.size(); i++) {
            if (strikers.get(i).getName().equalsIgnoreCase(name)) {
                strikers.remove(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found!");
            return;
        }
        Striker.addStrikerToFile();
        System.out.println("Removed Successfully");
    }

    @Override
    public void displayDetails(String name){
        boolean found = false;
        for (Striker s: strikers)
            if (s.getName().equalsIgnoreCase(name)){
                System.out.println(s.toString());
                found = true;
                break;
            }
        if (!found)
            System.out.println("Not found!");
    }

    public static void addStrikerToFile(){
        try (FileWriter fw = new FileWriter(strikerFile)){
            for (Striker s : strikers){
                fw.write(s.getName()+","+ s.getAge()+","+s.getBirthdate()+","+s.getNationality()+","+s.getJerseyNumber()
                +','+s.getGoalScored()+","+s.getAssist()+","+s.getMatchPlayed()+","+s.getYellowCard()+","+s.getRedCard()+","+s.getPosition()+","
                +s.getFinishing()+","+ s.getPositioning()+","+ s.getShootingPower()+","+ s.getDribbling()+","+ s.getSpeed()
                +","+s.getHeading()+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadStrikerFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(strikerFile))){
            String line;
            strikers.clear();
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
                int finishing = Integer.parseInt(data[11]);
                int positioning = Integer.parseInt(data[12]);
                int shootingPower = Integer.parseInt(data[13]);
                int dribbling = Integer.parseInt(data[14]);
                int speed = Integer.parseInt(data[15]);
                int heading = Integer.parseInt(data[16]);
                Striker s = new Striker(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                        redCard,position,finishing,positioning,shootingPower,dribbling,speed,heading);
                strikers.add(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void displayAllStrikersDetails(){
        try (BufferedReader br = new BufferedReader(new FileReader(strikerFile))){
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
                int finishing = Integer.parseInt(data[11]);
                int positioning = Integer.parseInt(data[12]);
                int shootingPower = Integer.parseInt(data[13]);
                int dribbling = Integer.parseInt(data[14]);
                int speed = Integer.parseInt(data[15]);
                int heading = Integer.parseInt(data[16]);
                System.out.println("Striker's name: " + name);
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
                System.out.println("Finishing: " + finishing);
                System.out.println("Positioning: " + positioning);
                System.out.println("Shooting Power: " + shootingPower);
                System.out.println("Dribbling: " + dribbling);
                System.out.println("Speed: " + speed);
                System.out.println("Heading: " + heading);
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExist(String name){
        for (Striker s : strikers)
            if (s.getName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    public static ArrayList<Striker> getStrikers(){
        return strikers;
    }
    public String toString(){
        return  "Name: " + this.getName() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Birth Date: " + this.getBirthdate() + "\n" +
                "Nationality: " + this.getNationality() + "\n" +
                "Jersey Number: " + this.getJerseyNumber() + "\n" +
                "Goal Scored: " + this.getGoalScored() + "\n" +
                "Assist: " + this.getAssist() + "\n" +
                "Match Played: " + this.getMatchPlayed() + "\n" +
                "Yellow Card: " + this.getYellowCard() + "\n" +
                "Red Card: " + this.getRedCard() + "\n" +
                "Position: " + this.getPosition() + "\n" +
                "Finishing: " + this.getFinishing() + "\n" +
                "Positioning: " + this.getPositioning() + "\n" +
                "Shooting Power: " + this.getShootingPower() + "\n" +
                "Dribbling: " + this.getDribbling() + "\n" +
                "Speed: " + this.getSpeed() + "\n" +
                "Heading: " + this.getHeading() + "\n";
    }
}
