import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayerList {

    public static void main(String[] args) {

        // Specify the path to the text file
        String textFile = "/Users/joshforeman/code/university-coursework/java/players/Players.txt";
        String textFile2 = "/Users/joshforeman/code/university-coursework/java/players/Players2.txt";

        // Create lists to store Player data
        List<Player> players = new ArrayList<>();
        List<Player> players2 = new ArrayList<>();

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Main Menu
        PlayerList.menu();

        // Default Menu Selection
        int myMenu = 0;

        // Loop until user exits
        while (myMenu != 5) {
            // Get user input
            try {
                myMenu = input.nextInt();
            } catch (Exception e) {
                input.next();
                System.out.println("Please choose a valid option");
                myMenu = 0;
            }

            switch (myMenu) {
                // Read and print text file 1
                case 1:

                    try {
                        // Create a Scanner to read from the file
                        Scanner scanner = new Scanner(new File(textFile));

                        // Read player details from the file, verify and read data
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            // Split the text line into chunks for our data
                            // Use "\\s+" which breaks data by spaces
                            String[] data = line.split("\\s+");

                            // Call Player class and set Player data
                            Player player = new Player();
                            player.setPlayerName(data[0].trim());
                            player.setTeamName(data[1].trim());
                            player.setPlayerScore(Integer.parseInt(data[2].trim()));

                            // Create a new Player object and add data
                            players.add(player);

                        }

                        // Close the file
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        // Handle file not found exception
                        System.err.println("Error: File not found");
                    }

                    // Display the details of players in the order they are read. Present neatly
                    System.out.println("--- Player Data 1 ---");
                    for (Player player : players) {
                        System.out.println("Player - " + player.getPlayerName() +
                                " " + player.getTeamName() +
                                " " + player.getPlayerScore());
                    }

                    // Line break before new list prints
                    System.out.println();
                    break;

                // Read and print Text file 2
                case 2:

                    try {
                        // Create a Scanner to read from the file
                        Scanner scanner = new Scanner(new File(textFile2));

                        // Read player details from the file, verify and read data
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            // Split the text line into chunks for our data
                            // Use "\\s+" which breaks data by spaces
                            String[] data = line.split("\\s+");

                            // Check if the line has all three components
                            if (data.length == 3) {

                                // Call Player class and set Player data
                                Player player = new Player();
                                player.setPlayerName(data[0].trim());
                                player.setTeamName(data[1].trim());
                                player.setPlayerScore(Integer.parseInt(data[2].trim()));

                                // Create a new Player object and add data
                                players.add(player);

                            } else {
                                // Throw an error if a line doesnt have the expected format, print line for easy navigation to bug fix
                                System.err.println("Error found in text file 2 --> " + line + " is not in a valid format");

                                // Stop programming from advancing through
                                System.exit(1);
                            }
                        }

                        // Close the file
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        // Handle file not found exception
                        System.err.println("File not found");
                    }

                    // Display the details of players in the order they are read and present neatly
                    System.out.println("--- Player Data 2 ---");
                    for (Player player : players2) {
                        System.out.println("Player - " + player.getPlayerName() +
                                " " + player.getTeamName() +
                                " " + player.getPlayerScore());
                    }

                    // Line break before new list prints
                    System.out.println();
                    break;

                // Read and sort text file 1 by score
                case 3:

                    try {
                        // Create a Scanner to read from the file
                        Scanner scanner = new Scanner(new File(textFile));

                        // Read player details from the file, verify and read data
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            // Split the text line into chunks for our data
                            // Use "\\s+" which breaks data by spaces
                            String[] data = line.split("\\s+");

                            // Call Player class and set Player data
                            Player player = new Player();
                            player.setPlayerName(data[0].trim());
                            player.setTeamName(data[1].trim());
                            player.setPlayerScore(Integer.parseInt(data[2].trim()));

                            // Create a new Player object and add data
                            players.add(player);

                        }

                        // Close the file
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        // Handle file not found exception
                        System.err.println("Error: File not found");
                    }

                    // Go on to sort players from text file 1 for highest scorer
                    Collections.sort(players);

                    // Print details of players in the order they are read and present neatly for Player in players
                    System.out.println("--- Player Data 1 [SORTED BY SCORE] ---");
                    for (Player player : players) {
                        System.out.println("Player - " + player.getPlayerName() +
                                " " + player.getTeamName() +
                                " " + player.getPlayerScore());

                    }

                    // Line break before new list prints
                    System.out.println();
                    break;

                case 4:

                    try {
                        // Create a Scanner to read from the file
                        Scanner scanner = new Scanner(new File(textFile));

                        // Read player details from the file, verify and read data
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            // Split the text line into chunks for our data
                            // Use "\\s+" which breaks data by spaces
                            String[] data = line.split("\\s+");

                            // Call Player class and set Player data
                            Player player = new Player();
                            player.setPlayerName(data[0].trim());
                            player.setTeamName(data[1].trim());
                            player.setPlayerScore(Integer.parseInt(data[2].trim()));

                            // Create a new Player object and add data
                            players.add(player);

                        }

                        // Close the file
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        // Handle file not found exception
                        System.err.println("Error: File not found");
                    }

                    // IDE suggested changing Collection to players, why??
                    players.sort(new NameCompare());

                    // Print details of players in the order they are read and present neatly
                    System.out.println("--- Player Data 1 [SORTED BY NAME] ---");
                    for (Player player : players) {
                        System.out.println("Player - " + player.getPlayerName() +
                                " " + player.getTeamName() +
                                " " + player.getPlayerScore());

                    }

                    // Line break before new list prints
                    System.out.println();
                    break;

                default:
                    System.out.println("\nPlease choose a valid option");
                    PlayerList.menu();
                    break;
            }
        }
    }

    // Main Menu GUI
    public static void menu() {
        System.out.println("\n1. Print Players 1");
        System.out.println("2. Print Players 2");
        System.out.println("3. Print Players 1, sorted by score");
        System.out.println("4. Print Players 1, sorted by team and name");
        System.out.println("5. Quit\n");
    }

}


//Extra help and further questions:
//
//I wanted to make a program that had usability to select
//what file to load and how to sort it. I want to make this menu more readable.
//I want to make it so that I have different classes with my methods to call them in
//so that my program is further OOP and main is dedicated for calling and readability.