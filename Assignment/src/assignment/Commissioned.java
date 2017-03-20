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

/**
 *
 * @author lizzy
 */
public class Commissioned extends Employee 
{
	private final String ID;

	public Commissioned(String arg_ID)
	{
		ID = arg_ID;
	}
    @Override
	public void displayEmployee()
	{
		System.out.println("Gross: " + gross);
		System.out.println("Tax: " + tax);
		System.out.println("Net: " + net);
		System.out.println("Net%: " + net_percent + "%");
                                  BufferedWriter bw = null;
      try {
	 String CommissData = "Gross: " + gross + " | " + "Net: " + net + " | " + "Net%: " + net_percent ;
	 File file = new File("C:\\Users\\Public\\TestFolder\\CommissionedData.txt");
	  if (!file.exists()) {
	     file.createNewFile();
	  }
	  FileWriter fw = new FileWriter(file);
	  bw = new BufferedWriter(fw);
	  bw.write(CommissData);
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
    

