
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
                

        try {
             File file = new File("C:\\Users\\Public\\TestFolder\\SalariedData.txt");
                                  
            if (!file.exists()) 
            {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
                    try (BufferedWriter bw = new BufferedWriter(fw)) 
                        {
                            System.out.println("Please choose an account number[0,1,2]: ");
                            Scanner sc = new Scanner(System.in);
                            int input = sc.nextInt();
                            String tempString = Salaried[input].getAcctNum();
                            double tempNumber = myAccounts[input].getBalance();
                            String tempStringNum = Double.toString(tempNumber);
                            bw.write(tempString);
                            bw.write("|");
                            bw.write(tempStringNum);
                            bw.newLine();
                        }
            System.out.println("Successfully wrote Salaried paystub to file.");
            } 
            catch (IOException ex) 
            {
//                e.printStackTrace();
                 System.out.println("Error in closing the BufferedWriter"+ex);
            }
              
	}
}