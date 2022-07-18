package cmsc131.recursion;

public class FloatBackward 
{
	public static void main(String[] args)
	{
		float[] lol = {4.3f, 9.9f, 10.1f, 445.4f};
		printBack(lol, 0);
	}
	
	//Write a recursive method that will print the contents of an ArrayList of Float values out backwards.
	private static void printBack(float[] arr, int index)
	{
		if (index == arr.length-1)
			System.out.print("[" + arr[index]);
		else
		{
			printBack(arr, index+1);
			System.out.print("|" + arr[index]);
		}
		if(index == 0)
			System.out.print("]");
	}
}