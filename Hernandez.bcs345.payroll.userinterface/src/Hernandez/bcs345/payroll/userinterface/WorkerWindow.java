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

@SuppressWarnings("serial")
public class WorkerWindow extends JFrame{

	private Worker worker;
	private JLabel jLabel;
	private JTextField jTextField;
	private Scanner scanner;
	
	public WorkerWindow()
	{
		setSize(500,500);
		setTitle("BCS 345 - Paul Hernandez - Worker Data");	
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			
			scanner = new Scanner(new File("WorkerData.txt"));
			worker = new Worker();
			worker.Read(scanner);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		jLabel = new JLabel("Id");
		add(jLabel);
		
		Integer i = worker.getWorkerInfo().getId();
		jTextField = new JTextField(i.toString());
		add(jTextField);
		
		jLabel = new JLabel("First");
		add(jLabel);

		jTextField = new JTextField(worker.getWorkerInfo().getFirstName());
		add(jTextField);

		jLabel= new JLabel("Last");
		add(jLabel);
	
		jTextField = new JTextField(worker.getWorkerInfo().getLastName());
		add(jTextField);
		
		jLabel= new JLabel("State");
		add(jLabel);

		jTextField = new JTextField(worker.getWorkerInfo().getState());
		add(jTextField);

		jLabel= new JLabel("Hourly Rate");
		add(jLabel);
		
		String perHour = String.valueOf(worker.getWorkerInfo().getHourlyRate());
		jTextField = new JTextField(perHour);
		add(jTextField);

		GridLayout gl = new GridLayout(0, 2);
		setLayout(gl);
		
		scanner.close();
	}

}