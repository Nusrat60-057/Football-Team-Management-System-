import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Defender extends Player {
    private int tackling;
    private int marking;
    private int strength;
    private int arialAbility;
    private int positioning;
    private int communication;
    private static final ArrayList<Defender> defenders  = new ArrayList<>();
    public static File defenderFile = new File("E:\\Coading Java\\Football Team Managment\\src\\defenders.txt");

    public Defender(){}
    public Defender(String name, int age, LocalDate birthDate, String nationality, int jerseyNumber, int goalScored,
                    int assist, int matchPlayed, int yellowCard, int redCard, String position, int tackling,
                    int marking, int strength, int arialAbility, int positioning, int communication){
        super(name, age, birthDate, nationality, jerseyNumber, goalScored, assist, matchPlayed,
                yellowCard, redCard, position);
        this.tackling = tackling;
        this.marking = marking;
        this.strength = strength;
        this.arialAbility = arialAbility;
        this.positioning = positioning;
        this.communication = communication;
    }

    public void setTackling(int tackling) {
        this.tackling = tackling;
    }
    public int getTackling() {
        return this.tackling;
    }

    public void setMarking(int marking) {
        this.marking = marking;
    }
    public int getMarking() {
        return this.marking;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getStrength() {
        return this.strength;
    }

    public void setArialAbility(int arialAbility){
        this.arialAbility = arialAbility;
    }
    public int getArialAbility(){
        return this.arialAbility;
    }

    public void setPositioning(int positioning){
        this.positioning = positioning;
    }
    public int getPositioning(){
        return this.positioning;
    }

    public int getCommunication() {
        return this.communication;
    }
    public void setCommunication(int communication) {
        this.communication = communication;
    }

    @Override
    public void add(){
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter Defender's name: ");
        String name = inp.nextLine();
        System.out.println("Enter Defender's age: ");
        int age = inp.nextInt();
        inp.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter the Defender's Birth Date(yy-MM-dd): ");
            String birthDay = inp.nextLine();
            try {
                birthDate = LocalDate.parse(birthDay, dateTimeFormatter);
                validDate = true;
            } catch (DateTimeParseException d) {
                System.out.println("Invalid Date format, try again!");
            }
        }
        inp.nextLine();
        System.out.println("Enter the Defender's Nationality: ");
        String nationality = inp.nextLine();
        System.out.println("Enter the Defender's Jersey Number: ");
        int jerseyNumber = inp.nextInt();
        System.out.println("Enter the Defender's goal scored: ");
        int goalScored = inp.nextInt();
        System.out.println("Enter the Defender's Assist: ");
        int assist = inp.nextInt();
        System.out.println("Number of match the Defender played: ");
        int matchPlayed = inp.nextInt();
        System.out.println("Yellow card number: ");
        int yellowCard = inp.nextInt();
        System.out.println("Red Card number: ");
        int redCard = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter the position: ");
        String position = inp.next();
        System.out.print("Tackling: ");
        int tackling = inp.nextInt();
        System.out.print("Marking: ");
        int marking = inp.nextInt();
        System.out.print("Strength: ");
        int strength = inp.nextInt();
        System.out.print("Arial Ability: ");
        int arialAbility = inp.nextInt();
        System.out.print("Positioning: ");
        int positioning = inp.nextInt();
        System.out.print("Communication: ");
        int communication = inp.nextInt();
        Defender d = new Defender(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                redCard,position, tackling, marking, strength, arialAbility, positioning, communication);
        defenders.add(d);
        addDefenderToFile();
        System.out.println("Player Added successfully.");
    }

    @Override
    public void remove(String name) {
        boolean found = false;
        for (int i = 0; i < defenders.size(); i++) {
            if (defenders.get(i).getName().equalsIgnoreCase(name)) {
                defenders.remove(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not found!");
            return;
        }
        Defender.addDefenderToFile();
        System.out.println("Removed Successfully");
    }

    @Override
    public void displayDetails(String name){
        boolean found = false;
        for (Defender d : defenders)
            if (d.getName().equalsIgnoreCase(name)){
                System.out.println(d.toString());
                found = true;
                break;
            }
        if (!found)
            System.out.println("Not found!");
    }

    public static void addDefenderToFile(){
        try (FileWriter fw = new FileWriter(defenderFile)){
            for (Defender d : defenders){
                fw.write(d.getName()+","+ d.getAge()+","+d.getBirthdate()+","+d.getNationality()+","+d.getJerseyNumber()
                        +','+d.getGoalScored()+","+d.getAssist()+","+d.getMatchPlayed()+","+d.getYellowCard()+","+d.getRedCard()+","+d.getPosition()+","
                        +d.getTackling()+","+ d.getMarking()+","+ d.getStrength()+","+ d.getArialAbility()+","+ d.getTackling()
                        +","+d.getCommunication()+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadDefenderFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(defenderFile))){
            String line;
            defenders.clear();
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
                int tackling = Integer.parseInt(data[11]);
                int marking = Integer.parseInt(data[12]);
                int strength = Integer.parseInt(data[13]);
                int arialAbility = Integer.parseInt(data[14]);
                int positioning = Integer.parseInt(data[15]);
                int communication = Integer.parseInt(data[16]);
                Defender d = new Defender(name,age,birthDate,nationality,jerseyNumber,goalScored,assist,matchPlayed,yellowCard,
                        redCard,position, tackling, marking, strength, arialAbility, positioning, communication);
                defenders.add(d);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void displayAllDefendersDetails(){
        try (BufferedReader br = new BufferedReader(new FileReader(defenderFile))){
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
                int tackling = Integer.parseInt(data[11]);
                int marking = Integer.parseInt(data[12]);
                int strength = Integer.parseInt(data[13]);
                int arialAbility = Integer.parseInt(data[14]);
                int positioning = Integer.parseInt(data[15]);
                int communication = Integer.parseInt(data[16]);
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
                System.out.println("Tackling: " + tackling);
                System.out.println("Marking: " + marking);
                System.out.println("Strength: " + strength);
                System.out.println("Arial Ability: " + arialAbility);
                System.out.println("Positioning: " + positioning);
                System.out.println("Communication: " + communication);
                System.out.println("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean isExist(String name){
        for (Defender d : defenders)
            if (d.getName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    public static ArrayList<Defender> getDefenders(){
        return defenders;
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
                "Tackling: " + this.getTackling() + "\n" +
                "Marking: " + this.getMarking() + "\n" +
                "Strength: " + this.getStrength() + "\n" +
                "Arial Ability: " + this.getArialAbility() + "\n" +
                "Positioning: " + this.getPositioning() + "\n" +
                "Communication: " + this.getCommunication() + "\n";
    }
}
