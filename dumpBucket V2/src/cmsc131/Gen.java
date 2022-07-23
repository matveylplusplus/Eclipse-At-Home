package cmsc131;

import java.util.Scanner;

public class Gen
{	
	public static void main (String[] Args)
	{
		Scanner scoony = new Scanner(System.in);
		
		int n;
		
		System.out.print("Please enter size of array N: ");
		n = scoony.nextInt();
		if(n <= 0)
		{
			scoony.close();
			throw new IllegalArgumentException("invalid array size >:(");
		}
		System.out.println();
		
		int[] array = new int[n];
		BuildArray(array, scoony, n-1);
		System.out.println();
		
		printArrayinReverse(array, 0);
		System.out.println();
		
		System.out.println();
		
		System.out.print("Setting all to 5...");
		System.out.println();
		setTo5(array);
		printArrayinReverse(array, 0);
	}
	
	public static void BuildArray(int[] arr, Scanner scon, int n)
	{
		if(n >= 0 && n < arr.length)
		{
			if(n > 0)
				BuildArray(arr, scon, n-1);
			System.out.print("Please enter element " + n + ": ");
			arr[n] = scon.nextInt();
		}
		else
		{
			throw new IllegalArgumentException("n out of bounds");
		}
	}
	
	public static void printArrayinReverse(int[] arr, int n)
	{
		if (n >= 0 && n < arr.length)
		{
			if (n < arr.length-1)
			{
				printArrayinReverse(arr, n+1);
				System.out.print("|");
			}
			else if (n == arr.length-1)
				System.out.print("[");
			System.out.print(arr[n]);
			
			if(n == 0)
				System.out.print("]");
		}
		else
			throw new IllegalArgumentException("n out of bounds");
	}
	
	public static void setTo5(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = 5;
		}
	}
	
	public Gen()
	{
		
	}
	
	
}