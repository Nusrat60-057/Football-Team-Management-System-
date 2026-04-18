import java.util.ArrayList;

class Team<E extends Player> {

    private static final String homeTeam = "Brazil";
    private String teamName;
    private ArrayList<E> teamPlayer = new ArrayList<>();
    private ArrayList<Coach> teamCoach = new ArrayList<>();

    // DEFAULT CONSTRUCTOR
    Team() {
        this.teamName = homeTeam;
    }

    // GETTER FOR TEAM NAME
    public String getTeam() {
        return teamName;
    }

    // METHOD TO ADD A PLAYER TO TEAM
    public void addPlayerToTeam(E player) {
        teamPlayer.add(player);
        System.out.println(player.getName() + " added to team " + getTeam());
    }

    // METHOD TO ADD A PLAYER BY NAME
    public void addPlayer(String playerName, ArrayList<E> allPlayers) {
        E player = null;
        for (E p : allPlayers) {
            if (p.getName().equalsIgnoreCase(playerName)) {
                player = p;
                break;
            }
        }
        if (player != null) {
            addPlayerToTeam(player);
        } else {
            System.out.println("Player not found in the player list.");
        }
    }

    // METHOD TO REMOVE A PLAYER BY NAME
    public void removePlayerFromTeam(String name) {
        boolean found = false;
        for (int i = 0; i < teamPlayer.size(); i++) {
            if (teamPlayer.get(i).getName().equalsIgnoreCase(name)) {
                teamPlayer.remove(i);
                System.out.println("Player removed successfully...");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }
    }

    // METHOD TO DISPLAY ALL TEAM PLAYERS
    public void displayTeamPlayers() {
        System.out.println("Team: " + teamName);
        for (E player : teamPlayer) {
            System.out.println(player);
        }
    }

    // METHOD TO ASSIGN A COACH
    public void assignCoach(String name, String type, ArrayList<Coach> allCoaches) {
        Coach coach = null;
        for (Coach c : allCoaches) {
            if (c.getName().equalsIgnoreCase(name) && c.getCoachType().equalsIgnoreCase(type)) {
                coach = c;
                break;
            }
        }
        if (coach != null) {
            teamCoach.add(coach);
            System.out.println("Successfully assigned " + coach.getCoachType() + " coach for team " + getTeam());
        } else {
            System.out.println("Coach not found in the coach list.");
        }
    }

    // METHOD TO REMOVE A COACH BY NAME
    public void removeTeamCoach(String name) {
        boolean found = false;
        for (int i = 0; i < teamCoach.size(); i++) {
            if (teamCoach.get(i).getName().equalsIgnoreCase(name)) {
                teamCoach.remove(i);
                System.out.println("Coach removed successfully...");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }
    }
}

