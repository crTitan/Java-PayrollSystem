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
	@SuppressWarnings("unused")
	private String dummyVar;
	private Scanner fileScanner;

	public void ShowUserInterface() {

		do {
			System.out.print("Shift UI\n" + "--------\n" + "1 – Read in shift data from a file\n"
					+ "2 – Write shift data to a file\n" + "3 – Update id\n" + "4 – Update hours worked\n"
					+ "5 – Update date\n" + "6 – Write shift data to the screen\n" + "7 - Exit\n" + "Enter Choice: \n");

			input = scanner.nextInt();

			switch (input) {

			case 1:

				String inFileName;
									
				System.out.println("Enter a file name:");
				
				//consumes the \n from nextInt()
				dummyVar = scanner.nextLine();
				
				inFileName = scanner.nextLine();
				
				try {
					
					fileScanner = new Scanner(new File(inFileName));
					newShift.Read(fileScanner);
					
				} catch (FileNotFoundException e) {
				
					System.out.println("Could not fine file " + inFileName);
				}

				break;

			case 2:

				String outFileName;

				System.out.println("Enter a file name:");

				//consumes the \n from nextInt()
				dummyVar = scanner.nextLine();
				
				outFileName = scanner.nextLine();

				PrintStream fileOut;
				
				try {
					
					fileOut = new PrintStream(new File(outFileName));
					newShift.Write(fileOut);
					
				} catch (FileNotFoundException e) {

					System.out.println("Could not find file " + outFileName);
				}
							
				break;

			case 3:

				System.out.println("Enter the worker Id:");

				newShift.setId(scanner.nextInt());

				break;

			case 4:

				System.out.println("Enter the hours worked:");

				newShift.setHoursWorked(scanner.nextDouble());

				break;

			case 5:

				System.out.println("Enter the new date: \n" + "Use the (mm  dd yyyy) format");

				date.Read(scanner);

				newShift.setDate(date);

				break;

			case 6:

				PrintStream print2Screen = new PrintStream(System.out);

				System.out.println("Id  Hours  Month  Day   Year");
				
				newShift.Write(print2Screen);

				System.out.print('\n');

				break;

			case 7:

				System.out.println("You exited the Shift Console UI program!");
						
				break;

			default:

				System.out.println("That is an invalid entry!\n" + "Please enter a valid number or 7 to exit!");
				
				break;
			}

		} while (input != 7);

	}

}