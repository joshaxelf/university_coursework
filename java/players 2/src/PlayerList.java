import java.io.File; // Import file class
import java.io.FileNotFoundException; // Import to file exception for errors
import java.util.ArrayList; // Import modifiable array, supports get and set
import java.util.Collections; // Import collection for natural collection
import java.util.Scanner; // Import scanner to read data

public class PlayerList {

    public static void main(String[] args) {

        // Specify the path to your text file
        String textFile = "/Users/joshforeman/code/university-coursework/java/players/Players.txt";
        String textFile2 = "/Users/joshforeman/code/university-coursework/java/players/Players2.txt";

        // Create a list to store Player data
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Player> players2 = new ArrayList<>();

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Main Menu
        PlayerList.menu();

        // Default Menu Selection
        int myMenu = 0;

        // Loop until user exits
        while (myMenu != 4) {
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

                            // Locate Player and Team Name and add to variables
                            String playerName = data[0].trim();
                            String teamName = data[1].trim();

                            // Locate the Player Score and store as integer
                            int playerScore = Integer.parseInt(data[2].trim());

                            // Create a new Player object and add data
                            players.add(new Player(playerName, teamName, playerScore));

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
                    System.out.println("\n");
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

                                // Locate Player and Team Name and add to variables
                                String playerName = data[0].trim();
                                String teamName = data[1].trim();

                                // Locate the Player Score and store as integer
                                int playerScore = Integer.parseInt(data[2].trim());

                                // Create a new Player object and add data
                                players.add(new Player(playerName, teamName, playerScore));

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
                    System.out.println("\n");
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

                            // Locate Player and Team Name and add to variables
                            String playerName = data[0].trim();
                            String teamName = data[1].trim();

                            // Locate the Player Score and store as integer
                            int playerScore = Integer.parseInt(data[2].trim());

                            // Create a new Player object and add data
                            players.add(new Player(playerName, teamName, playerScore));

                        }

                        // Close the file
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        // Handle file not found exception
                        System.err.println("Error: File not found");
                    }

                    // Go on to sort players from text file 1 for highest scorer
                    Collections.sort(players);

                    // Display the details of players in the order they are read and present neatly
                    System.out.println("--- Player Data 1 [SORTED] ---");
                    for (Player player : players) {
                        System.out.println("Player - " + player.getPlayerName() +
                                " " + player.getTeamName() +
                                " " + player.getPlayerScore());

                    }

                    // Line break before new list prints
                    System.out.println("\n");
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
        System.out.println("3. Print sorted Players 1 by score");
        System.out.println("4. Quit\n");
    }

}
