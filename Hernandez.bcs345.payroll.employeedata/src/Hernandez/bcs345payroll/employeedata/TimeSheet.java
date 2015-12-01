//****************************************************
// File: TimeSheet.java  
//
// Purpose: Create a Shift Report.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/05/2014
//       
//****************************************************

package Hernandez.bcs345payroll.employeedata;

import java.io.PrintStream;
import java.util.Scanner;

import Hernandez.bcs345.payroll.helperclasses.Date;

public class TimeSheet {
	
	//member variables declaration
	public static int count;
	public	Shift[] newShift;
			
	//****************************************************
	// Method: TimeSheet
	//
	// Purpose: Default constructor w/ default values.
	//****************************************************
	public TimeSheet()
	{
		count =0;
		newShift = new Shift[0];
	}
	//****************************************************
	// Method: TimeSheet
	//
	// Purpose: Overloading constructor.
	//			Overloads the default values.
	//****************************************************
	public TimeSheet(int size)
	{
		int count = size;
		newShift= new Shift [count];
	}
	//****************************************************
	// Method: GetShiftById
	//
	// Purpose: Goes through the array to find the matching
	//			Id value.
	//			Returns the values in a new array.
	//			Uses a counter to determine the size of the array 
	//			Uses an index counter to assign the matching
	//			values to the new array
	//****************************************************
	public Shift[] GetShiftById(int id)
	{	
		int matches =0, nextAvailbleIndex =0;
		
		for (int i =0 ; i < newShift.length ; ++i )
		{
		  if (newShift[i].getId() == id)
		  {
			  matches++;
		  }
		}
		
		Shift[] Results = new Shift[matches];
		
		for (int k =0 ; k < newShift.length ; ++k )
		{
		  if (newShift[k].getId() == id)
		  {
			  Results[nextAvailbleIndex] = new Shift();
			  Results[nextAvailbleIndex] = newShift[k];
			  nextAvailbleIndex++;
		  }
		}
		return Results;
	}
	//****************************************************
	// Method: GetShiftByIndex
	//
	// Purpose: Goes through the array to find the matching
	//			index values.
	//			Returns the shift at the given index. 
	//			Return null if the index is invalid.
	//****************************************************
	public Shift GetShiftByIndex(int index)
	{
		Shift[] shiftIndex = new Shift [0];
		
		shiftIndex[0] = newShift[index];
		
		if (index >= newShift.length || index < 0 )
		{
			shiftIndex = null;
		}
		
		return shiftIndex[0];
		
	}
	//****************************************************
	// Method: ShiftReport
	//
	// Purpose: To print the values in the 
	//			array onto the screen.
	//			Uses a counter to keep track of the total hours worked
	//****************************************************
	public void ShiftReport(PrintStream ps)
	{
		
		
		ps.println("Shift Report");
		ps.println("------------");
		ps.printf("%4s %7s %5s %6s %7s", "Id", "Month", "Day", "Year", "Hours");
		ps.print("\n");
		ps.printf("%4s %7s %5s %6s %7s", "--", "-----", "---", "----", "-----");
		ps.print("\n");
		
		double totalHours=0;
		
		for (int i =0 ; i < count ; ++i)
		{
			ps.printf("%5d", newShift[i].getId());
			ps.printf("%5d",newShift[i].getDay());
			ps.printf("%7d",newShift[i].getMonth());
			ps.printf("%8d",newShift[i].getYear());
			ps.printf("%7.2f", newShift[i].getHoursWorked());
			ps.printf("\n");
			
			totalHours += newShift[i].getHoursWorked();
		}
		
		ps.printf("%4s", "--");
		ps.printf("%8s", "-----");
		ps.printf("%6s", "---");
		ps.printf("%7s", "----");
		ps.printf("%8s", "-----");
		ps.print("\n");
		ps.printf("%s", "Total");
		ps.printf("%28.2f", totalHours);
		
	}
	//****************************************************
	// Method: Write
	//
	// Purpose: To write out values in the array into a file.
	//****************************************************
	public void Write(PrintStream ps)
	{
		ps.printf("%d\n",count);
		
		for (int i = 0; i < count; ++i)
		{
			newShift[i].Write(ps);
			ps.printf("\n");
		}
	}
	
	//****************************************************
	// Method: Read
	//
	// Purpose: To read in the values into an array.
	//			Reads the counter to determine the number 
	//			of time it needs to run
	//****************************************************

	public void Read(Scanner s)
	{
		count = s.nextInt();
		newShift = new Shift[count];
		for (int i = 0; i < count; ++i)
		{
			newShift[i] = new Shift();
			newShift[i].Read(s);
		}
	}
}
	

