package com.csc;

public class reportGenerator {
    public String payrollReport(double hours, double rate, double gross, double socSec, double fedTax, double stTax, double union, double insurance, double deductions, double net) {

        StringBuilder report = new StringBuilder();

        report.append(String.format("Payroll Stub%n%n"));
        report.append(String.format("%20s: %8.2f%n", "Hours Worked", hours));
        report.append(String.format("%20s: %8.2f $/hr%n", "Hourly Rate", rate));
        report.append(String.format("%20s: %s%7.2f%n%n", "Gross Pay", "$", gross));
        report.append(String.format("%15s%n", "Tax Deductions"));
        report.append(String.format("%20s: %s%7.2f%n", "Social Security Tax", "$", socSec));
        report.append(String.format("%20s: %s%7.2f%n", "Federal Income Tax", "$", fedTax));
        report.append(String.format("%20s: %s%7.2f%n","State Income Tax", "$", stTax));
        report.append(String.format("%20s: %s%7.2f%n","Union Dues", "$", union));
        report.append(String.format("%20s: %s%7.2f%n","Insurance Premium", "$", insurance));
        report.append(String.format("%20s: %s%7.2f%n%n","Total Deductions", "$", deductions));
        report.append(String.format("%20s: %s%7.2f%n%n","Net Pay", "$", net));

        report.append(String.format("Thank you for using the Payroll System!"));

        return report.toString();
    }
}
