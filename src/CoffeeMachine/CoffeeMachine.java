package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int money;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;

    private enum State {
        CHOOSING_ACTION,
        BUYING_COFFEE,
        FILLING_MACHINE
    }

    private State currentState;

    public CoffeeMachine(int money, int water, int milk, int coffeeBeans, int disposableCups) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.currentState = State.CHOOSING_ACTION;
    }

    public void processInput(String input) {
        switch (currentState) {
            case CHOOSING_ACTION:
                handleChoosingAction(input);
                break;
            case BUYING_COFFEE:
                handleBuyingCoffee(input);
                break;
            case FILLING_MACHINE:
                handleFillingMachine(input);
                break;
        }
    }

    private void handleChoosingAction(String action) {
        switch (action) {
            case "buy":
                currentState = State.BUYING_COFFEE;
                break;
            case "fill":
                currentState = State.FILLING_MACHINE;
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printMachineStatus();
                break;
            case "exit":
                System.exit(0);
                break;
        }
    }

    private void handleBuyingCoffee(String coffeeType) {
        if (!coffeeType.equals("back")) {
            int type = Integer.parseInt(coffeeType);
            buyCoffee(type);
        }
        currentState = State.CHOOSING_ACTION;
    }

    private void buyCoffee(int coffeeType) {
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
            default:
                System.out.println("Invalid option!");
        }
    }

    private void handleFillingMachine(String input) {
        String[] inputs = input.split("\\s");
        if (inputs.length == 4) {
            fillMachine(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]),
                    Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));
        } else {
            System.out.println("Invalid input for filling the machine!");
        }
        currentState = State.CHOOSING_ACTION;
    }

    private void fillMachine(int waterToAdd, int milkToAdd, int coffeeBeansToAdd, int cupsToAdd) {
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += coffeeBeansToAdd;
        disposableCups += cupsToAdd;
    }

    private void takeMoney() {
        System.out.println("I gave you " + money);
        money = 0;
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
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

    private void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(550, 400, 540, 120, 9);
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = scanner.nextLine();
            coffeeMachine.processInput(input);
        } while (!input.equals("exit"));
    }
}


