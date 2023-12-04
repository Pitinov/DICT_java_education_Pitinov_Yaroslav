package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (as a percentage): ");
        double annualInterestRate = scanner.nextDouble();

        double monthlyInterestRate = annualInterestRate / 100 / 12;
        System.out.print("Enter the number of months: ");
        int numberOfMonths = scanner.nextInt();

        double monthlyPayment = calculateMonthlyPayment(principal, monthlyInterestRate, numberOfMonths);

        for (int month = 1; month <= numberOfMonths; month++) {
            double monthlyRepayment = Math.min(monthlyPayment, principal);
            principal -= monthlyRepayment;

            System.out.println("Month " + month + ": repaid " + monthlyRepayment);

            if (principal <= 0) {
                System.out.println("The loan has been repaid!");
                break;
            }
        }
    }

    private static double calculateMonthlyPayment(double principal, double monthlyInterestRate, int numberOfMonths) {
        return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths))
                / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }
}
