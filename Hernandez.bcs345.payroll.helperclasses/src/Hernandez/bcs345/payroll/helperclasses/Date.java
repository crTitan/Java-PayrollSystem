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


	//private class members
	private int month, day, year;
	
	//****************************************************
	// Method:  Date
	//
	// Purpose:  Default constructor w/ default values
	//****************************************************
	public Date()
	{
		month= 1;
		day = 1;
		year = 2000;		
	}
		
	//****************************************************
	// Method:  Date
	//
	// Purpose:  Overloads the default Constructor.
	//			 Takes in a date values in the dd, mm, yyy format
	//			Sets this values as the default date 
	//****************************************************
	public Date(int mm, int dd, int yyyy)
	{
		month = mm;
		day = dd;
		year = yyyy;
	}
	
	//****************************************************
	// Method:  getMonth
	//
	//purpose:  returns the month.  
	//****************************************************
	public int getMonth(){return month;}
	
	//****************************************************
	// Method:  getDay
	//
	//purpose:  returns the day.  
	//****************************************************
	public int getDay(){return day;}
	
	//****************************************************
	// Method:  getYear
	//
	//purpose:  returns the year.  
	//****************************************************
	public int getYear(){return year;}
	
	//****************************************************
	// Method:  setMonth
	//
	//purpose:  Sets the month.  
	//****************************************************
	public void setMonth(int newMonth) {month = newMonth;}
	
	//****************************************************
	// Method:  setDay
	//
	//purpose:  Sets the Day.  
	//****************************************************
	public void setDay(int newDay) {day = newDay;}
	
	//****************************************************
	// Method:  setYear
	//
	//purpose:  Sets the year.  
	//****************************************************
	public void setYear(int newYear) {year = newYear;}

	//****************************************************
	// Method:  isSameDate
	//
	//purpose:  Boolean Method that compares two Date objects.
	// 			Compares each individual Date object variable to each other
	//			Returns true if they are equal and false otherwise
	//****************************************************
	public boolean isSameDate(Date other){
		
		if (month == other.getMonth() && day == other.getDay()  && year == other.getYear()){
			
			return true;
		}
		return false;
	}
	
	//****************************************************
	// Method:  Write
	//
	//purpose:  method that writes to the output file
	//****************************************************
	public void Write(PrintStream ps)
	{
		ps.printf("%5d %5d %7d",getMonth(), getDay(), getYear());
	}
	
	//****************************************************
	// Method:  Read
	//
	//purpose:  Sets the date based on the user input.
	// 			uses a Scanner to read in the date
	// 			reads the day, month, and year individually 
	//****************************************************
	public void Read(Scanner s)
	{
		setMonth(s.nextInt());
		setDay(s.nextInt());
		setYear(s.nextInt());
	}
}