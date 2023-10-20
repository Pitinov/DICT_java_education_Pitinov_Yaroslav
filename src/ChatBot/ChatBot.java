import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {

        String botName = "MyBot";
        int birthYear = 2023;


        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");


        Scanner scanner = new Scanner(System.in);


        System.out.println("Please, remind me your name.");


        String yourName = scanner.nextLine();


        System.out.println("What a great name you have, " + yourName + "!");
    }
}



