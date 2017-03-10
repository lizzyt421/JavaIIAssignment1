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
public class Hourly extends Employee implements Serializable
{

	private String ID;

	public Hourly(String arg_ID)
	{
		ID = arg_ID;
	}
	public Hourly()
	{

	}
	@Override
	public void displayEmployee()
	{
		System.out.println("Hours: " + hours);
		System.out.println("Rate: " + rate);
		System.out.println("Gross: " + gross);
		System.out.println("Tax: " + tax);
		System.out.println("Net: " + net);
		System.out.println("Net%: " + net_percent + "%");
		try (java.io.OutputStreamWriter sw = File.CreateText("C:\\Users\\Public\\TestFolder\\HourlyData.txt"))
		{
			sw.write("Hours: " + hours + System.lineSeparator());
			sw.write("Rate: " + taxrate + System.lineSeparator());
			sw.write("Gross: " + gross + System.lineSeparator());
			sw.write("Net: " + net + System.lineSeparator());
		}
		System.out.println("Successfully wrote Hourly paystub to file.");

	}
}

