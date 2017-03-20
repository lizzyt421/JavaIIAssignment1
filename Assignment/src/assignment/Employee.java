
package assignment;
import java.util.*;

/**
 *
 * @author lizzy
 */
public class Employee {
/*********************
	     Attributes
	*********************/
	public float rate = 30.0f;
	public float ovtrate = 45f;
	protected float taxrate = 0.2f;
	public int hours;
	public float gross;
	protected float tax = 0.0f;
	public float net = 0.0f;
	protected float net_percent = 0.0f;
	private String ID;
	public int employeeID;
	//End Attributes

	/********************
	     Methods
	********************/
	public void menu()
	{
                Scanner sc = new Scanner(System.in);
		int input;
		do
		{
			System.out.println("What would you like to do?");
			System.out.println("1) Calculate Gross Pay, Tax, Net Pay, and Net Percent");
			System.out.println("2) Display Employee");
			System.out.println("6) Go Back");
			input = Integer.parseInt(new Scanner(System.in).nextLine());
			if (input == 1)
			{
				computeGross();
				computeTax();
				computeNet();
				computeNetperc();
				displayEmployee();
			}
			else if (input == 2)
			{
				displayEmployee();
			}

		} while (input != 6);
	}

	public void computeGross() //hourly employees only
	{
		if (employeeID == 0)
		{
			if (hours > 40)
			{
				gross = (hours - 40) * ovtrate + rate * 40;
			}
			else
			{
				gross = rate * hours;
			}
		}
		else
		{
			//Console.WriteLine("For hourly employees only, please choose another option \n");
		}
	}

	public final void computeTax() //For all employees
	{
		tax = gross * taxrate;

	}

	public final void computeNet() //all employees
	{
		net = gross - tax;
	}

	public final void computeNetperc() //all employees
	{
		net_percent = (net / gross) * 100;
	}

	public void displayEmployee()
	{
		System.out.println("Hours: " + hours);
		System.out.println("Rate: " + rate);
		System.out.println("Gross: " + gross);
		System.out.println("Tax: " + tax);
		System.out.println("Net: " + net);
		System.out.println("Net%: " + net_percent + "%");
	}
   
    
}
