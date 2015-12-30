//****************************************************
// File: Date.java  
//
// Purpose: Read in a date in the mm dd yyyy format.
//
// Written By: Paul A. Rodriguez Hernandez 
//
// Date: 11/05/2014
//
//****************************************************

package Hernandez.bcs345.payroll.helperclasses;

import java.io.PrintStream;
import java.util.Scanner;

public class Date {

	private int month, day, year;

	public Date() {
		month = 1;
		day = 1;
		year = 2000;
	}

	public Date(int mm, int dd, int yyyy) {
		month = mm;
		day = dd;
		year = yyyy;
	}

	public int getMonth() {

		return month;
	}

	public int getDay() {

		return day;
	}

	public int getYear() {

		return year;
	}

	public void setMonth(int newMonth) {

		month = newMonth;
	}

	public void setDay(int newDay) {

		day = newDay;
	}

	public void setYear(int newYear) {

		year = newYear;
	}

	public boolean isSameDate(Date other) {

		if (month == other.getMonth() && day == other.getDay() && year == other.getYear()) {

			return true;
		}

		return false;
	}

	public void Write(PrintStream ps) {

		ps.printf("%5d %5d %7d", getMonth(), getDay(), getYear());
	}

	public void Read(Scanner s) {

		setMonth(s.nextInt());

		setDay(s.nextInt());

		setYear(s.nextInt());
	}
}