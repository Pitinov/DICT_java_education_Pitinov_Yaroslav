import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("HANGMAN");
        String command;
        do {
            System.out.println("Type \"play\" to play the game, \"exit\" to quit: ");
            command = scanner.nextLine().trim().toLowerCase();

            if ("play".equals(command)) {
                playGame(scanner);
            } else if (!"exit".equals(command)) {
                System.out.println("Invalid command. Please type \"play\" to play or \"exit\" to quit.");
            }
        } while (!"exit".equals(command));
    }

    public static void playGame(Scanner scanner) {
        Random random = new Random();

        String[] words = {"python", "java", "javascript", "kotlin"};
        String secretWord = words[random.nextInt(words.length)];
        StringBuilder guessedWord = new StringBuilder(secretWord.length());

        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.append("-");
        }

        int remainingAttempts = 8;
        StringBuilder usedLetters = new StringBuilder();

        System.out.println("----------");
        while (remainingAttempts > 0) {
            System.out.print("Input a letter: > ");
            String input = scanner.next().toLowerCase();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char inputLetter = input.charAt(0);

            if (usedLetters.indexOf(String.valueOf(inputLetter)) != -1) {
                System.out.println("You've already guessed this letter");
            } else if (secretWord.indexOf(inputLetter) != -1) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == inputLetter) {
                        guessedWord.setCharAt(i, inputLetter);
                    }
                }
                System.out.println(guessedWord);
            } else {
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }

            usedLetters.append(inputLetter);

            if (guessedWord.toString().equals(secretWord)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("You ran out of attempts. The word was: " + secretWord);
        }
    }
}
