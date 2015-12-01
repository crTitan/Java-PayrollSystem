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

	private int id;
	private double hourlyRate;
	private String firstName, state, lastName;

	public WorkerInfo() {
		id = 88;
		firstName = "FirstName";
		lastName = "LastName";
		state = "New Jersey York";
		hourlyRate = 8.55;

	}

	public WorkerInfo(int idNum, String fName, String workerState, String lName, double perHour) {
		id = idNum;
		firstName = fName;
		lastName = lName;
		state = workerState;
		hourlyRate = perHour;

	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getState() {
		return state;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setId(int newId) {
		id = newId;
	}

	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	}

	public void setLastName(String newLastName) {
		lastName = newLastName;
	}

	public void setState(String newState) {
		state = newState;
	}

	public void setHourlyRate(double newHourlyRate) {
		hourlyRate = newHourlyRate;
	}

	public void Write(PrintStream ps) {
		ps.println(getId() + "\n" + getFirstName() + "\n" + getLastName() + "\n" + getState() + "\n" + getHourlyRate());
	}

	public void Read(Scanner s) {
		
		setId(s.nextInt());
		
		setFirstName(s.next());
		
		setLastName(s.next());
		
		setState(s.next());
		
		setHourlyRate(s.nextDouble());
	}
}