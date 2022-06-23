package cmsc131;

import java.util.Scanner;

public class Largest10 
{
	public static void main(String[] args)
	{
		int[] arr = new int[10];
		Scanner io = new Scanner(System.in);
		
		int i = 0;
		int max = Integer.MIN_VALUE;
		
		while(i < 10)
		{
			System.out.print("Enter value " + (i+1) + ":");
			arr[i] = io.nextInt();
			if(i == 0)
			{
				max = arr[i];
			}
			else 
				if (max < arr[i]) max = arr[i];
			
			System.out.println();
			i++;
		}
		
		System.out.println("Max is " + max);
	}
}
