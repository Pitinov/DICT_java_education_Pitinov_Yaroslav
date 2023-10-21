import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = words[random.nextInt(words.length)]; // Випадковий вибір слова зі списку
        StringBuilder guessedWord = new StringBuilder(secretWord.length());

        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.append("-");
        }

        int remainingAttempts = 8;

        System.out.println("HANGMAN");
        System.out.println(guessedWord);

        while (remainingAttempts > 0) {
            System.out.print("Input a letter: > ");
            char inputLetter = scanner.next().charAt(0);
            boolean letterFound = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == inputLetter && guessedWord.charAt(i) == '-') {
                    guessedWord.setCharAt(i, inputLetter);
                    letterFound = true;
                }
            }

            if (letterFound) {
                System.out.println(guessedWord);
            } else {
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }

            if (guessedWord.toString().equals(secretWord)) {
                System.out.println("Thanks for playing!");
                System.out.println("We'll see how well you did in the next stage");
                break;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("You ran out of attempts. The word was: " + secretWord);
        }
    }
}
