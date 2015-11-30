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

	//class variables
	private int id;
	private double hoursWorked;
	Date newDate = new Date(1, 1, 2000);
	
	//****************************************************
	// Method: Shift
	//
	//Purpose:  default constructor
	//****************************************************
	public Shift()
	{
		id = 0;
		hoursWorked = 0.0;
	}
	
	//****************************************************
	// Method: Shift
	//
	//Purpose:  Overloading constructor.
	//			Overloads the default values
	//****************************************************
	public Shift(int idNum, double hw, Date d)
	{
		id = idNum;
		hoursWorked = hw;
		newDate = d;
	}
	
	//****************************************************
	// Method: getId
	//
	//Purpose:  method that returns the id
	//****************************************************
	public int getId(){return id;}
	
	//****************************************************
	// Method: getHoursWorked
	//
	//Purpose:  method that returns the hours worked
	//****************************************************
	public double getHoursWorked(){return hoursWorked;}
	
	//****************************************************
	// Method: getDate
	//
	//Purpose:  method that returns the date
	//****************************************************
	public Date getDate(){return newDate;}
	
	//****************************************************
	// Method: setId
	//
	//Purpose:  method that sets the new id
	//****************************************************
	public void setId(int newId){id = newId;}
	
	//****************************************************
	// Method: setHoursWorked
	//
	//Purpose:  method that sets the hours worked
	//****************************************************
	public void setHoursWorked(double newHoursWorked){hoursWorked = newHoursWorked;}
	
	//****************************************************
	// Method: SetDate
	//
	//Purpose:  method that sets the new date
	//****************************************************
	public void setDate(Date new_Date) {newDate = new_Date;}
	
	//****************************************************// Method: Read 
	//Method: Write	
	//
	//Purpose: PrintStream that prints to a file.
	//****************************************************
	public void Write(PrintStream ps) 
	{
		ps.printf("%5d %6.2f ", id, hoursWorked);
		newDate.Write(ps);
	}
	
	//****************************************************
	// Method: Read 
	//		
	//Purpose:  Uses a Scanner to read in the employee info
	// 			Reads the employee id
	// 			Uses the Read() from Date to read in the date  
	//****************************************************
	public void Read(Scanner s){
		setId(s.nextInt());
		setHoursWorked(s.nextDouble());
		newDate.Read(s);
		}
}