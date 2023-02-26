/************************************************************
 *  Name:         Alex Cruz
 *  Date:         1/11/23
 *  Assignment:   Payroll
 *  Class Number: CIS 282
 *  Description:  A program that takes 5 user inputs and returns calculations.
 ************************************************************/

fun main() {
    // Prompt
    print("Enter Employee’s name: ")
    var name = readLine()!!
    print("Enter number of hours worked in a week: ")
    var hoursWorked = readLine()!!.toFloat()
    print("Enter hourly pay rate: ")
    var hourlyPay = readLine()!!.toFloat()
    print("Enter federal tax withholding rate: ")
    var federalTax = readLine()!!.toFloat() * 1.0
    print("Enter state tax withholding rate: ")
    var stateTax = readLine()!!.toFloat() * 1.0

    // Gross pay calculation
    var grossPay = hourlyPay * hoursWorked;


    // Print user input data
    println("\nEmployee Name:  ${name}")
    println("Hours Worked:  ${hoursWorked}")
    println("Pay Rate:  $${hourlyPay}")
    println("Gross Pay:  $${"%.2f".format(grossPay)}")

    // Withholding calculations
    var federalDeductions = (federalTax * grossPay) / 100
    var stateDeductions = (stateTax * grossPay) / 100
    var totalDeductions = federalDeductions + stateDeductions
    var netPay = grossPay - totalDeductions

    // Print back deductions
    println("\nDeductions: ")
    println("   Federal Withholding (${federalTax}%): $${"%.2f".format(federalDeductions)}")
    println("   State Withholding (${stateTax}%): $${"%.2f".format(stateDeductions)}")
    println("   Total Deduction:  $${"%.2f".format(totalDeductions)}")
    println("Net Pay: $${"%.2f".format(netPay)}")

}