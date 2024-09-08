package com.csc;
public class PayCalculator {

    double grossPay = 0;
    double totalExpenses = 0;

    final double HOURLY_RATE = 16.78;
    final double UNION_DUES = 10.00; 
    final double SOCIAL_SEC_TAX_RATE = 0.06;
    final double FED_INC_TAX_RATE = 0.14;
    final double STATE_INC_TAX_RATE = 0.05;

    public double grossIncome(double hours) {

        double overtimeRate = 1.5 * HOURLY_RATE;

        if (0 <= hours && hours <= 40) {
            this.grossPay = hours * HOURLY_RATE;
        }
        else if (hours > 40) {
            double overtimeHours = hours - 40;
            this.grossPay = 40 * HOURLY_RATE + (overtimeHours * overtimeRate);
        }
        else {
            this.grossPay = 0;
        }

        return this.grossPay;
    }

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

    public double totalExpenses (double socSec, double fedInc, double stateInc, double insDed) {
        return socSec + fedInc + stateInc + insDed + UNION_DUES;
    }

    public double netPay(double grossAmt, double expenses) {
        return grossAmt - expenses;
    } 
}
