package cmsc131;

import java.util.Scanner;

public class Mutable 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n;
		
		System.out.print("Enter array size: ");
		n = in.nextInt();
		if(n <= 0)
		{
			in.close();
			throw new IllegalArgumentException("illegal array size >:(");
		}
		
		StringBuffer[] SBArr = new StringBuffer[n];
		
		
		
		fillSB(SBArr, in);
		print1DBuff(SBArr);
		
		StringBuffer[] reference = rCopySB(SBArr);
		StringBuffer[] shallow = shallowCopySB(SBArr);
		StringBuffer[] deep = deepCopySB(SBArr);
		System.out.println();
		System.out.println();
		
		print1DBuff(reference);
		System.out.println();
		System.out.println();
		
		print1DBuff(shallow);
		System.out.println();
		System.out.println();
		
		print1DBuff(deep);
		System.out.println();
		System.out.println();
		
		System.out.println("SBArr.equals(reference) = " + SBArr.equals(reference));//true
		System.out.println("Changing 3rd element of SBArr...");
		SBArr[2] = SBArr[2].append("c");
		print1DBuff(reference);
		System.out.println();
		
		System.out.println("SBArr.equals(shallow) = " + SBArr.equals(shallow));//false
		print1DBuff(shallow);
		System.out.println();
		
		System.out.println("SBArr.equals(deep) = " + SBArr.equals(deep));//false
		print1DBuff(deep);
		
		in.close();
	}
	
	public static void fillSB(StringBuffer[] strBuff, Scanner in)
	{
		for(int i = 0; i < strBuff.length-2; i++)
		{
			System.out.print("Please enter element " + i + ": ");
			strBuff[i] = new StringBuffer(in.next());
		}
	}
	
	public static StringBuffer[] rCopySB(StringBuffer[] strBuff)
	{
		return strBuff;
	}
	
	public static StringBuffer[] shallowCopySB(StringBuffer[] strBuff)
	{
		int length = strBuff.length;
		
		StringBuffer[] newBuff = new StringBuffer[length];
		for(int i = 0; i < length; i++)
		{
			newBuff[i] = strBuff[i];
		}
		
		return newBuff;
	}
	
	public static StringBuffer[] deepCopySB(StringBuffer[] strBuff)
	{
		int length = strBuff.length;
		
		StringBuffer[] newBuff = new StringBuffer[length];
		
		for (int i = 0; i < length; i++)
		{
			if(strBuff[i] instanceof StringBuffer)
			{
				System.out.println("Element " + i + " passes instancetest and is class " + strBuff[i].getClass());
				newBuff[i] = new StringBuffer(strBuff[i]);
			}
			else
			{
				System.out.println("Element " + i + " fails instancetest and is class " + strBuff[i].getClass());
			}	
		}
		return newBuff;
	}
	
	public static void print1DBuff(StringBuffer[] strBuff)
	{
		System.out.print("[");
		for(int i = 0; i < strBuff.length; i++)
		{
			if (i > 0)
				System.out.print("|");
			System.out.print(strBuff[i]);
		}
		System.out.print("]");
	}
}
