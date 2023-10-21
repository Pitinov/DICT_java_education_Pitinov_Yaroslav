import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = "java";

        System.out.println("HANGMAN");
        System.out.print("Guess the word: > ");

        String userGuess = scanner.next();

        if (userGuess.equalsIgnoreCase(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
