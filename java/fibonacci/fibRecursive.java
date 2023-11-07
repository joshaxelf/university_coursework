import java.util.Scanner;

public class fibRecursive {

    // Declare int and define it here for use in static void
    public static int fibonacci(int input) {

        // Basic arithmetic to validate sequence
        if (input <= 1) {
            return input;
        }

        // Otherwise do recursion arithmetic
        return fibonacci(input - 1) + fibonacci(input - 2);

    }

    public static void main(String[] args) {

        // Input scanner and get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Analyse which number in the sequence?");

        // Get input, store in integer input
        int input = scanner.nextInt();

        // Authentication for valid number, must check 1st item or higher in sequence
        if (input > 0) {
            // Print out input from fibonacci method
            System.out.println(fibonacci(input));
        } else {
            System.out.println("Please enter a valid number in sequence");
        }

    }

}
