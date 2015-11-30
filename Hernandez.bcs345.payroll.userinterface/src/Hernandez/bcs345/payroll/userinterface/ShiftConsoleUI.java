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

	public void ShowUserInterface() throws FileNotFoundException 
	{
		//****************************************************
		// Purpose:  creates and initializes a new instances
		//           of Shift and Date classes
		//****************************************************
		Shift newShift = new Shift();
		Date date = new Date(1, 2, 2001);
		
		//****************************************************
		// Purpose:  prints the menu to the screen
		//****************************************************
		System.out.print("Shift UI\n"
				+"--------\n"
				+"1 – Read in shift data from a file\n"
				+"2 – Write shift data to a file\n"
				+"3 – Update id\n"
				+"4 – Update hours worked\n"
				+"5 – Update date\n"
				+"6 – Write shift data to the screen\n"
				+"7 - Exit\n"
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
			while (userInput < 1 || userInput > 7 )
			{
				
				System.out.print("That is an invalid entry!\n");
				System.out.print("Please enter a valid number or 7 to exit!\n");
				Scanner ctrlScanner2 = new Scanner (System.in);
				userInput  = ctrlScanner2.nextInt();
				
				if (userInput == 7){break;}
			}
			
			//****************************************************
			// Purpose:  if the user input equals 1, the program
			//			 reads the values from a file.
			//****************************************************
			if (userInput == 1)
			{	
				String inFileNme;
					
				Scanner newS = new Scanner(System.in);
				
				System.out.println("Enter a file name: \n");
				
				inFileNme = newS.nextLine();

				Scanner fileScnnr = new Scanner(new File(inFileNme));
 
				newShift.Read(fileScnnr);
			}
			
			//****************************************************
			// Purpose:  if the user input equals 2, the program
			//			 write the values to a file.
			//****************************************************
			if (userInput == 2)
			{	
				String outFileNme;
				
				Scanner fileScnnr = new Scanner(System.in);

				System.out.print("Enter a file name: \n");

				outFileNme = fileScnnr.nextLine();
										
				PrintStream fileOut = new PrintStream(new File(outFileNme));
				newShift.Write(fileOut);
			}
			
			//****************************************************
			// Purpose:  if the user input equals 3, the program
			//			 uses the user input to update the id value
			//****************************************************
			if (userInput == 3)
			{				
				System.out.print("Enter the worker Id: \n");
				Scanner ScannerFour = new Scanner(System.in);
				newShift.setId(ScannerFour.nextInt());
			}
			
			//****************************************************
			// Purpose:  if the user input equals 4, the program
			//			 uses the user input to update the
			// 			 hours worked value
			//****************************************************
			if (userInput == 4)
			{	
				System.out.print("Enter the hours worked: \n");
				Scanner ScannerFive = new Scanner(System.in);
				newShift.setHoursWorked(ScannerFive.nextDouble());
			}
			
			//****************************************************
			// Purpose:  if the user input equals 5, the program
			//			 uses the user input to update the
			// 			 date value
			//****************************************************
			if (userInput == 5)
			{	
				System.out.print("Enter the new date: \n");
				Scanner ScannerSix = new Scanner(System.in);
				date.Read(ScannerSix);
				newShift.setDate(date);
			}
			
			//****************************************************
			// Purpose:  if the user input equals 6, the program
			//			 the member variable values to the screen
			//****************************************************
			if (userInput == 6)
			{	 
				PrintStream print2Screen = new PrintStream(System.out);
				 
				newShift.Write(print2Screen);
				System.out.print("\n");
			}
			
			//****************************************************
			// Purpose:  if the user input equals 7, the program
			//			 breaks out of the loop exits the UI
			//****************************************************
			if (userInput == 7)
			{
				System.out.print("You exited the Shift Console UI program!");
				break;
			}
				
			//****************************************************
			// Purpose:  prints the menu to the screen
			//****************************************************
			System.out.print("\nShift UI\n"
					+"--------\n"
					+"1 – Read in shift data from a file\n"
					+"2 – Write shift data to a file\n"
					+"3 – Update id\n"
					+"4 – Update hours worked\n"
					+"5 – Update date\n"
					+"6 – Write shift data to the screen\n"
					+"7 - Exit\n"
					+"Enter Choice: \n");
		
			//****************************************************
			// Purpose:  creates a new Scanner variable to store the user input
			//****************************************************
			Scanner ctrlScanner = new Scanner (System.in);//new scanner
			userInput  = ctrlScanner.nextInt();
			
			//****************************************************
			// Purpose:  checks that the value entered is a valid.
			//			 if not valid, then it asks the user 
			//			 to reenter a value until a valid choice
			//			 is entered
			//****************************************************
			while (userInput < 1 || userInput > 7 )
			{	
				System.out.print("That is an invalid entry!\n");
			 
				System.out.print("Please enter a valid number or 7 to exit!\n");
				
				//****************************************************
				// Purpose:  creates a new Scanner variable to store the user input
				//****************************************************
				Scanner ctrlScanner2 = new Scanner (System.in);
				userInput  = ctrlScanner2.nextInt();
				
				if (userInput == 7){break;}
				
			}//end while
		}//while
	}//method
}//class