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

import Hernandez.bcs345.payroll.helperclasses.Date;
import Hernandez.bcs345payroll.employeedata.Shift;
import Hernandez.bcs345payroll.employeedata.TimeSheet;

public class TimeSheetConsoleUI {
	
	public void ShowUserInterface()
	{
		//****************************************************
		// Purpose:  creates and initializes a new instances
		//           of Shift and Date classes
		//****************************************************
		TimeSheet newTimeSheet = new TimeSheet();
		Date date = new Date(1, 2, 2001);
			
		//****************************************************
		// Purpose:  prints the menu to the screen
		//****************************************************
		System.out.print("TimeSheet UI\n"
				+"--------\n"
				+"1 – Read time sheet from file\n"
				+"2 – Write time sheet to file\n"
				+"3 – Show all shift elements for an id\n"
				+"4 – Show shift report on screen\n"
				+"5 – Exit\n"
				+"Enter Choice: \n");
		
		//****************************************************
		// Purpose:  creates a new Scanner variable to store the user input
		//****************************************************
		int userInput;
		Scanner ScannerZero = new Scanner(System.in);
		userInput = ScannerZero.nextInt();
		
		//****************************************************
		// Purpose:  while loop executes indefinitely unless 
		//			 the user enters 7, which exits the program
		//****************************************************
		while (true){
			
			//****************************************************
			// Purpose:  checks that the initial value is a valid.
			//			 if not valid, then it asks the user 
			//			 to reenter a value until a valid choice
			//			 is entered
			//****************************************************
			while (userInput < 1 || userInput > 5 )
			{
				System.out.print("That is an invalid entry!\n");
			
				System.out.print("Please enter a valid number or 5 to exit!\n");
			
				Scanner ctrlScanner2 = new Scanner (System.in);
				userInput  = ctrlScanner2.nextInt();
				
				if (userInput == 5){break;}
			}
			
			//****************************************************
			// Purpose:  if the user input equals 1, the program
			//			 reads the values from a file.
			//			 Uses a Try Catch statement to make sure that
			//			 the file exist
			//****************************************************
			if (userInput == 1)
			{	
				String inFileNme;
					
				Scanner newS = new Scanner(System.in);
			
				System.out.println("Enter a file name: \n");

				inFileNme = newS.nextLine();
		
				Scanner fileScnnr;
				
				try 
				{
					fileScnnr = new Scanner(new File(inFileNme));
			
					newTimeSheet.Read(fileScnnr);
				}
				
				catch (FileNotFoundException inputFile)
				{
					System.out.println("The file could not be found!");
				}	
			}
			
			//****************************************************
			// Purpose:  if the user input equals 2, the program
			//			 writes the array values to a file.
			//			 Uses a Try Catch to handle the file
			//			 not found exception
			//****************************************************
			if (userInput == 2)
			{	
				String outFileNme;
					
				Scanner fileScnnr = new Scanner(System.in);
				
				System.out.print("Enter a file name: \n");
				
				outFileNme = fileScnnr.nextLine();
										
				PrintStream fileOut;
				try 
				{
					fileOut = new PrintStream(new File(outFileNme));
					newTimeSheet.Write(fileOut);//write the data to the file, using the write method
				} 
				catch (FileNotFoundException e)
				{
					System.out.print("The output file could not be created");
				}
				
			}	
			
			//****************************************************
			// Purpose:  if the user input equals 3, the program
			//			 uses the user input to locate all the
			//			 matching Id's and returns them in a 
			//			 new array, then prints them out to the screen
			//****************************************************
			if (userInput == 3)
			{				
				System.out.print("Enter the worker Id: \n");//user prompt
				Scanner ScannerFour = new Scanner(System.in);//new scanner
				Shift[] x;
				x = newTimeSheet.GetShiftById(ScannerFour.nextInt());
				
				PrintStream newPS = new PrintStream(System.out);
				
				newPS.println("Shift Report");
				newPS.println("------------");
				newPS.printf("%4s %7s %5s %6s %7s", "Id", "Month", "Day", "Year", "Hours");
				newPS.print("\n");
				newPS.printf("%4s %7s %5s %6s %7s", "--", "-----", "---", "----", "-----");
				newPS.print("\n");
				
				for (int i =0; i < x.length; i++)
				{
					x[i].Write(newPS);
					System.out.print("\n");
				}
			}
						
			//****************************************************
			// Purpose:  if the user input equals 4, the program
			//			 the write a Shift Report to the screen
			//****************************************************
			if (userInput == 4)
			{	
				PrintStream print2Screen = new PrintStream(System.out);
				
				newTimeSheet.ShiftReport(print2Screen);
				System.out.print("\n");
			}
			
			//****************************************************
			// Purpose:  if the user input equals 7, the program
			//			 breaks out of the loop exits the UI
			//****************************************************
			if (userInput == 5)
			{
				System.out.print("You exited the TimeSheet UI program!");
				break;
			}
				
			//****************************************************
			// Purpose:  prints the menu to the screen
			//****************************************************
			System.out.print("\nTimeSheet UI\n"
					+"--------\n"
					+"1 – Read time sheet from file\n"
					+"2 – Write time sheet to file\n"
					+"3 – Show all shift elements for an id\n"
					+"4 – Show shift report on screen\n"
					+"5 – Exit\n"
					+"Enter Choice: \n");
		
			//****************************************************
			// Purpose:  creates a new Scanner variable to store the user input
			//****************************************************
			Scanner ctrlScanner = new Scanner (System.in);//new scanner
			userInput  = ctrlScanner.nextInt();//user input
			
			//****************************************************
			// Purpose:  checks that the value entered is a valid.
			//			 if not valid, then it asks the user 
			//			 to reenter a value until a valid choice
			//			 is entered
			//****************************************************
			while (userInput < 1 || userInput > 5 )
			{	
				System.out.print("That is an invalid entry!\n");
				
				System.out.print("Please enter a valid number or 5 to exit!\n");
				
				//****************************************************
				// Purpose:  creates a new Scanner variable to store the user input
				//****************************************************
				Scanner ctrlScanner2 = new Scanner (System.in);//new scanner
				userInput  = ctrlScanner2.nextInt();//gets the actual input
				
				if (userInput == 5){break;}//breaks out of the loop if the user enters 7	
			}//end while
		}//while
	}//method
}//end class
