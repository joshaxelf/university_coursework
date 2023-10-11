import java.util.Scanner;

public class Conversation {
    public static void main(String[] args) {

        // Scanner declared
        Scanner scanner = new Scanner(System.in);

        // Conversational Scanner
        System.out.println("Hey, how are you doing?");
        String mood = scanner.nextLine();
        System.out.println("Damn, tell me more if you dont mind.");
        String info = scanner.nextLine();
        System.out.println("Thanks for sharing.");

    }
}
