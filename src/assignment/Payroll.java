/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
//import java.io.Console;
import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author lizzy
 */
public class Payroll implements Serializable
{
    int[] empArray = new int [3];
    public void populateEmpArray()
    {
        empArray [0] = 1;
        empArray [1] = 2;
        empArray [2] = 3;
    }   
//	int arr[] = new int [] {123, 456, 789};
//	public Employee[] empArray ={123, 456, 789};
//	{
//		new Employee("123"),
//		new Employee("456"),
//		new Employee("789")
//	};
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
                        Scanner sc = new Scanner(System.in);
                        int input;
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

public final void populateEmployees()
	{
		Employee em = new Employee();
		System.out.println("Please fill out the attributes for the employees you wish to add\n");

		for (int i = 0; i < empArray.length; i++)
		{
			if (i == 0)
			{
				//Hourly employee
				empArray[i] = new Hourly();
				System.out.println("Hourly employee:\nHow many hours?");
				input = Integer.parseInt(new Scanner(System.in).nextLine());
				empArray[0].hours = input;
				System.out.println("Pay rate:");
				input = Integer.parseInt(new Scanner(System.in).nextLine());
				empArray[0].rate = input;
			}
			else if (i == 1)
			{
				//Salaried employees
				empArray[i] = new Salaried();
				System.out.println("\nSalary employee:\nStaff or executive? (1 or 9)");
				input = Integer.parseInt(new Scanner(System.in).nextLine());
				if (input == 1)
				{
					empArray[1].gross = 50000;
				}
				else if (input == 9)
				{
					empArray[1].gross = 100000;
				}
			}
			else if (i == 2)
			{
				//Commissioned employee
				empArray[i] = new Commissioned();
				System.out.println("\nCommissioned employee:\nNumber of items sold?");
				input = Integer.parseInt(new Scanner(System.in).nextLine());
				numberItems = input;
				System.out.println("Unit price of items sold?");
				input = Integer.parseInt(new Scanner(System.in).nextLine());
				empArray[2].gross = 0.5f * (input * numberItems);
			}
			else
			{

			}
		}

		employeesExist = true;
	}

	public final void selectEmployee()
	{
		String sinput = null;
		int input;
		input = -1;
		while (input != -99)
		{
			Employee em = new Employee();
			System.out.println("\nPlease Select an employee:\n");
			System.out.println("Enter 0 for an Hourly Employee \nEnter 1 for a Salary Employee \nEnter 2 for a Comission Employee \nEnter -99 to Go Back");
			sinput = new Scanner(System.in).nextLine();
			input = Integer.parseInt(sinput);
			if (input != -99)
			{
				if (input == 0 || input == 1 || input == 2)
				{
					empArray[input].employeeID = input;
					empArray[input].menu();
				}
				else
				{
					System.out.println("Invalid input. Please enter  0 for an Hourly Employee, 1 for a Salary Employee, 2 for a Comission Employee, or -99 to Go Back");
				}

			}
			else
			{
				System.out.println("Goodbye.");
			}
		}
	}
	public final void saveEmployee()
	{
		Hourly hr = new Hourly();
		Salaried sal = new Salaried();
		Commissioned com = new Commissioned();
		System.IO.Stream FileStream = new File("C:\\Users\\Public\\TestFolder\\WriteLines.xml");
		BinaryFormatter serializer = new BinaryFormatter();
		serializer.Serialize(FileStream, empArray);
		FileStream.Close();
		System.out.println("\nYour changes have been saved.  Goodbye.");
		System.exit(0);
	}
	public final void loadEmployee()
	{
		Stream FileStream = File.OpenRead("C:\\Users\\Public\\TestFolder\\WriteLines.xml");
		//XmlSerializer deserializer = new XmlSerializer(typeof(Account[]));
		BinaryFormatter deserializer = new BinaryFormatter();
		empArray = (Employee[])deserializer.Deserialize(FileStream);
		FileStream.Close();
		employeesExist = true;

		//var serializer = new XmlSerializer(typeof(EmployeeContainer));
		//var stream = new FileStream(path, FileMode.Open);
		//var container = serializer.Deserialize(stream) as EmployeeContainer;
		//stream.Close();
	}

}

