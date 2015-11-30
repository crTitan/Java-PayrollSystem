//****************************************************
// File: Worker.java  
//
// Purpose: Creates a Worker.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/12/2014
//       
//****************************************************

package Hernandez.bcs345payroll.employeedata;

import java.io.PrintStream;
import java.util.Scanner;

import Hernandez.bcs345payroll.employeedata.TimeSheet;
import Hernandez.bcs345payroll.employeedata.WorkerInfo;

public class Worker {

	//class member variables
	WorkerInfo WI;
	TimeSheet TS;
	
	//****************************************************
	// Method:  Worker
	//
	// Purpose:  Default constructor that sets default values
	//****************************************************
	public Worker()
	{
		WI = new WorkerInfo();
		TS = new TimeSheet();
	}
	
	//****************************************************
	// Method:  getWorkerInfo
	//
	// Purpose:  get method that returns the Worker info.
	//****************************************************
	public WorkerInfo getWorkerInfo(){return WI;}
	
	//****************************************************
	// Method:  getTimeSheet
	//
	// Purpose:  get method that returns the TimeSheet info.
	//****************************************************
	public TimeSheet getTimeSheet(){return TS;}
	
	//****************************************************
	// Method:  Report
	//
	// Purpose:  Writes the info to the screen
	//****************************************************
	public void Report(PrintStream ps){
	ps.printf("WorkerInfo Report\n");
	ps.printf("-----------------\n");
	ps.printf("Id: %12d \n" , WI.getId());
	ps.printf("First: %11s \n" , WI.getFirstName());
	ps.printf("Last: %12s \n" , WI.getLastName());
	ps.printf("State: %8s \n" , WI.getState());
	ps.printf("Hourly Rate: %5.2f \n" , WI.getHourlyRate());
	ps.printf("\n");
	TS.ShiftReport(ps);
	ps.close();
	
	}
	//****************************************************
	// Method:  Write
	//
	// Purpose:  Writes the info to a file
	//****************************************************
	public void Write(PrintStream ps){WI.Write(ps);TS.Write(ps);}
	
	//****************************************************
	// Method:  Read
	//
	// Purpose:  Read the info from a file
	//****************************************************
	public void Read(Scanner s){WI.Read(s);TS.Read(s);}
}