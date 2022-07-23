package cmsc131;

import java.util.Scanner;

public class TwoD 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int outerLength;
		
		System.out.print("Please enter array size: ");
		outerLength = in.nextInt();
		if(outerLength <= 0 )
		{
			in.close();
			throw new IllegalArgumentException("Invalid array size >:(");
		}
		
		int[][] Arr = new int[outerLength][];
		pyramidAlloc(Arr, outerLength-1);
		print2D(Arr, outerLength-1);
		randomFill2D(Arr, outerLength-1);
		System.out.println();
		
		print2D(Arr, outerLength-1);
		System.out.println("Sum of pyramid is " + sum2D(Arr, outerLength-1));
		System.out.println();
		
		int[][] Arr2 = copy2D(Arr);
		print2D(Arr, outerLength-1);
				
		in.close();
	}
	
	public static void pyramidAlloc(int[][] arr, int n)
	{
		if(n >= 0 && n < arr.length)
		{
			if(n > 0)
				pyramidAlloc(arr, n-1);
			arr[n] = new int[n+1]; 
		}
		else
			throw new IllegalArgumentException("n out of bounds");
	}
	
	public static void print2D(int[][] arr, int n)
	{
		if (n >= 0 && n < arr.length)
		{
			if(n > 0)
				print2D(arr, n-1);
			print1D(arr[n], arr[n].length-1);
			System.out.println();
		}
		else
			throw new IllegalArgumentException("n out of bounds");
	}
	
	public static void print1D(int[] arr, int n)
	{
		if (n >= 0 && n < arr.length)
		{
			if (n > 0)
			{
				print1D(arr, n-1);
				System.out.print("|");
			}
			else if(n == 0)
				System.out.print("[");
			System.out.print(arr[n]);
			
			if(n == arr.length-1)
				System.out.print("]");
		}
		else
		{
			throw new IllegalArgumentException("n out of boudsn");
		}
	}
	
	public static int sum2D(int[][] arr, int n)
	{
		if(n >= 0 && n < arr.length)
		{
			int toReturn = 0;
			if (n > 0)
				toReturn += sum2D(arr, n-1);
			toReturn += sum1D(arr[n], arr[n].length-1);
			return toReturn;
		}
		else
			throw new IllegalArgumentException("n out of bounds");
	}
	
	public static int sum1D(int[] arr, int n)
	{
		if (n >= 0 && n < arr.length)
		{
			int toReturn = 0;
			if (n > 0)
				toReturn += sum1D(arr, n-1);
			toReturn += arr[n];
			return toReturn;
		}
		else
			throw new IllegalArgumentException("n out of bounds");
	}
	
	public static void randomFill2D(int[][] arr, int n)
	{
		if (n >= 0 && n < arr.length)
		{
			if (n > 0)
				randomFill2D(arr, n-1);
			randomFill1D(arr[n], arr[n].length-1);
		}
		else
			throw new IllegalArgumentException("n out of bound");
	}
	
	public static void randomFill1D(int[] arr, int n)
	{
		if (n >= 0 && n < arr.length)
		{
			if (n > 0)
				randomFill1D(arr, n-1);
			arr[n] = (int)(Math.random()*10);
		}
		else
			throw new IllegalArgumentException("n out of bound");
	}
	
	public static int[][] copy2D(int[][] toCopyFrom)
	{
		int[][] toCopyInto = new int[toCopyFrom.length][];
		for(int i = 0; i < toCopyFrom.length; i++)
		{
			toCopyInto[i] = new int[toCopyFrom[i].length];
			for (int j = 0; j < toCopyFrom[i].length; j++)
			{
				toCopyInto[i][j] = toCopyFrom[i][j];
			}
		}
		return toCopyInto;
	}
}
