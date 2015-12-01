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

public class WorkerSwingUI {
	
	public void ShowUserInterface()
	{
		WorkerWindow workerWindow;
		
		workerWindow = new WorkerWindow();
		
		workerWindow.setVisible(true);
	}

}