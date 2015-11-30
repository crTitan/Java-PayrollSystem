//****************************************************
// File: WorkerWindow.java  
//
// Purpose: Creates a WorkerWindow window.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/12/2014
//       
//****************************************************

package Hernandez.bcs345.payroll.userinterface;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Hernandez.bcs345payroll.employeedata.Worker;

public class WorkerWindow extends JFrame{

	//class member variables
	Worker newW;
	JLabel Jl1;
	JTextField JTF1;
	
	//****************************************************
	//Method:  WorkerWindow
	//
	// Purpose:  Constructor that contains the definition
	//			 to create the window and the different
	//			 methods
	//****************************************************
	public WorkerWindow() throws FileNotFoundException
	{
		//****************************************************
		//Initializes the worker instance
		//****************************************************
		newW = new Worker();
		
		//****************************************************
		//New scanner instance. Looks for a file to read from
		//****************************************************
		Scanner sc;
		sc = new Scanner(new File("WorkerData.txt"));
		
		//****************************************************
		//Reads the info from the file
		//****************************************************
		newW.Read(sc);
		
		//****************************************************
		//Sets the window size for employee swing
		//****************************************************
		setSize(500,500);
	
		//****************************************************
		//Sets the window title
		//****************************************************
		setTitle("BCS 345 - Paul Hernandez - Worker Data");	
		
		//****************************************************
		//Closes the program upon closing the window
		//****************************************************
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//****************************************************
		//Allocates new memory for the JLabel variable
		//Passes some string to JLabel constructor
		//Adds the variable to the window
		//****************************************************
		Jl1 = new JLabel("Id");
		add(Jl1);
		
		//****************************************************
		//the i String stores a converted version of the int
		//stored in the WorkerInfor Class.
		//Then in the itoString(); is passed as a parameter
		//Allocates new memory for the JTextField variable
		//Adds the variable to the window
		//****************************************************
		Integer i = newW.getWorkerInfo().getId();
		JTF1 = new JTextField(i.toString());
		add(JTF1);
		
		//****************************************************
		//Allocates new memory for the JLabel variable
		//Passes some string to JLabel constructor
		//Adds the variable to the window
		//****************************************************
		Jl1 = new JLabel("First");
		add(Jl1);

		//****************************************************
		//Allocates new memory for the JTextField variable
		//Gets the data stored in the WorkerInfor Class
		//Adds the variable to the window
		//****************************************************
		JTF1 = new JTextField(newW.getWorkerInfo().getFirstName());
		add(JTF1);
		
		//****************************************************
		//Allocates new memory for the JLabel variable
		//Passes some string to JLabel constructor
		//Adds it to the window
		//****************************************************
		Jl1= new JLabel("Last");
		add(Jl1);
		
		//****************************************************
		//Allocates new memory for the JTextField variable
		//Gets the data stored in the WorkerInfor Class
		//Adds the variable to the window
		//****************************************************
		JTF1 = new JTextField(newW.getWorkerInfo().getLastName());
		add(JTF1);
		
		//****************************************************
		//Allocates new memory for the JLabel variable
		//Passes some string to JLabel constructor
		//Adds it to the window
		//****************************************************
		Jl1= new JLabel("State");
		add(Jl1);
		
		//****************************************************
		//Allocates new memory for the JTextField variable
		//Gets the data stored in the WorkerInfor Class
		//Adds the variable to the window
		//****************************************************
		JTF1 = new JTextField(newW.getWorkerInfo().getState());
		add(JTF1);
		
		//****************************************************
		//Allocates new memory for the JLabel variable
		//Passes some string to JLabel constructor
		//Adds the variable to the window
		//****************************************************
		Jl1= new JLabel("Hourly Rate");
		add(Jl1);
		
		//****************************************************
		//the perHour String store a converted version of the
		//double stored in the WorkerInfor Class.
		//The perHour variable is then passed as a parameter.
		//Allocates new memory for the JTextField variable
		//Adds the variable to the window
		//****************************************************
		String perHour = String.valueOf(newW.getWorkerInfo().getHourlyRate());
		JTF1 = new JTextField(perHour);
		add(JTF1);
		
		//****************************************************
		//Creates and initializes a new GridLaout with zero
		//rows and two columns
		//****************************************************
		GridLayout gl = new GridLayout(0, 2);
		setLayout(gl);	
	}
}