
package assignment;
//import java.io.Serializable;
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

    //used for Payroll, Automated Solutions
    Employee(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Employee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	/********************
	 Constructors
     * @param arg_ID
	********************/
//	public Employee(String arg_ID)
//	{
//		ID = arg_ID;
//	}
//	public Employee()
//	{
//
//	}

	/********************
	     Methods
	********************/
	public final void menu()
	{
		int input;
		do
		{
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("1) Calculate Gross Pay, Tax, Net Pay, and Net Percent");
			//Console.WriteLine("2) Calculate Tax");
			//Console.WriteLine("3) Calculate Net Pay");
			//Console.WriteLine("4) Calculate Net Percent");
			System.out.println("3) Display Employee");
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
			//else if (input == 2)
			//{
			//    computeTax();
			//}
			//else if (input == 3)
			//{
			//    computeNet();
			//}
			//else if (input == 4)
			//{
			//    computeNetperc();
			//}
			else if (input == 3)
			{
				displayEmployee();
			}

		} while (input != 6);
	}

	public final void computeGross() //hourly employees only
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
    public static void main(String[] args) {
     
     
    }
    
}
