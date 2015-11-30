//****************************************************
// File: WorkerSwingUI.java  
//
// Purpose: Instantiates a WorkerWindow window.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 11/12/2014
//       
//****************************************************

package Hernandez.bcs345.payroll.userinterface;

import java.io.FileNotFoundException;

public class WorkerSwingUI {
	
	public void ShowUserInterface() throws FileNotFoundException
	{
		//****************************************************
		//Declares a new Window
		//****************************************************
		WorkerWindow win;
		
		
		//****************************************************
		//Creates a new instance a new Window
		//****************************************************
		win = new WorkerWindow();
		
		//****************************************************
		//Sets visibility to true
		//****************************************************
		win.setVisible(true);
	}

}