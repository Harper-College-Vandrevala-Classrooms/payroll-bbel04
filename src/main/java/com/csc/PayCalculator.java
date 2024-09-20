package com.csc;

import java.util.Scanner;

public class PayCalculator {

    double grossPay = 0;
    double totalExpenses = 0;

    final double HOURLY_RATE = 16.78;    //fixed hourly rate of 16.78
    final double UNION_DUES = 10.00;     //fixed 10 dollar union fee
    final double SOCIAL_SEC_TAX_RATE = 0.06;   //6% social security tax rate
    final double FED_INC_TAX_RATE = 0.14;     //14% federal income tax rate
    final double STATE_INC_TAX_RATE = 0.05;   //5% state income tax rate

    public double grossIncome(double hours) {

        double overtimeRate = 1.5 * HOURLY_RATE;    //pay overtime hours time and a half

        if (0 <= hours && hours <= 40) {
            this.grossPay = hours * HOURLY_RATE;    //pay straight time if 40 hours or under
        }
        else if (hours > 40) {      //pay straight time for first 40 hours worked, time and a half for overtime
            double overtimeHours = hours - 40;
            this.grossPay = 40 * HOURLY_RATE + (overtimeHours * overtimeRate);
        }
        else {
            this.grossPay = 0;    //if negative hours are input, set pay to 0
        }

        return this.grossPay;
    }

    //calculate deductions
    public double socialSecurityTax (double gross) {
        double socSecTax = gross * SOCIAL_SEC_TAX_RATE;  
        return socSecTax;
    }

    public double federalIncomeTax (double gross) {
        return gross * FED_INC_TAX_RATE;
    }

    public double stateIncomeTax (double gross) {
        return gross * STATE_INC_TAX_RATE;
    }

    public double insuranceExpense (int numOfDependents) {
        return (numOfDependents < 3) ? 15.00 : 35.00;
    }

    //life insurance plan method
    public double lifeInsurance (int dependents, Scanner scanner) {
        while (true) { //execute until valid plan is selected
            
            System.out.println("Which life insurance plan do you want to select?\n");
            String plan1 = String.format("%8s%-4s%-30s", "", "(1)", "no plan");
            String plan2 = String.format("%8s%-4s%-30s", "", "(2)", "single plan");
            String plan3 = String.format("%8s%-4s%-30s", "", "(3)", "married plan");
            String plan4 = String.format("%8s%-4s%-30s", "", "(4)", "married with children plan");

            System.out.println(plan1);
            System.out.println(plan2);
            System.out.println(plan3);
            System.out.println(plan4);

            if (!scanner.hasNextInt()) {   //if input is not an int
                System.out.println("Invalid input. Please enter a number between 1 and 4: ");
                scanner.next();
                continue;
            }

            int lifeInsurancePlan = scanner.nextInt();
            double lifeInsuranceExpense = 0;

            if (lifeInsurancePlan == 1) {
                return lifeInsuranceExpense;
            }
            else if (lifeInsurancePlan == 2) {
                return lifeInsuranceExpense += 5.00;
            }
            else if (lifeInsurancePlan == 3) {
                return lifeInsuranceExpense += 10.00;
            }
            else if (lifeInsurancePlan == 4) {
                if (1 <= dependents) { //at least one dependent needed to select plan
                    return lifeInsuranceExpense += 15.00;
                }
                else { 
                    System.out.println("Error: Need at least one dependent to select this plan.");
                }
            }
            else {
                System.out.println("Invalid option. Please enter a valid plan.");
            }
        }
    }

    //add up all deductions
    public double totalExpenses (double socSec, double fedInc, double stateInc, double insDed, double lifeInsExpense) {
        return socSec + fedInc + stateInc + insDed + UNION_DUES + lifeInsExpense;
    }

    //subtract total deductions from gross pay to get netpay
    public double netPay(double grossAmt, double expenses) {
        return grossAmt - expenses;
    } 

}
