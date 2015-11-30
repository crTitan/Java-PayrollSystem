//****************************************************
// File: WorkerAdvancedSwingUI.java  
//
// Purpose: Instantiates an Advance WorkerWindow window.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 12/1/2014
//       
//****************************************************

package Hernandez.bcs345.payroll.userinterface;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class WorkerAdvancedSwingUI extends JFrame{

	public void ShowUserInterface()
	{
		//Creates a new instance of the WorkerAdvancedWindow
		WorkerAdvancedWindow newAdnceWorker;
		
		//Initializes the WorkerAdvancedWindow
		newAdnceWorker = new WorkerAdvancedWindow();
		
		//Sets the visibility to true
		newAdnceWorker.setVisible(true);	
		}
}
