package com.csc;

import java.util.Scanner;
public class Payroll {
  public static void main(String[] args) {
    System.out.println("Welcome to the Payroll System!");

    System.out.println("Enter the number of hours you worked this week: ");
    Scanner in = new Scanner(System.in);
    double numberOfHours = in.nextDouble();

    System.out.println("Enter the number of dependents you have: ");
    int numberOfDependents = in.nextInt();

    PayCalculator payCalculator = new PayCalculator();
    
    //calculate untaxed income
    double grossPay = payCalculator.grossIncome(numberOfHours);
    
    //calculate expenses
    double socialSecurityTax = payCalculator.socialSecurityTax(grossPay);
    double fedIncomeTax = payCalculator.federalIncomeTax(grossPay);
    double stateIncomeTax = payCalculator.stateIncomeTax(grossPay);
    double insuranceDeductions = payCalculator.insuranceExpense(numberOfDependents);
    double lifeInsuranceExpense = payCalculator.lifeInsurance(numberOfDependents, in);

    //calculate total expenses
    double totalExpenses = payCalculator.totalExpenses(socialSecurityTax, fedIncomeTax, stateIncomeTax, insuranceDeductions, lifeInsuranceExpense);
    //calculate net pay by deducting expenses from gross pay
    double netPay = payCalculator.netPay(grossPay, totalExpenses);

    reportGenerator report = new reportGenerator();

    //generate paystub report
    String payrollOutput = report.payrollReport(numberOfHours, payCalculator.HOURLY_RATE, grossPay, socialSecurityTax, fedIncomeTax, stateIncomeTax, payCalculator.UNION_DUES, insuranceDeductions, lifeInsuranceExpense, totalExpenses, netPay);
    System.out.println(payrollOutput);
    
    in.close();
  }
}
