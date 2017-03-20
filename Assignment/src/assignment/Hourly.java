/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author lizzy
 */
public class Hourly extends Employee implements Serializable
{

	private final String ID;

	public Hourly(String arg_ID)
	{
		ID = arg_ID;
	}
        @Override
    public void computeGross()
    {
        System.out.println("Enter Hours: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        hours = input;
        System.out.println("Enter Hours: ");
        input = sc.nextInt();
        rate = input;
        if(hours > 40)
        {
        gross = hours * ovtrate;
        }
        else
        {
        gross = hours * rate;}
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
                
                
                  BufferedWriter bw = null;
      try {
	 String HourlyData = "Hours: " + hours + "|" + "Rate: " + taxrate + "|" + "Gross: " + gross + "|" + "Net: " + net;
	 File file = new File("C:\\Users\\Public\\TestFolder\\HourlyData.txt");
	  if (!file.exists()) {
	     file.createNewFile();
	  }
	  FileWriter fw = new FileWriter(file);
	  bw = new BufferedWriter(fw);
	  bw.write(HourlyData);
          System.out.println("File written Successfully");
      } catch (IOException ioe) {
	   ioe.printStackTrace();
	}
	finally
	{ 
	   try{
	      if(bw!=null)
                 System.out.println("Successfully wrote Hourly paystub to file.");
		 bw.close();
	   }catch(Exception ex){
	       System.out.println("Error in closing the BufferedWriter"+ex);
	    }
	}
      }
}

