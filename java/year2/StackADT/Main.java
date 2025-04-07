import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Array Stack
        // StackADT
        ArrayStack<Integer> ArrayStack = new ArrayStack<>();

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Main Menu
        Main.menu();

        // Default Menu Selection
        int myMenu = 0;

        // Loop until user exits
        while (myMenu != 6) {
            // Get user input
            try {
                myMenu = input.nextInt();
            } catch (Exception e) {
                input.next();
                System.out.println("Please choose a valid option");
                myMenu = 0;
            }

            switch (myMenu) {
                // Get input for selection 1, push onto top of list
                case 1:
                    System.out.println("\nWhat is being added to the top of the list?");
                    int topList;

                    // Get user input as integer, else reprint menu (input.next used to handle any invalid input)
                    try {
                        topList = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Please enter an integer");
                        input.next();
                        Main.menu();
                        break;
                    }

                    // Push to top of list, else print error if fails + reprint main menu
                    try {
                        ArrayStack.push(topList);
                        System.out.println("\nAdded " + topList + " to the top of the list");
                        Main.menu();
                    } catch (FullStackException fse) {
                        System.out.println(fse.getMessage());
                        Main.menu();
                    }
                    break;

                // Get input for selection 2, remove from top of list
                case 2:

                    // Pop from top of list + reprint main menu, else print error if fails + reprint main menu
                    try {
                        Integer removedItem = ArrayStack.pop();
                        System.out.println("\n" + removedItem + " removed");
                        Main.menu();
                    } catch (EmptyStackException ese) {
                        System.out.println(ese.getMessage() + "\n");
                        Main.menu();
                    }
                    break;

                // Get input for selection 3, print top of list
                case 3:

                    // Try to print top of list, else print error and redirect to menu
                    try {
                        Integer topItem = ArrayStack.top();
                        System.out.println("\nAt the top of the list is: " + topItem);
                        Main.menu();
                    } catch (EmptyStackException ese) {
                        System.out.println(ese.getMessage() + "\n");
                        Main.menu();
                    }
                    break;

                // Get input for selection 4, check if list is empty or full
                case 4:
                    boolean isEmpty = ArrayStack.isEmpty();

                    // Check if empty or not, print value and reprint menu
                    if (isEmpty) {
                        System.out.println("\nThe list is empty.");
                        Main.menu();
                    } else {
                        System.out.println("\nThe list is not empty.");
                        Main.menu();
                    }
                    break;

                // Get input for selection 5, check size of list
                case 5:
                    int size = ArrayStack.size();

                    // Print size of stack and reprint menu selection
                    System.out.println("\nThe size of the list is: " + size);
                    Main.menu();
                    break;

                case 6:
                    // Return exit case
                    break;

                default:
                    System.out.println("\nPlease choose a valid option");
                    Main.menu();
                    break;
            }

        }
    }

    // Main Menu GUI
    public static void menu() {
        System.out.println("\n1. Add to top of the list");
        System.out.println("2. Remove top item from list");
        System.out.println("3. Examine top item from list");
        System.out.println("4. Check if list is empty");
        System.out.println("5. Check size of the list");
        System.out.println("6. Quit\n");
    }
}