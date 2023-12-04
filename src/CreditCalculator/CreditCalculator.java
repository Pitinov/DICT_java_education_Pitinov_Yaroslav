package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan principal: ");
        double principal = scanner.nextDouble();

        System.out.println("What do you want to calculate?");
        System.out.println("Type \"m\" – for the number of monthly payments,");
        System.out.println("Type \"p\" – for the monthly payment:");
        char calculationType = scanner.next().charAt(0);

        if (calculationType == 'm') {
            System.out.print("Enter the monthly payment: ");
            double monthlyPayment = scanner.nextDouble();
            int numberOfMonths = calculateNumberOfMonths(principal, monthlyPayment);
            System.out.println("It will take " + numberOfMonths + " months to repay the loan");
        } else if (calculationType == 'p') {
            System.out.print("Enter the number of months: ");
            int numberOfMonths = scanner.nextInt();
            double monthlyPayment = calculateMonthlyPayment(principal, numberOfMonths);
            double lastPayment = calculateLastPayment(principal, numberOfMonths, monthlyPayment);
            System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment) +
                    " and the last payment = " + (int) Math.floor(lastPayment));
        }
    }

    private static int calculateNumberOfMonths(double principal, double monthlyPayment) {
        return (int) Math.ceil(principal / monthlyPayment);
    }

    private static double calculateMonthlyPayment(double principal, int numberOfMonths) {
        return principal / numberOfMonths;
    }

    private static double calculateLastPayment(double principal, int numberOfMonths, double monthlyPayment) {
        return principal - (numberOfMonths - 1) * monthlyPayment;
    }
}
