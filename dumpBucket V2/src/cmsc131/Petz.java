package cmsc131;

import java.util.Scanner;

public class Petz 
{
	public static void main (String[] Args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a type of pet loool: ");
		String petType = in.next();
		System.out.println("");
		
		if(petType.equals("dog"))
		{
			int eaten = howMany(in, "cats", "eaten");
			report(petType, eaten, 0);
			
		}
		else if (petType.equals("cat"))
		{
			int scratched = howMany(in, "dogs", "scratched");
			report(petType, 0, scratched);
		}
		else if (petType.equals("cockatiel"))
		{
			int eaten = howMany(in, "cats", "eaten");
			int scratched = howMany(in, "dogs", "scratched");
			report(petType, eaten, scratched);
		}
		else// no further questions
		{
			System.out.println("No further questions!");
		}
		in.close();
	}
	
	private static int howMany(Scanner in, String victim, String attack)
	{
		int damaged = 0;
		System.out.print("How many " + victim + " has your pet " + attack + "?");
		damaged = in.nextInt();
		System.out.println("");
		return damaged;
	}
	
	private static void report(String petType, int C, int D)
	{
		System.out.println("Species: " + petType);
		System.out.println("Number of cats eaten: " + C);
		System.out.println("Number of dogs scratched: " + D);
	}
}

class pizdec
{
	int age;
	String name;
	
	public pizdec(int i, String n)
	{
		age = i;
		name = n;
	}
}

