/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author lizzy
 */
public class Salaried extends Employee implements Serializable
{
	private String ID;

	public Salaried(String arg_ID)
	{
		ID = arg_ID;
	}
	public Salaried()
	{

	}
	@Override
	public void displayEmployee()
	{
		//Console.WriteLine("Hours: " + hours);
		//Console.WriteLine("Rate: " + rate);
		System.out.println("Gross: " + gross);
		System.out.println("Tax: " + tax);
		System.out.println("Net: " + net);
		System.out.println("Net%: " + net_percent + "%");
		try (java.io.OutputStreamWriter sw = File.CreateText("C:\\Users\\Public\\TestFolder\\SalariedData.txt"))
		{
			//sw.WriteLine("Hours: " + hours);
			//sw.WriteLine("Rate: " + taxrate);
			sw.write("Gross: " + gross + System.lineSeparator());
			sw.write("Net: " + net + System.lineSeparator());
			sw.write("Net%: " + net_percent + "%" + System.lineSeparator());
		}
		System.out.println("Successfully wrote Salaried paystub to file.");

	}
}