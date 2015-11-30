//****************************************************
// File: Main.java  
//
// Purpose: Main program that instantiates the UIs.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/05/2014
//       
//****************************************************

package Hernandez.bcs345.payroll.userinterface;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Hernandez.bcs345.payroll.userinterface.ShiftConsoleUI;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//****************************************************
		//Initial print of the UI menu
		//****************************************************
		System.out.println("Choose UI\n"
				+"---------\n"
				+"1 – Shift UI\n"
				+"2 – TimeSheet UI\n"
				+"3 – Worker Swing UI\n"
				+"4 – Worker Advanced Swing UI\n"
				+"5 - Exit\n"
				+"Enter Choice:");
		
		int mainInput=0;
		Scanner scnner= new Scanner(System.in);
		mainInput = scnner.nextInt();
		
		//****************************************************
		//While loop that instantiates the different UI's
		//Runs until the user enters a valid choice or a exit value
		//****************************************************
		while (true)
		{
			while(mainInput < 1 || mainInput > 5)
			{
				System.out.println("Please enter a valid choise or 5 to exit the program");
				
				System.out.println("\nChoose UI\n"
						+"---------\n"
						+"1 – Shift UI\n"
						+"2 – TimeSheet UI\n"
						+"3 – Worker Swing UI\n"
						+"4 – Worker Advanced Swing UI\n"
						+"5 - Exit\n"
						+"Enter Choice:");
				mainInput = scnner.nextInt();
			}//end while
			
			if (mainInput == 1)
			{
				ShiftConsoleUI userUI = new ShiftConsoleUI();//creates and initializes a new instance of the class
				userUI.ShowUserInterface();//calls the method
			}
			
			if(mainInput == 2)
			{
				TimeSheetConsoleUI timeSheet = new TimeSheetConsoleUI();//creates and initializes a new instance of the class
				timeSheet.ShowUserInterface();//calls the method
			}
			
			if(mainInput == 3)
			{
				WorkerSwingUI WSUI = new WorkerSwingUI();//creates and initializes a new instance of the class
				WSUI.ShowUserInterface();//calls the method
			}
			
			if(mainInput == 4)
			{
				WorkerAdvancedSwingUI AncdWorkerdSwingUI = new WorkerAdvancedSwingUI();//creates and initializes a new instance of the class
				AncdWorkerdSwingUI.ShowUserInterface();//calls the method
			}
						
			if (mainInput == 5){System.out.println("You have exited the program!");scnner.close();break;}
					
			System.out.println("\nChoose UI\n"
					+"---------\n"
					+"1 – Shift UI\n"
					+"2 – TimeSheet UI\n"
					+"3 – Worker Swing UI\n"
					+"4 – Worker Advanced Swing UI\n"
					+"5 - Exit\n"
					+"Enter Choice:");
			mainInput = scnner.nextInt();
		}//end while
	}//end main
}//end class