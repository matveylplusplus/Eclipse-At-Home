package cmsc131;

import java.util.Scanner;

public class Avg10 
{
	public static void main(String[] args)
	{
		int[] arr = new int[10];
		Scanner io = new Scanner(System.in);
		
		int i = 0;
		double sum = 0;
		
		while(i < 10)
		{
			System.out.print("Enter value " + (i+1) + ":");
			arr[i] = io.nextInt();
			sum += arr[i];
			System.out.println();
			i++;
		}
		
		System.out.println("Average is " + (sum/10) + "!");
	}
}