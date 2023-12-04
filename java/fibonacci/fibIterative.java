import java.util.Scanner;

public class fibIterative {

    public static void main(String[] args) {


        // Declare starting point = previous
        // Declare second in system = current
        // Need a counter for arithmetic
        int previous = 0;
        int current = 1;
        int result;

        // Input scanner and get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Analyse which number in the sequence?");

        // Get input, store in integer input
        int num = scanner.nextInt();

        // Authentication for valid number, must check 1st item or higher in sequence
        if (num > 0) {

            // Handles arithmetic
            for (int i = 2; i <= num; i++) {

                result = current + previous; // Where result is sum of current + previous (5 + 8 = 13)
                previous = current; // Now previous becomes 8
                current = result; // Now current becomes 13

            }

            // Print out current after loop ends
            System.out.println(current);
        } else {
            System.out.println("Please enter a valid number in sequence");
        }

    }
}