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
	private Worker newWorker;
	private TimeSheet TS;
	private JTabbedPane myTabbedPane;
	private JLabel Jlab;
	private JTextField textFieldId,textFieldFirst,textFieldLast,textFieldState,textFieldHourlyRate;
	private JList<String> shiftList;
	private DefaultListModel<String> listModel;
	
	public WorkerAdvancedWindow()
	{
		//Sets the window  title and size
		setTitle("PayRoll System");
		setSize(800,800);
		
		
		//Instantiates the worker variable
		newWorker = new Worker();
		TS = new TimeSheet();
				
		//****************************************************
		//Creates a MenuBar
		//Creates a new menu 
		//Adds the menu to the MenuBar
		//****************************************************
		JMenuBar newBar = new JMenuBar();
		JMenu menu =  new JMenu("Menu");
		newBar.add(menu);
		
		//****************************************************
		//Adds the Open menu item
		//****************************************************
		JMenuItem openItem = new JMenuItem("Open..."); 
		menu.add(openItem);
		
		//****************************************************
		//Listens to the openItem menu item
		//****************************************************
		openItem.addActionListener(this);

		//****************************************************
		//Adds a new separator
		//****************************************************
		menu.add(new JSeparator());
		
		//****************************************************
		//Adds the Save As menu item
		//****************************************************
		JMenuItem saveAsItem = new JMenuItem("Save As..."); 
		menu.add(saveAsItem);

		//****************************************************
		//Listens to the openItem menu item
		//****************************************************
		saveAsItem.addActionListener(this);
	
		//****************************************************
		//Adds a new separator
		//****************************************************
		menu.add(new JSeparator());
		
		//****************************************************
		//Adds the Report menu item
		//****************************************************
		JMenuItem reportItem = new JMenuItem("Report..."); 
		menu.add(reportItem);

		//****************************************************
		//Listens to the openItem menu item
		//****************************************************
		reportItem.addActionListener(this);
				
		//****************************************************
		//Adds a new separator
		//****************************************************
		menu.add(new JSeparator());
		
		//****************************************************
		//Adds the Exit menu item
		//****************************************************
		JMenuItem exitItem = new JMenuItem("Exit"); 
		menu.add(exitItem);
		
		//****************************************************
		//Listens to the openItem menu item
		//****************************************************
		exitItem.addActionListener(this);
				
		//****************************************************
		//Adds the menu bar to the window
		//****************************************************
		this.setJMenuBar(newBar);

		//Creates the JTabbedPane and add it to the window
		myTabbedPane = new JTabbedPane();
		add(myTabbedPane);
				
		//****************************************************
		//Create the first Panel	
		//****************************************************	
		JPanel panelOne;
		panelOne =new JPanel();
		
		//Sets the background color
		panelOne.setBackground(Color.LIGHT_GRAY);
		
		//****************************************************
		//Allocates new memory and adds a value to
		//the JLabel variable
		//Adds the label to the panel
		//****************************************************
		Jlab = new JLabel("Id");
		panelOne.add(Jlab);
		
		//****************************************************
		//The i String stores the int Id value in the
		//WorkerInfor Class.
		//****************************************************
		Integer i = newWorker.getWorkerInfo().getId();
			
		//****************************************************
		//Allocates new memory and passes a value to
		//the JTextField variable
		//i.toString() converts the int Id value to a string
		//Adds the TextField to the panel
		//****************************************************
		panelOne.add(textFieldId = new JTextField(i.toString()));
		
		//****************************************************
		//Allocates new memory ands adds a value to
		//the JLabel variable
		//Adds the label to the panel
		//****************************************************
		panelOne.add(Jlab =new JLabel("First"));
		
		//****************************************************
		//Allocates new memory for the JTextField variable
		//and passes in a value
		//Adds the TextField to the panel
		//****************************************************
		panelOne.add(textFieldFirst = new JTextField(newWorker.getWorkerInfo().getFirstName()));
			
		//****************************************************
		//Allocates new memory and passes a value to the
		//JLabel variable
		//Adds the label to the panel
		//****************************************************
		panelOne.add(Jlab =new JLabel("Last"));
		
		//****************************************************
		//Allocates new memory and passes a value to
		//the JTextField variable
		//Adds the textFieldLast TextField to the panel
		//****************************************************
		panelOne.add(textFieldLast = new JTextField(newWorker.getWorkerInfo().getLastName()));
		
		//****************************************************
		//Allocates new memory for the JLabel variable
		//and passes in a value
		//Adds the label to the panel
		//****************************************************
		panelOne.add(Jlab =new JLabel("State"));
		
		//****************************************************
		//Allocates new memory for the JTextField variable
		//and passes in a value
		//Adds the textFieldState TextField to the panel
		//****************************************************
		panelOne.add(textFieldState = new JTextField(newWorker.getWorkerInfo().getState()));

		//****************************************************
		//Allocates new memory and passes a value to
		//the JLabel variable
		//Adds the label to the panel
		//****************************************************
		panelOne.add(Jlab =new JLabel("Hourly Rate"));
		
		//****************************************************
		//Allocates new memory for the JTextField variable
		//the perHour String store a converted version of the
		//double stored in the WorkerInfor Class.
		//The perHour variable is then passed as a parameter.
		//Allocates new memory for the JTextField variable
		//****************************************************
		String perHour = String.valueOf(newWorker.getWorkerInfo().getHourlyRate());
		textFieldHourlyRate = new JTextField(perHour);
		
		//****************************************************
		//Adds the textFieldHourlyRate TextField to the panel
		//****************************************************
		panelOne.add(textFieldHourlyRate);

		//****************************************************
		//Creates and initializes a new GridLayout with zero
		//rows and two columns
		///Sets the Layout to the first panel
		//****************************************************
		panelOne.setLayout(new GridLayout(0,2));

		//****************************************************
		//Adds the Worker Information tab
		//Adds the first panel to the tab
		//****************************************************
		myTabbedPane.addTab("Worker Information", panelOne);
		
		//Creates a the second panel
		JPanel panelTwo = new JPanel();
		
		//Sets the background color
		panelTwo.setBackground(Color.LIGHT_GRAY);
		
		//Initializes the the listModel variable
		listModel = new DefaultListModel<String>();
		
		//create the actual list and allocates memory
		//passes in the listModel variable
        shiftList = new JList<String>(listModel);
     		        
        //****************************************************
		//Adds the JList to the second panel
        //****************************************************
		panelTwo.add(shiftList);
				
		//****************************************************
		//Adds the Time Sheet tab
		//Adds the second panel to the tab
		//****************************************************
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
					Scanner fileScnner;
					try 
					{
						//new Scanner ins
						fileScnner = new Scanner(new File (selectedFile));
						
						//reads the information in from the file
						newWorker.Read(fileScnner);
						
						//sets the new id to the JTextField Variable
						Integer i = newWorker.getWorkerInfo().getId();
						textFieldId.setText(i.toString());
						
						//sets the new first name to the JTextField Variable
						textFieldFirst.setText(newWorker.getWorkerInfo().getFirstName());
						
						//sets the new last name to the JTextField Variable
						textFieldLast.setText(newWorker.getWorkerInfo().getLastName());

						//sets the new State to the JTextField Variable
						textFieldState .setText(newWorker.getWorkerInfo().getState());
						
						//sets the new hourly rate to the JTextField Variable
						String perHour = String.valueOf(newWorker.getWorkerInfo().getHourlyRate());
						textFieldHourlyRate.setText(perHour);
										
						//For loop that sets the listModel elements to the worker shift info
						for(int j = 0; j < newWorker.getTimeSheet().count; j++ )
						{
							listModel.addElement(newWorker.getWorkerInfo().getId() + " "
							+ newWorker.getTimeSheet().newShift[j].getHoursWorked() + " "
							+ newWorker.getTimeSheet().newShift[j].getDate().getMonth() + " "
							+ newWorker.getTimeSheet().newShift[j].getDate().getDay() + " "
							+ newWorker.getTimeSheet().newShift[j].getDate().getYear());
						}
					} catch (FileNotFoundException e1) 
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
						saveAsFile.print(newWorker.getWorkerInfo().getId());
						saveAsFile.print("\n");
						saveAsFile.print(newWorker.getWorkerInfo().getFirstName());
						saveAsFile.print("\n");
						saveAsFile.print(newWorker.getWorkerInfo().getLastName());
						saveAsFile.print("\n");
						saveAsFile.print(newWorker.getWorkerInfo().getState());
						saveAsFile.print("\n");
						saveAsFile.print(newWorker.getWorkerInfo().getHourlyRate());
						saveAsFile.print("\n");				
						saveAsFile.print(newWorker.getTimeSheet().count);
						saveAsFile.print("\n");
						
						//For Loop that sends the information to he Print Stream
						for (int i = 0; i < TS.count; i++)
						{
							saveAsFile.print(newWorker.getTimeSheet().newShift[i].getId());
							saveAsFile.print(" ");
							saveAsFile.print(newWorker.getTimeSheet().newShift[i].getHoursWorked());
							saveAsFile.print(" ");
							saveAsFile.print(newWorker.getTimeSheet().newShift[i].getDate().getMonth());
							saveAsFile.print(" ");
							saveAsFile.print(newWorker.getTimeSheet().newShift[i].getDate().getDay());
							saveAsFile.print(" ");
							saveAsFile.print(newWorker.getTimeSheet().newShift[i].getDate().getYear());
							saveAsFile.print("\n");
						}	
						//closes the Print Stream 
						saveAsFile.close();
					} catch (FileNotFoundException e1) 
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
						newWorker.Report(report2File);
						
						//closes the Print Stream
						report2File.close();
						
					} catch (FileNotFoundException e1) 
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