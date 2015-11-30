//****************************************************
// File: WorkerInfo.java  
//
// Purpose: Stores worker information.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/12/2014
//       
//****************************************************

package Hernandez.bcs345payroll.employeedata;

import java.io.PrintStream;
import java.util.Scanner;

public class WorkerInfo {

	//private class members
	private int id;
	double hourlyRate;
	private String firstName, state, lastName;
	
	//****************************************************
	// Method:  WorkerInfo
	//
	// Purpose:  Default constructor w/ default values
	//****************************************************
	public WorkerInfo()
	{
		id = 88;
		firstName = "FirstName";
		lastName = "LastName";
		state = "New Jersey York";
		hourlyRate = 8.55;
		
	}
	
	//****************************************************
	// Method:  WorkerInfo
	//
	// Purpose:  Overloading Constructor.
	//			 Overloads the values of the member variables
	//****************************************************
	public WorkerInfo(int idNum, String fName, String workerState, String lName, double perHour)
	{
		id = idNum;
		firstName = fName;
		lastName = lName;
		state = workerState;
		hourlyRate = perHour;
		
	}
	
	//****************************************************
	// Method:  getId
	//
	// Purpose:  returns the id
	//****************************************************
	public int getId(){return id;}

	//****************************************************
	// Method:  getFirstName
	//
	// Purpose:  returns the first name
	//****************************************************
	public String getFirstName(){return firstName;}

	//****************************************************
	// Method:  getLastName
	//
	// Purpose:  returns the last name
	//****************************************************
	public String getLastName(){return lastName;}
	
	//****************************************************
	// Method:  getState
	//
	// Purpose:  returns the State
	//****************************************************
	public String getState(){return state;}

	//****************************************************
	// Method:  getHourlyRate
	//
	// Purpose:  returns the hourly rate
	//****************************************************
	public double getHourlyRate(){return hourlyRate;}
	
	//****************************************************
	// Method:  setId
	//
	// Purpose:  sets the id
	//****************************************************
	public void setId(int newId){id = newId;}
	
	//****************************************************
	// Method:  setFirstName
	//
	// Purpose:  sets the first name
	//****************************************************
	public void setFirstName(String newFirstName){firstName = newFirstName;}
	
	//****************************************************
	// Method:  setLastName
	//
	// Purpose:  sets the last name
	//****************************************************
	public void setLastName(String newLastName){lastName = newLastName;}
	
	//****************************************************
	// Method:  setState
	//
	// Purpose:  sets the State
	//****************************************************
	public void setState(String newState){state = newState;}
	
	//****************************************************
	// Method:  setHourlyRate
	//
	// Purpose:  sets the hourly rate
	//****************************************************
	public void setHourlyRate(double newHourlyRate){hourlyRate = newHourlyRate;}
	
	//****************************************************
	// Method:  Write
	//
	// Purpose:  Writes out the member variables to a PrintStream
	//****************************************************
	public void Write(PrintStream ps)
	{
		ps.println(getId()  + "\n" + getFirstName() + "\n" + getLastName() + "\n" + getState() + "\n" + getHourlyRate());
	}
	
	//****************************************************
	// Method:  Read
	//
	// Purpose:  Reads in the values for the member variables
	//****************************************************
	public void Read(Scanner s){
		setId(s.nextInt());
		setFirstName(s.next());
		setLastName(s.next());
		setState(s.next());
		setHourlyRate(s.nextDouble());
	}
}