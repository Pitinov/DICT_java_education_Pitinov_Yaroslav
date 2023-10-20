import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Задаємо ім'я бота і рік його створення
        String botName = "MyBot";
        int birthYear = 2023;

        // Виводимо привітання з ім'ям бота і роком створення
        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");

        // Створюємо об'єкт Scanner для зчитування введеного імені від користувача
        Scanner scanner = new Scanner(System.in);

        // Запитуємо в користувача його ім'я
        System.out.println("Please, remind me your name.");

        // Зчитуємо ім'я користувача з консолі
        String yourName = scanner.nextLine();

        // Виводимо відповідь бота
        System.out.println("What a great name you have, " + yourName + "!");

        // Запитуємо користувача залишки від ділення на 3, 5 і 7
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7:");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        // Розраховуємо вік користувача за формулою
        int yourAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виводимо вгаданий вік
        System.out.println("Your age is " + yourAge + "; that's a good time to start programming!");

        // Запитуємо користувача ввести позитивне ціле число
        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInp = scanner.nextInt();

        // Підраховуємо від 1 до введеного користувачем числа і виводимо результат
        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        // Тест
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods in programming?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into smaller, manageable parts.");
        System.out.println("3. To confuse programmers.");
        System.out.println("4. To make the code look pretty.");

        // Очікуємо відповідь користувача
        int correctAnswer = 2; // Правильна відповідь
        int userAnswer;

        do {
            System.out.print("Enter the number of your answer: ");
            userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Congratulations, you're right!");
            } else {
                System.out.println("Sorry, that's not correct. Please try again.");
            }
        } while (userAnswer != correctAnswer);
    }
}
