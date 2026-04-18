# Football Team Management System

A comprehensive console-based Java application for managing a football team, including players, coaches, match schedules, and administrative functions.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Installation & Setup](#installation--setup)
- [Usage](#usage)
  - [Player Role](#player-role)
  - [Coach Role](#coach-role)
  - [Admin Role](#admin-role)
- [Data Files](#data-files)
- [Classes & Architecture](#classes--architecture)
- [Key Features](#key-features)
- [File Format](#file-format)

## 📖 Overview

The Football Team Management System is designed to streamline the management of a football team (Brazil). It provides different user roles with specific functionalities:

- **Players** can view their details and team information
- **Coaches** can manage players, team composition, and match schedules
- **Administrators** have full control over the system

## ✨ Features

### Player Management
- Display individual player details
- View all players by position (Strikers, Midfielders, Defenders, Goalkeepers)
- Track player statistics (goals scored, assists, matches played, yellow/red cards)
- Filter players by position or name

### Coach Management
- Coach profile and experience tracking
- Coach type specification (Head Coach, Assistant Coach, etc.)

### Team Management
- Add/remove players from the team
- View complete team roster
- Organize players by their positions
- Team composition management

### Match Scheduling
- Create and manage match schedules
- View upcoming matches
- Track match dates and opponents
- Date-based filtering

### Authentication & Authorization
- Secure login system for Coach and Admin roles
- Role-based access control
- User credentials stored securely

## 📁 Project Structure

```
Football Management System/
├── src/
│   ├── Main.java                 # Application entry point
│   ├── Menu.java                 # Main menu and navigation
│   ├── LoginPanel.java           # Authentication system
│   ├── Player.java               # Abstract player class
│   ├── Striker.java              # Striker player type
│   ├── Midfielder.java           # Midfielder player type
│   ├── Defender.java             # Defender player type
│   ├── Goalkeeper.java           # Goalkeeper player type
│   ├── Coach.java                # Coach management
│   ├── Team.java                 # Team management (Generic)
│   ├── AllPlayerList.java        # Generic player list collection
│   ├── MatchSchedule.java        # Match scheduling
│   ├── Person.java               # Base person class
│   └── [.txt files]              # Data storage files
├── Documentation/
│   ├── Project Report [Football Team Management System].pdf
│   └── Football Management System.pptx
└── README.md                     # This file

```

## 🔧 Requirements

- **Java Version**: Java 8 or higher
- **IDE**: Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java extensions, etc.)
- **Operating System**: Windows, macOS, or Linux

## 📥 Installation & Setup

1. **Clone/Download the Project**
   ```bash
   # Extract the project to your desired location
   cd "Football Management System"
   ```

2. **Compile the Project**
   ```bash
   javac src/*.java
   ```

3. **Run the Application**
   ```bash
   java -cp src Main
   ```

### Initial Setup Notes
- The application loads player and coach data from text files on startup
- Ensure all `.txt` data files are present in the `src/` directory
- Default credentials are loaded from `users.txt` file

## 🎮 Usage

### Main Menu
When you start the application, you'll see a welcome screen with three roles:

```
1. Player
2. Coach
3. Admin
Enter 0 to Exit System
```

### Player Role
Players can:
- Display their own player details
- View all players in the team
- View players by position (Strikers, Midfielders, Defenders, Goalkeepers)
- Check match schedules
- Browse team information

**Available Options:**
1. Display specific player details
2. View all player details
3. Display striker information
4. View all strikers
5. Display midfielder information
6. View all midfielders
7. Display defender information
8. View all defenders
9. Display goalkeeper information
10. View all goalkeepers
11. View match schedule

### Coach Role
Coaches must authenticate with their credentials before accessing:
- All player management features
- Team composition (add/remove players)
- Match schedule management
- Team roster organization
- Player statistics and performance tracking

**Login Required:** Username and password authentication

### Admin Role
Administrators must authenticate before accessing:
- Complete system management
- User account management
- Full access to all coach features
- System configuration
- Data management

**Login Required:** Username and password authentication

## 💾 Data Files

The system uses text files to persist data:

| File | Purpose |
|------|---------|
| `users.txt` | User credentials (username, password, role) |
| `strikers.txt` | Striker player data |
| `midfielders.txt` | Midfielder player data |
| `defenders.txt` | Defender player data |
| `goalkeepers.txt` | Goalkeeper player data |
| `coach.txt` | Coach information |
| `schedule.txt` | Match schedule data |

### File Format
Each player file contains comma-separated values with the following structure:
```
Name,Age,BirthDate,Nationality,JerseyNumber,GoalsScored,Assists,MatchesPlayed,YellowCards,RedCards
```

User credentials file format:
```
Username,Password,Role
```

## 🏗️ Classes & Architecture

### Core Classes

**Person** (Abstract)
- Base class for all people in the system
- Properties: name, age, birthDate, nationality

**Player** (Abstract extends Person)
- Base class for all players
- Properties: goalScored, jerseyNumber, assist, matchPlayed, yellowCard, redCard, position
- Validation for non-negative values

**Position-Specific Players**
- `Striker`: Extends Player
- `Midfielder`: Extends Player
- `Defender`: Extends Player
- `Goalkeeper`: Extends Player

**Coach** (extends Person)
- Properties: type, experience
- File persistence methods

**Team** (Generic)
- Generic class for team management
- Methods: addPlayerToTeam(), removePlayerFromTeam(), addPlayer()
- Properties: teamName, teamPlayer list, teamCoach list
- Default team name: "Brazil"

**AllPlayerList** (Generic)
- Generic ArrayList wrapper for player management
- Extends ArrayList<E> where E extends Player

**MatchSchedule**
- Manages match scheduling and information

**LoginPanel**
- Handles user authentication
- Loads and validates credentials from users.txt

**Menu**
- Central navigation and menu system
- Implements playerMenu(), coachMenu(), adminMenu()

## 🔑 Key Features

### Input Validation
- Age validation (must be non-negative)
- Statistics validation (goals, assists, cards must be non-negative)
- Exception handling for invalid inputs

### Data Persistence
- Automatic loading of player data on startup
- Ability to save changes to files
- Support for multiple file formats

### Generic Programming
- Use of Java generics for flexible player and team management
- Type-safe collections

### Role-Based Access Control
- Different menus for different user roles
- Secure authentication required for sensitive operations
- Admin role for system management

## 🎯 How to Use - Step by Step

1. **Start the Application**
   ```
   Run: java -cp src Main
   ```

2. **Select Your Role**
   - Enter `1` for Player
   - Enter `2` for Coach (requires login)
   - Enter `3` for Admin (requires login)
   - Enter `0` to exit

3. **Navigate the Menu**
   - Follow the menu prompts
   - Enter the option number for your desired action
   - Follow input prompts as needed

4. **View Information**
   - Browse players by position or name
   - Check team rosters and match schedules
   - Access coaching and administrative features

## 📝 Notes

- The system is designed for the Brazil national team
- All player positions are predefined (Striker, Midfielder, Defender, Goalkeeper)
- Jersey numbers are tracked for each player
- Match statistics include goals, assists, yellow cards, and red cards
- The application is console-based and runs in the terminal

## 🚀 Future Enhancements

Potential improvements for future versions:
- GUI interface using Swing or JavaFX
- Database integration (MySQL, PostgreSQL)
- Player transfer system
- Match result tracking and statistics
- Training session management
- Injury and suspension tracking
- Export reports (PDF, Excel)

## 📄 Documentation

Additional documentation is available in the `Documentation/` folder:
- Project Report: Detailed system documentation
- PowerPoint Presentation: Visual overview of the system

## 📧 Support

For issues or questions regarding the Football Team Management System, refer to:
- The project report in the Documentation folder
- The code comments within each Java file

## 👤 Author

**Nusrat Rahman Aurna**

Connect with the team:
- 🔗 [GitHub](https://github.com/Nusrat60-057)
- 💼 [LinkedIn](https://www.linkedin.com/in/nusrat-rahman-aurna-292b16331/)

**Zeba Tahira**
- 🔗 [GitHub](https://github.com/zebatahira)

---

**Version**: 1.0  

