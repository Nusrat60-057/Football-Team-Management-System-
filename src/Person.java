import java.time.LocalDate;

public abstract class Person {
    private int age;
    private String name;
    private LocalDate birthDate;
    private String nationality;

    // Default Constructor
    Person() {}

    // Parameterized Constructor
    Person(String name, int age, LocalDate birthDate, String nationality) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    // Getter and Setter for birthdate
    public LocalDate getBirthdate() {
        return birthDate;
    }

    public void setBirthdate(LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthdate cannot be in the future.");
        }
        this.birthDate = birthDate;
    }

    // Getter and Setter for birthdate
    public String getNationality(){
        return this.nationality;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    // Abstract method for subclasses to implement
    public abstract String toString();
}