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

	private WorkerInfo workerInfo;
	private TimeSheet timseSheet;

	public Worker() {
		workerInfo = new WorkerInfo();
		timseSheet = new TimeSheet();
	}

	public WorkerInfo getWorkerInfo() {
		return workerInfo;
	}

	public TimeSheet getTimeSheet() {
		return timseSheet;
	}

	public void Report(PrintStream ps) {
		ps.printf("WorkerInfo Report\n");
		ps.printf("-----------------\n");
		ps.printf("Id: %12d \n", workerInfo.getId());
		ps.printf("First: %11s \n", workerInfo.getFirstName());
		ps.printf("Last: %12s \n", workerInfo.getLastName());
		ps.printf("State: %8s \n", workerInfo.getState());
		ps.printf("Hourly Rate: %5.2f \n", workerInfo.getHourlyRate());
		ps.printf("\n");
		timseSheet.ShiftReport(ps);
		ps.close();

	}

	public void Write(PrintStream ps) {
		workerInfo.Write(ps);
		timseSheet.Write(ps);
	}

	public void Read(Scanner s) {
		workerInfo.Read(s);
		timseSheet.Read(s);
	}
}