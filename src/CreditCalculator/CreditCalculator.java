package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("Type \"n\" for the number of monthly payments,");
        System.out.println("Type \"a\" for annuity monthly payment amount,");
        System.out.println("Type \"p\" for loan principal:");

        char calculationType = scanner.next().charAt(0);

        switch (calculationType) {
            case 'n':
                calculateNumberOfPayments(scanner);
                break;
            case 'a':
                calculateAnnuityPayment(scanner);
                break;
            case 'p':
                calculateLoanPrincipal(scanner);
                break;
            default:
                System.out.println("Invalid input. Please choose 'n', 'a', or 'p'.");
        }
    }

    private static void calculateNumberOfPayments(Scanner scanner) {
        System.out.print("Enter the loan principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the monthly payment: ");
        double monthlyPayment = scanner.nextDouble();
        System.out.print("Enter the loan interest: ");
        double interestRate = scanner.nextDouble();

        double i = interestRate / 100 / 12;
        double n = Math.log(monthlyPayment / (monthlyPayment - i * principal)) / Math.log(1 + i);
        int numberOfMonths = (int) Math.ceil(n);

        int years = numberOfMonths / 12;
        int months = numberOfMonths % 12;

        System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
    }

    private static void calculateAnnuityPayment(Scanner scanner) {
        System.out.print("Enter the loan principal: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the number of periods: ");
        int numberOfPeriods = scanner.nextInt();
        System.out.print("Enter the loan interest: ");
        double interestRate = scanner.nextDouble();

        double i = interestRate / 100 / 12;
        double monthlyPayment = principal * (i * Math.pow(1 + i, numberOfPeriods)) / (Math.pow(1 + i, numberOfPeriods) - 1);

        System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment) + "!");
    }

    private static void calculateLoanPrincipal(Scanner scanner) {
        System.out.print("Enter the annuity payment: ");
        double annuityPayment = scanner.nextDouble();
        System.out.print("Enter the number of periods: ");
        int numberOfPeriods = scanner.nextInt();
        System.out.print("Enter the loan interest: ");
        double interestRate = scanner.nextDouble();

        double i = interestRate / 100 / 12;
        double loanPrincipal = annuityPayment * ((Math.pow(1 + i, numberOfPeriods) - 1) / (i * Math.pow(1 + i, numberOfPeriods)));

        System.out.println("Your loan principal = " + (int) Math.ceil(loanPrincipal) + "!");
    }
}
