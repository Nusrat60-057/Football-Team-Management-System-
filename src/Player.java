import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Player extends Person {
    private int goalScored, jerseyNumber, assist, matchPlayed, yellowCard, redCard;
    private String position;
    private static ArrayList<Player> playerList = new ArrayList<>();

    public Player(){}
    public Player(String name, int age, LocalDate birthDate, String nationality, int jerseyNumber, int goalScored,
                  int assist, int matchPlayed, int yellowCard, int redCard, String position){
        super(name, age, birthDate, nationality);
        if (age < 0)
            throw new IllegalArgumentException("Age can't be less than zero!");
        if (goalScored < 0)
            throw new IllegalArgumentException("Goal scored can't be less than zero!");
        if (assist < 0)
            throw new IllegalArgumentException("Assist can't be less than zero");
        if (matchPlayed < 0)
            throw new IllegalArgumentException("Match number can't be less than zero");
        if (yellowCard < 0)
            throw new IllegalArgumentException("Number of yellow card can't be less than zero");
        if (redCard < 0)
            throw new IllegalArgumentException("Number of red card can't be less than zero");
        this.jerseyNumber = jerseyNumber;
        this.goalScored = goalScored;
        this.assist = assist;
        this.matchPlayed = matchPlayed;
        this.yellowCard = yellowCard;
        this.redCard = redCard;
        this.position = position;
    }

    public Player(String name, int age, LocalDate birthDate, String nationality, int jerseyNumber, int goalScored,
                  int goalScored1, int assist, int matchPlayed, int yellowCard, int redCard, String position) {
        super(name, age, birthDate, nationality);
        this.jerseyNumber = jerseyNumber;

    }

    public void setJerseyNumber(int jerseyNumber){
        this.jerseyNumber = jerseyNumber;
    }
    public int getJerseyNumber(){
        return this.jerseyNumber;
    }

//    Setter and getter for goal score
    public void setGoalScored(int goalScored){
        this.goalScored = goalScored;
    }
    public int getGoalScored(){
        return this.goalScored;
    }

//    Setter and getter for assist
    public void setAssist(int assist){
        this.assist = assist;
    }
    public int getAssist(){
        return this.assist;
    }

//    Setter and getter for match played
    public void setMatchPlayed(int matchPlayed){
        this.matchPlayed = matchPlayed;
    }
    public int getMatchPlayed(){
        return this.matchPlayed;
    }

//    Setter and getter for yellow card
    public void setYellowCard(int yellowCard){
        this.yellowCard = yellowCard;
    }
    public int getYellowCard(){
        return this.yellowCard;
    }

//    Setter and getter for red card
    public void setRedCard(int redCard){
        this.redCard = redCard;
    }
    public int getRedCard(){
        return this.redCard;
    }

    public void setPosition(String position){
        this.position = position;
    }
    public String getPosition(){
        return this.position;
    }
    public abstract void add();
    public abstract void remove(String name);
    public abstract boolean isExist(String name);
    public abstract void displayDetails(String name);
}
