//****************************************************
// File: WorkerAdvancedWindow.java  
//
// Purpose: Creates an Advance WorkerWindow window.
//
// Written By: Paul A. Rodriguez Hernandez
//
// Date: 12/1/2014
//       
//****************************************************

package Hernandez.bcs345.payroll.userinterface;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Hernandez.bcs345payroll.employeedata.TimeSheet;
import Hernandez.bcs345payroll.employeedata.Worker;

@SuppressWarnings("serial")
public class WorkerAdvancedWindow extends JFrame implements ActionListener{
	
	//class variables
	private Worker worker;
	private TimeSheet timeSheet;
	private JTabbedPane myTabbedPane;
	private JLabel jLabel;
	private JTextField textFieldId,textFieldFirst,textFieldLast,textFieldState,textFieldHourlyRate;
	private JList<String> shiftList;
	private DefaultListModel<String> listModel;
	
	public WorkerAdvancedWindow()
	{
		setTitle("PayRoll System");
		setSize(800,800);
		
		worker = new Worker();
		timeSheet = new TimeSheet();
		
		JMenuBar newBar = new JMenuBar();
		JMenu menu =  new JMenu("Menu");
		newBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open..."); 
		menu.add(openItem);
		
		openItem.addActionListener(this);

		menu.add(new JSeparator());
		
		JMenuItem saveAsItem = new JMenuItem("Save As..."); 
		menu.add(saveAsItem);

		saveAsItem.addActionListener(this);
	
		menu.add(new JSeparator());
	
		JMenuItem reportItem = new JMenuItem("Report..."); 
		menu.add(reportItem);

		reportItem.addActionListener(this);
		
		menu.add(new JSeparator());
		
		JMenuItem exitItem = new JMenuItem("Exit"); 
		menu.add(exitItem);
		
		exitItem.addActionListener(this);
				
		this.setJMenuBar(newBar);

		myTabbedPane = new JTabbedPane();
		add(myTabbedPane);
		
		JPanel panelOne;
		panelOne =new JPanel();
	
		panelOne.setBackground(Color.LIGHT_GRAY);
		
		jLabel = new JLabel("Id");
		panelOne.add(jLabel);

		Integer i = worker.getWorkerInfo().getId();

		panelOne.add(textFieldId = new JTextField(i.toString()));
		
		panelOne.add(jLabel =new JLabel("First"));
	
		panelOne.add(textFieldFirst = new JTextField(worker.getWorkerInfo().getFirstName()));
	
		panelOne.add(jLabel =new JLabel("Last"));
	
		panelOne.add(textFieldLast = new JTextField(worker.getWorkerInfo().getLastName()));
	
		panelOne.add(jLabel =new JLabel("State"));

		panelOne.add(textFieldState = new JTextField(worker.getWorkerInfo().getState()));

		panelOne.add(jLabel =new JLabel("Hourly Rate"));

		String perHour = String.valueOf(worker.getWorkerInfo().getHourlyRate());
		textFieldHourlyRate = new JTextField(perHour);
		
		panelOne.add(textFieldHourlyRate);

		panelOne.setLayout(new GridLayout(0,2));

		myTabbedPane.addTab("Worker Information", panelOne);
		
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(Color.LIGHT_GRAY);
		
		listModel = new DefaultListModel<String>();
		
        shiftList = new JList<String>(listModel);
  
		panelTwo.add(shiftList);
				
		myTabbedPane.addTab("Time Sheet", panelTwo);
		
	}//end constructor	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Menu items
		if (e.getSource() instanceof JMenuItem)
		{
			String arg = e.getActionCommand();
			if (arg.equals("Open..."))
			{
				//Declaration and initialization of a JFileChooser
				JFileChooser fileChooser;
				fileChooser = new JFileChooser();
				
				if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
				{
					//new String that stores the file path 
					String selectedFile = fileChooser.getSelectedFile().getPath();					
					
					//Scanner declaration
					Scanner fileScanner;
					
					try 
					{
						//new Scanner ins
						fileScanner = new Scanner(new File (selectedFile));
						
						//reads the information in from the file
						worker.Read(fileScanner);
						
						//sets the new id to the JTextField Variable
						Integer i = worker.getWorkerInfo().getId();
						textFieldId.setText(i.toString());
						
						//sets the new first name to the JTextField Variable
						textFieldFirst.setText(worker.getWorkerInfo().getFirstName());
						
						//sets the new last name to the JTextField Variable
						textFieldLast.setText(worker.getWorkerInfo().getLastName());

						//sets the new State to the JTextField Variable
						textFieldState .setText(worker.getWorkerInfo().getState());
						
						//sets the new hourly rate to the JTextField Variable
						String perHour = String.valueOf(worker.getWorkerInfo().getHourlyRate());
						textFieldHourlyRate.setText(perHour);
										
						//For loop that sets the listModel elements to the worker shift info
						for(int j = 0; j < worker.getTimeSheet().count; j++ )
						{
							listModel.addElement(worker.getWorkerInfo().getId() + " "
							+ worker.getTimeSheet().newShift[j].getHoursWorked() + " "
							+ worker.getTimeSheet().newShift[j].getDate().getMonth() + " "
							+ worker.getTimeSheet().newShift[j].getDate().getDay() + " "
							+ worker.getTimeSheet().newShift[j].getDate().getYear());
						}
					} catch (FileNotFoundException ex) 
					{
						System.out.print("The File could not be loaded");
					}
				}
			}
			else if (arg.equals("Save As..."))
			{
				//Declaration and initialization of a JFileChooser
				JFileChooser fileChooser;
				fileChooser = new JFileChooser();

				if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
				{		
					//****************************************************
					//new File declaration
					//Assigns a file to the file
					//If statement that checks to see if the file name ends with a ".txt"
					//if it does; then it does nothing
					//if it doesn't; it adds the .txt file extension
					//****************************************************
					File fileToBeSaved = fileChooser.getSelectedFile();
					if(!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt"))
					{
						fileToBeSaved = new File(fileChooser.getSelectedFile() + ".txt");
					}
								
					//Declaration of a Print Stream
					PrintStream saveAsFile;
					
					try 
					{
						//new instance of Print Stream with the file to be saved in
						saveAsFile = new PrintStream(fileToBeSaved);
								
						//Sends the information to the Print Stream
						saveAsFile.print(worker.getWorkerInfo().getId());
						saveAsFile.print("\n");
						saveAsFile.print(worker.getWorkerInfo().getFirstName());
						saveAsFile.print("\n");
						saveAsFile.print(worker.getWorkerInfo().getLastName());
						saveAsFile.print("\n");
						saveAsFile.print(worker.getWorkerInfo().getState());
						saveAsFile.print("\n");
						saveAsFile.print(worker.getWorkerInfo().getHourlyRate());
						saveAsFile.print("\n");				
						saveAsFile.print(worker.getTimeSheet().count);
						saveAsFile.print("\n");
						
						//For Loop that sends the information to he Print Stream
						for (int i = 0; i < timeSheet.count; i++)
						{
							saveAsFile.print(worker.getTimeSheet().newShift[i].getId());
							saveAsFile.print(" ");
							saveAsFile.print(worker.getTimeSheet().newShift[i].getHoursWorked());
							saveAsFile.print(" ");
							saveAsFile.print(worker.getTimeSheet().newShift[i].getDate().getMonth());
							saveAsFile.print(" ");
							saveAsFile.print(worker.getTimeSheet().newShift[i].getDate().getDay());
							saveAsFile.print(" ");
							saveAsFile.print(worker.getTimeSheet().newShift[i].getDate().getYear());
							saveAsFile.print("\n");
						}	
						//closes the Print Stream 
						saveAsFile.close();
						
					} catch (FileNotFoundException ex) 
					{			
						System.out.print("File could not be created");
					}
				}
			}
			else if (arg.equals("Report..."))
			{
				//Declaration and initialization of a JFileChooser
				JFileChooser fileChooser;
				fileChooser = new JFileChooser();
				
				if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
				{	
					//Creates a new File instance and assigns the JFileChooser to it
					File fileToBeSaved = fileChooser.getSelectedFile();
					
					//****************************************************
					//If statement that checks to see if the file name ends with a ".txt"
					//if it does; then it does nothing
					//if it doesn't; it adds the .txt file extension
					//****************************************************
					if(!fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt"))
					{
						fileToBeSaved = new File(fileChooser.getSelectedFile() + ".txt");
					}
								
					try 
					{
						//Creates a new instance of Print Stream
						PrintStream report2File = new PrintStream(fileToBeSaved);
				
						//uses existing method to print the report to a file using a Print Stream
						worker.Report(report2File);
						
						//closes the Print Stream
						report2File.close();
						
					} catch (FileNotFoundException ex) 
					{
						System.out.print("File could not be created");
					}
				}
			}
			else if (arg.equals("Exit"))
			{
				//Destroys the JFrame
				dispose();
			}
		}//end if
	}//end actionPerformed
}//end class