//****************************************************
// File: TimeSheetConsoleUI.java  
//
// Purpose: Create a Shift Report.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/05/2014
//       
//****************************************************

package Hernandez.bcs345.payroll.userinterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import Hernandez.bcs345payroll.employeedata.Shift;
import Hernandez.bcs345payroll.employeedata.TimeSheet;

public class TimeSheetConsoleUI {

	private TimeSheet newTimeSheet = new TimeSheet();
	private int userInput;
	private Scanner scanner = new Scanner(System.in);

	public void ShowUserInterface() {

		do {
			System.out.print("TimeSheet UI\n" + "--------\n" + "1 – Read time sheet from file\n"
					+ "2 – Write time sheet to file\n" + "3 – Show all shift elements for an id\n"
					+ "4 – Show shift report on screen\n" + "5 – Exit\n" + "Enter Choice: \n");

			userInput = scanner.nextInt();

			switch (userInput) {

			case 1:

				String inFileName;

				System.out.println("Enter a file name: \n");

				inFileName = scanner.nextLine();

				Scanner fileScanner;

				try {
					fileScanner = new Scanner(new File(inFileName));

					newTimeSheet.Read(fileScanner);
				}

				catch (FileNotFoundException e) {

					System.out.println("File " + inFileName + " could not be found!");
				}

				break;

			case 2:

				String outFileName;

				System.out.print("Enter a file name: \n");

				outFileName = scanner.nextLine();

				PrintStream fileOut;

				try {
					fileOut = new PrintStream(new File(outFileName));

					newTimeSheet.Write(fileOut);

				} catch (FileNotFoundException e) {

					System.out.print("The output file " + outFileName + " could not be created");
				}

				break;

			case 3:

				System.out.print("Enter the worker Id: \n");

				//TODO what is being store here
				Shift[] x;
				x = newTimeSheet.GetShiftById(scanner.nextInt());

				PrintStream ps = new PrintStream(System.out);

				ps.println("Shift Report");
				ps.println("------------");
				ps.printf("%4s %7s %5s %6s %7s", "Id", "Month", "Day", "Year", "Hours");
				ps.print('\n');
				ps.printf("%4s %7s %5s %6s %7s", "--", "-----", "---", "----", "-----");
				ps.print('\n');

				for (int i = 0; i < x.length; i++)
				{
					//TODO figure out what is inside here
					x[i].Write(ps);					
					System.out.print('\n');
				}

				break;

			case 4:

				PrintStream print2Screen = new PrintStream(System.out);

				newTimeSheet.ShiftReport(print2Screen);

				System.out.print('\n');

				break;

			case 5:

				System.out.print("You exited the TimeSheet UI program!");

				break;

			default:

				System.out.print("That is an invalid entry!\n" + "Please enter a valid number or 5 to exit!\n");

				break;
			}

		} while (userInput != 5);

	}

}
