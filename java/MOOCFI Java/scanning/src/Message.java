// Import Scanner for use

import java.util.Scanner;

public class Message {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Request user input
        System.out.println("Write a message");

        // Get message, store in message
        String message = scanner.nextLine();

        // Return message
        System.out.println(message);

    }

}