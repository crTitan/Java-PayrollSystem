//****************************************************
// File: Shift.java  
//
// Purpose: Gathers employee info
//including id, hours worked, and date.
//
// Written By: Paul A. Rodriguez Hernandez 
//
// Date: 10/5/2014       
//****************************************************

package Hernandez.bcs345payroll.employeedata;

import java.io.PrintStream;
import java.util.Scanner;

import Hernandez.bcs345.payroll.helperclasses.*;

public class Shift {

	private int id;
	private double hoursWorked;
	private Date date = new Date(1, 1, 2000);

	public Shift() {
		id = 0;
		hoursWorked = 0.0;
	}

	public Shift(int idNum, double hw, Date d) {
		id = idNum;
		hoursWorked = hw;
		date = d;
	}

	public int getId() {
		return id;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public Date getDate() {
		return date;
	}

	public int getDay() {
		return date.getDay();
	}

	public int getMonth() {
		return date.getMonth();
	}

	public int getYear() {
		return date.getYear();
	}

	public void setId(int newId) {
		id = newId;
	}

	public void setHoursWorked(double newHoursWorked) {
		hoursWorked = newHoursWorked;
	}

	public void setDate(Date new_Date) {
		date = new_Date;
	}

	public void Write(PrintStream ps) {
		ps.printf("%5d %6.2f ", id, hoursWorked);
		date.Write(ps);
	}

	public void Read(Scanner scanner) {

		setId(scanner.nextInt());

		setHoursWorked(scanner.nextDouble());

		date.Read(scanner);
	}
}