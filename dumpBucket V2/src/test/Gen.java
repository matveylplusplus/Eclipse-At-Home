package test;

public class Gen extends Object implements interf1, interf2
{	
	public static int popo = 7;
	public static void main (String[] Args)
	{
		
	}
	
	public Gen()
	{
		
	}
	
	public void printGen()
	{
		System.out.println("You are gen z");
	}
}

class pizdec extends Gen
{
	boolean cheese;
	
	public void printContents()
	{
		System.out.println("cheese = " + cheese);
	}
}

interface interf1
{
	public int bobo = 6;
}

interface interf2
{
	public int bobo = 6;
}

