package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int cupsWater = availableWater / 200;
        int cupsMilk = availableMilk / 50;
        int cupsCoffeeBeans = availableCoffeeBeans / 15;

        int possibleCups = Math.min(Math.min(cupsWater, cupsMilk), cupsCoffeeBeans);

        if (possibleCups == cupsNeeded) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (possibleCups > cupsNeeded) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (possibleCups - cupsNeeded) + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }
}

