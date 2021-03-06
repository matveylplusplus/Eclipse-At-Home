package cmsc131.recursion;

import java.util.Scanner;

public class AddToNRecursive 
{
	public static void main (String[] Args)
	{
		int N = 19;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Numbers going up to " + N + " are " + upToN(N));
		
		in.close();
	}
	
	public static int upToN(int n)
	{
		if(n == 1)
			return n;
		else
			return upToN(n-1) + n;
	}
}