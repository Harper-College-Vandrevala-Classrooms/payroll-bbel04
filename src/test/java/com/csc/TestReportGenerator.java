package com.csc;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestReportGenerator {

  reportGenerator report;

  @BeforeEach
  void setUp() {
    report = new reportGenerator();
  }

  @Test
  void TestReportGeneratorForFortyHoursWorkedandOneDependent() {

    double hours = 40.00;
    double rate = 16.78;
    double gross = 671.20;
    double socSec = 40.27;
    double fedTax = 93.97;
    double stTax = 33.56;
    double union = 10.00;
    double insurance = 15.00;
    double deductions = socSec + fedTax + stTax + union + insurance;
    double net = gross - deductions;

    String result = report.payrollReport(hours, rate, gross, socSec, fedTax, stTax, union, insurance, deductions, net);

        assertTrue(result.contains("Hours Worked:    40.00"));
        assertTrue(result.contains("Hourly Rate:    16.78 $/hr"));
        assertTrue(result.contains("Gross Pay: $ 671.20"));
        assertTrue(result.contains("Social Security Tax: $  40.27"));
        assertTrue(result.contains("Federal Income Tax: $  93.97"));
        assertTrue(result.contains("State Income Tax: $  33.56"));
        assertTrue(result.contains("Union Dues: $  10.00"));
        assertTrue(result.contains("Insurance Premium: $  15.00"));
        assertTrue(result.contains("Total Deductions: $ 192.80"));
        assertTrue(result.contains("Net Pay: $ 478.40"));
  }
}
