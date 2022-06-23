package cmsc131;

import java.util.Scanner;

public class AddToN 
{
	public static void main(String[] args)
	{
		int n;
		Scanner io = new Scanner(System.in);
		System.out.print("Enter a positive integer plz: ");
		n = io.nextInt();
		
		int result = 0;
		for(int i = 1; i <= n; i++)
		{
			result += i;
		}
		
		System.out.println("My answer is " + result);
		io.close();
	}

}