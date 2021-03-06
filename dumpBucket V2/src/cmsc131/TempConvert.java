package cmsc131;

import java.util.Scanner;

public class TempConvert 
{
	public static void main (String[] Args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a temperature: ");
		double temp = in.nextDouble();
		System.out.println("");
		
		System.out.print("Farenheit(F) or Celsius(C)?");
		String tempT = in.next();
		
		if(tempT.equals("C"))
		{
			double ans = (((9.0*temp) + 160.0)/5.0);
			System.out.println("Your temperature in Farenheit is " + ans);
		}
		else if (tempT.equals("F"))
		{
			double ans = (5.0/9.0)*(temp-32.0);
			System.out.println("Your temperature in Celsius is " + ans);
		}
        in.close();
	}

}
