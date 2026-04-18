import java.io.*;
import java.util.*;

public class LoginPanel {
    private String userName;
    private String password;
    private String role;
    private static final List<LoginPanel> users = LoginPanel.loadUsersFromFile("E:\\Coading Java\\Football Team Managment\\src\\users.txt");

    public LoginPanel(String userName, String password, String role){
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public static boolean login(Scanner input, String role) {
        input.nextLine();
        System.out.print("Enter Username: ");
        String enteredUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String enteredPassword = input.nextLine();

        for (LoginPanel user : users) {
            if (user.getRole().equals(role) && user.getUserName().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                return true;
            }
        }
        return false;
    }

    public static List<LoginPanel> loadUsersFromFile(String filename) {
        List<LoginPanel> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    String username = details[0].trim();
                    String password = details[1].trim();
                    String role = details[2].trim();
                    users.add(new LoginPanel(username, password, role));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file: " + e.getMessage());
        }
        return users;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}