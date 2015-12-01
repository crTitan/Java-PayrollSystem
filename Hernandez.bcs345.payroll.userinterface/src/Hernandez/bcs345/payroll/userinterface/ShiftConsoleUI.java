//****************************************************
// File: ShiftConsoleUI.java  
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

import Hernandez.bcs345.payroll.helperclasses.Date;
import Hernandez.bcs345payroll.employeedata.Shift;

public class ShiftConsoleUI {
	
	private Shift newShift = new Shift();
	private Date date = new Date(1, 2, 2001);
	private Scanner scanner = new Scanner(System.in);
	private int input = 0;

	public void ShowUserInterface() throws FileNotFoundException {

		do {
			System.out.print("Shift UI\n" + "--------\n" + "1 – Read in shift data from a file\n"
					+ "2 – Write shift data to a file\n" + "3 – Update id\n" + "4 – Update hours worked\n"
					+ "5 – Update date\n" + "6 – Write shift data to the screen\n" + "7 - Exit\n" + "Enter Choice: \n");

			input = scanner.nextInt();

			switch (input) {

			case 1:

				String inFileNme;

				System.out.println("Enter a file name: \n");

				inFileNme = scanner.nextLine();

				Scanner fileScanner = new Scanner(new File(inFileNme));

				newShift.Read(fileScanner);

				break;

			case 2:

				String outFileName;

				System.out.print("Enter a file name: \n");

				outFileName = scanner.nextLine();

				PrintStream fileOut = new PrintStream(new File(outFileName));
				
				newShift.Write(fileOut);
				
				break;

			case 3:

				System.out.print("Enter the worker Id: \n");

				newShift.setId(scanner.nextInt());

				break;

			case 4:

				System.out.print("Enter the hours worked: \n");

				newShift.setHoursWorked(scanner.nextDouble());

				break;

			case 5:

				System.out.print("Enter the new date: \n" + "Use the (dd mm yyyy) format\n");

				date.Read(scanner);

				newShift.setDate(date);

				break;

			case 6:

				PrintStream print2Screen = new PrintStream(System.out);

				newShift.Write(print2Screen);

				System.out.print('\n');

				break;

			case 7:

				System.out.print("You exited the Shift Console UI program!");

				break;

			default:

				System.out.print("That is an invalid entry!\n" + "Please enter a valid number or 7 to exit!\n");
				
				break;
			}

		} while (input != 7);

	}

}