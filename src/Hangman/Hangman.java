import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = words[random.nextInt(words.length)]; // Випадковий вибір слова зі списку

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
