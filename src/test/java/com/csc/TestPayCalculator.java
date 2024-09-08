package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestPayCalculator {

  PayCalculator payCalculator;

  @BeforeEach
  void setUp() {
    payCalculator = new PayCalculator();
  }

  @Test
  void CalculatePayForZeroHoursWorked() {
    assertEquals(payCalculator.grossIncome(0),0);
  }

  @Test
  void CalculatePayForFortyHoursWorked() {
    assertEquals(payCalculator.grossIncome(40), 671.20, 0.01);
  }
//fail
  @Test
  void CalculatePayForFortyFiveHoursWorked() {
    assertEquals(payCalculator.grossIncome(45.00), 797.05, 0.01);
  }

  @Test
  void CalculatePayForThirtyAndOneQuarterHoursWorked() {
    assertEquals(payCalculator.grossIncome(30.25), 507.60, 0.01);
  }

  @Test
  void CalculatePayForNegativeHoursWorked() {
    assertEquals(payCalculator.grossIncome(-5), 0);
  }

  @Test
  void CalculateSocialSecurityTaxForOneHundredDollars() {
    assertEquals(payCalculator.socialSecurityTax(100), 6.00);
  }
//fail
  @Test
  void CalculateFederalIncomeTaxForOneHundredDollars() {
    assertEquals(payCalculator.federalIncomeTax(100), 14.00, 0.01);
  }

  @Test
  void CalculateStateIncomeTaxForOneHundredDollars() {
    assertEquals(payCalculator.stateIncomeTax(100), 5);
  }

  @Test
  void CalculateInsuranceDeductionForZeroDependents() {
    assertEquals(payCalculator.insuranceExpense(0), 15.00);
  }
  @Test
  void CalculateInsuranceDeductionForOneDependent() {
    assertEquals(payCalculator.insuranceExpense(1), 15.00);
  }

  @Test
  void CalculateInsuranceDeductionForThreeDependents() {
    assertEquals(payCalculator.insuranceExpense(3), 35.00);
  }

  @Test
  void CalculateInsuranceDeductionForTenDependents() {
    assertEquals(payCalculator.insuranceExpense(10), 35.00);
  }

  @Test 
  void CalculateTotalExpensesForTenHoursWorkedandOneDependent() {
    assertEquals(payCalculator.totalExpenses(10.07, 23.49, 8.39, 15.00), 66.95);
  }

  @Test 
  void CalculateTotalExpensesForVariousValues() {
    assertEquals(payCalculator.totalExpenses(15.32, 20.15, 5.33, 15.00), 65.80);
  }

  @Test
  void CalculateNetPayForTenHoursWorkedAndOneDependent() {
    assertEquals(payCalculator.netPay(167.80, 66.95), 100.85, 0.01);
  }

  @Test
  void CalculateNetPayForOneHourWorkedAndZeroDependents() {
    assertEquals(payCalculator.netPay(16.78, 29.20), -12.42, 0.01);
  }
}
