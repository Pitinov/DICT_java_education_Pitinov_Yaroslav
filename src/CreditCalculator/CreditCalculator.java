package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        String type = System.getProperty("type");
        if (type == null || (!type.equals("annuity") && !type.equals("diff"))) {
            System.out.println("Incorrect parameters");
            return;
        }

        if (type.equals("diff")) {
            calculateDifferentialPayments(args);
        } else if (type.equals("annuity")) {
            calculateAnnuityPayments(args);
        }
    }

    private static void calculateDifferentialPayments(String[] args) {
        if (args.length < 4) {
            System.out.println("Incorrect parameters");
            return;
        }

        double principal = Double.parseDouble(args[1]);
        int periods = Integer.parseInt(args[2]);
        double interestRate = Double.parseDouble(args[3]);

        double i = interestRate / 100 / 12;
        double totalPayments = 0;

        for (int month = 1; month <= periods; month++) {
            double payment = (principal / periods) + i * (principal - (principal * (month - 1)) / periods);
            int roundedPayment = (int) Math.ceil(payment);
            System.out.println("Month " + month + ": payment is " + roundedPayment);
            totalPayments += roundedPayment;
        }

        int overpayment = (int) totalPayments - (int) principal;
        System.out.println("Overpayment = " + overpayment);
    }

    private static void calculateAnnuityPayments(String[] args) {
        if (args.length < 4) {
            System.out.println("Incorrect parameters");
            return;
        }

        double principal = Double.parseDouble(args[1]);
        int periods = Integer.parseInt(args[2]);
        double interestRate = Double.parseDouble(args[3]);

        double i = interestRate / 100 / 12;
        double annuityPayment = principal * (i * Math.pow(1 + i, periods)) / (Math.pow(1 + i, periods) - 1);
        int roundedPayment = (int) Math.ceil(annuityPayment);

        if (args.length == 5 && args[4].equals("--payment")) {
            System.out.println("Incorrect parameters");
            return;
        }

        if (args.length == 6 && args[4].equals("--payment")) {
            int annuityPaymentArg = Integer.parseInt(args[5]);
            if (annuityPaymentArg != roundedPayment) {
                System.out.println("Incorrect parameters");
                return;
            }
        }

        if (args.length == 6 && args[4].equals("--periods")) {
            int periodsArg = Integer.parseInt(args[5]);
            if (periodsArg != periods) {
                System.out.println("Incorrect parameters");
                return;
            }
        }

        if (args.length == 6 && args[4].equals("--principal")) {
            double principalArg = Double.parseDouble(args[5]);
            if (principalArg != principal) {
                System.out.println("Incorrect parameters");
                return;
            }
        }

        System.out.println("Your annuity payment = " + roundedPayment + "!");
    }
}
