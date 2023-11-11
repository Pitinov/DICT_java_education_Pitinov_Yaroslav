package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int money = 550;
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMachineStatus();

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.next();

        switch (action) {
            case "buy":
                buyCoffee(scanner);
                break;
            case "fill":
                fillMachine(scanner);
                break;
            case "take":
                takeMoney();
                break;
        }

        printMachineStatus();
    }

    private static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int coffeeType = scanner.nextInt();

        switch (coffeeType) {
            case 1:
                makeCoffee(250, 0, 16, 4);
                break;
            case 2:
                makeCoffee(350, 75, 20, 7);
                break;
            case 3:
                makeCoffee(200, 100, 12, 6);
                break;
        }
    }

    private static void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            money += cost;
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
        } else {
            System.out.println("Not enough resources to make coffee!");
        }
    }

    private static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int waterToAdd = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milkToAdd = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeansToAdd = scanner.nextInt();

        System.out.println("Write how many disposable coffee cups you want to add:");
        int cupsToAdd = scanner.nextInt();

        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += cupsToAdd;
    }

    private static void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private static void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}


