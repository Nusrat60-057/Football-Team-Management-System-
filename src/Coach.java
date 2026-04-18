import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Coach extends Person {
    private String type;
    private int experience;
    private static ArrayList<Coach> coachList = new ArrayList<>();
    public static File coachFile = new File("E:\\Coading Java\\Football Team Managment\\src\\coach.txt");

    public Coach() {}
    public Coach(String name, int age, LocalDate birthDay, String nationality, String type, int experience) {
        super(name, age, birthDay, nationality);
        this.type = type;
        this.experience = experience;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }
    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setBirthdate(LocalDate birthdate) {
        super.setBirthdate(birthdate);
    }
    @Override
    public LocalDate getBirthdate() {
        return super.getBirthdate();
    }

    @Override
    public void setNationality(String nationality) {
        super.setNationality(nationality);
    }
    @Override
    public String getNationality() {
        return super.getNationality();
    }


    public void setCoachType(String type) {
        this.type = type;
    }
    public String getCoachType() {
        return this.type;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return this.experience;
    }

    public void addCoach() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter Coach name: ");
        String name = inp.nextLine();
        System.out.println("Enter coach age: ");
        int age = inp.nextInt();
        inp.nextLine();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        LocalDate birthDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter the Coach's Birth Date(yy-MM-dd): ");
            String birthDay = inp.nextLine();
            try {
                birthDate = LocalDate.parse(birthDay, dateTimeFormatter);
                validDate = true;
            } catch (DateTimeParseException d) {
                System.out.println("Invalid Date format, try again!");
            }
        }
        inp.nextLine();
        System.out.println("Enter the Coach's Nationality: ");
        String nationality = inp.nextLine();
        System.out.print("Enter the coach type: ");
        String ty = inp.nextLine();
        System.out.print("Enter the coach experience(in years): ");
        int ex = inp.nextInt();

        Coach coach = new Coach(name, age, birthDate, nationality, ty, ex);
        coachList.add(coach);
        addCoachToFile();
        System.out.println("coach added Successfully");
    }

    public void removeCoach(String name){
        boolean found = false;
        for (Coach coach : coachList)
            if (coach.getName().equalsIgnoreCase(name)) {
                coachList.remove(coach);
                found = true;
            }
        if (!found){
            System.out.println("coach not found");
            return;
        }
        addCoachToFile();
        System.out.println("Coach remove successfully");
    }

    public static void addCoachToFile() {
        try (FileWriter fw = new FileWriter(coachFile)){
            for (Coach coach : coachList){
                fw.write(coach.getName()+","+coach.getAge()+","+coach.getBirthdate()+
                        ","+coach.getNationality()+"," +coach.getCoachType()+","+coach.getExperience()+"\n");
            }
        } catch (IOException io){
            io.printStackTrace();
        }
    }

    public void displayCoachDetails(String name){
        boolean found = false;
        for (Coach coach : coachList)
            if(coach.getName().equalsIgnoreCase(name)){
                found = true;
                System.out.println(coach.toString());
                break;
            }
        if (!found)
            System.out.println("This Coach is not available");
    }

    public static void displayAllCoachDetails(){
        try (BufferedReader br = new BufferedReader(new FileReader(coachFile))){
            String line;
            while ((line = br.readLine()) != null){
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                String nationality = data[3];
                String type = data[4];
                int experience = Integer.parseInt(data[5]);
                System.out.println("Coach's name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Birth date: " + birthDate);
                System.out.println("Nationality: " + nationality);
                System.out.println("Type: " + type);
                System.out.println("Experience: " + experience + " years");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadCoachFromFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(coachFile))){
            String line;
            coachList.clear();
            while ((line = br.readLine()) != null){
                String data[] = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                LocalDate birthDate = LocalDate.parse(data[2]);
                String nationality = data[3];
                String type = data[4];
                int experience = Integer.parseInt(data[5]);
                coachList.add(new Coach(name, age, birthDate, nationality, type, experience));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Coach> getCoachList(){
        return coachList;
    }

    @Override
    public String toString() {
        String string = "Name: " + this.getName() + "\n" +
                "Age: " + this.getAge() + "\n" +
                "Birth Date: " + this.getBirthdate() + "\n" +
                "Nationality: " + this.getNationality() + "\n" +
                "Coach Type: " + this.getCoachType() + "\n" +
                "Experience: " + this.getExperience() + "Years" + "\n";
        return string;
    }
}
