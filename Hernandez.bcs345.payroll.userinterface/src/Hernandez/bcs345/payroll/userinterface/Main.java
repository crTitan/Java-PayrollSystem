/** 
 * Main.java
 * 
 * Purpose: Main program that instantiates the menus and UIs.
 * 
 * @author     Paul Rodriguez Hernandez
 * @version     %I%, %G%
 * @since       1.0
 */

package Hernandez.bcs345.payroll.userinterface;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		MainMenuUI menu = new MainMenuUI();
		
		menu.showMenu();
	}
	
	private static class MainMenuUI{
		
		private Scanner scanner = new Scanner(System.in);
		private int input = 0;
	
		public void showMenu() {
			
			do {
			
			System.out.println("\nChoose UI\n" + "---------\n" + "1 – Shift UI\n" + "2 – TimeSheet UI\n"
					+ "3 – Worker Swing UI\n" + "4 – Worker Advanced Swing UI\n" + "5 - Exit\n" + "Enter Choice:");

			input = scanner.nextInt();

			switch (input) {

			case 1:

				ShiftConsoleUI shiftConsoleUI = new ShiftConsoleUI();
				
				shiftConsoleUI.ShowUserInterface();
				
				break;

			case 2:

				TimeSheetConsoleUI timeSheetConsoleUI = new TimeSheetConsoleUI();
				
				timeSheetConsoleUI.ShowUserInterface();
				
				break;

			case 3:

				WorkerSwingUI workerSwingUI = new WorkerSwingUI();
				
				workerSwingUI.ShowUserInterface();
				
				break;

			case 4:

				WorkerAdvancedSwingUI workerAdvancedSwingUI = new WorkerAdvancedSwingUI();
				
				workerAdvancedSwingUI.ShowUserInterface();
				
				break;

			case 5:

				System.out.println("You have exited the program!");
				
				break;
		
			default:
				
				System.out.println("Please enter a valid choise or 5 to exit the program");
				
				break;
			}

		} while (input != 5);

		scanner.close();}

	}
}