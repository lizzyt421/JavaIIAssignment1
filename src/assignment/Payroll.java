/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author lizzy
 */
public class Payroll implements Serializable
{
	public Employee[] empArray =
	{
		new Employee("123"),
		new Employee("456"),
		new Employee("789")
	};
	private int input;
	public int numberItems;
	public boolean employeesExist = false;
	//public string path;

	public static void main(String[] args)
	{
		Payroll pay = new Payroll();
		System.out.println("Welcome to the system.");
		System.out.println("One moment, logging on...");
		pay.menu();
	}

        @SuppressWarnings("empty-statement")
	public final void menu()
	{
		input = -99;
		Employee em = new Employee();

		do
		{
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("1) Populate Employees");
			System.out.println("2) Select Employee");
			System.out.println("3) Save Employees and quit");
			System.out.println("4) Load Employees");
			System.out.println("5) Exit");
			input = Integer.parseInt(new Scanner(System.in).nextLine());
			if (input == 1 && employeesExist == false)
			{
				populateEmployees();
			}
			else if (input == 2 && employeesExist == true)
			{
				selectEmployee();
			}
			else if (input == 2 && employeesExist == false)
			{
				System.out.println("\nERROR! You must first populate employees");
			}
			else if (input == 3 && employeesExist == true)
			{
				saveEmployee();
			}
			else if (input == 3 && employeesExist == false)
			{
				System.out.println("\nERROR! You must first populate employees");
			}
			else if (input == 4 && employeesExist == false)
			{
				loadEmployee();
			}
			else if (input == 4 && employeesExist == true)
			{
				System.out.println("You have already created employees.  Would you like to overwrite them? 1=no, 9=yes");
				input = Integer.parseInt(new Scanner(System.in).nextLine());
				if (input == 9)
				{
					loadEmployee();
				}
				else if (input != 1)
				{
					System.out.println("Invalid input.  Please enter either 1 to not overwrite, or 9 to overwrite.");
				} while (input != 1);

				System.out.println("Returning to the main menu.  One moment...");

			}
		} while (input != 5);
	}
//Automated Solutions
    private void populateEmployees() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void selectEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saveEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loadEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}

