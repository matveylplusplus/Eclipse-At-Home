package cmsc131.recursion;

public class CodingBat 
{
	public static void main(String[] args)
	{
		System.out.println(CalcFact(3));
	}
	
	public static int CalcFact(int N)
	{
		if (N == 0)
			return 0;
		else if (N == 1)
			return 1;
		else
			return N * CalcFact(N-1);
		
	}
	
	public static int bunnyEars(int bunnies)
	{
		if (bunnies == 0)
			return 0;
		else
			return bunnyEars(bunnies-1) + 2;
	}
	
	public static int fibonacci(int n)
	{
		if(n == 0)
		    return 0;
		  else if(n == 1 || n == 2)
		    return 1;
		  else
		    return fibonacci(n-2) + fibonacci(n-1);
	}
	
	public int bunnyEars2(int bunnies) 
	{
	  if (bunnies == 0)
	    return 0;
	  else
	  {
	    if (bunnies % 2 == 1)
	      return bunnyEars2(bunnies-1) + 2;
	    else
	      return bunnyEars2(bunnies-1) + 3;
	  }
	}
	
	public int triangle(int rows) 
	{
	  if (rows == 0)
	    return 0;
	  else
	    return triangle(rows-1) + rows;
	}
	
	public int sumDigits(int n) 
	{
	  if (n == 0)
	    return 0;
	  else if (n > 0)
	    return (n % 10) + sumDigits(n/10); 
	  else
	    return n;
	}
	
	public int count7(int n) 
	{
	  if (n == 0)
	    return 0;
	  else if (n % 10 == 7)
	    return 1 + count7(n/10);
	  else
	    return count7(n/10);
	}
	
	public int count8(int n) 
	{
	  if (n == 0)
	    return 0;
	  else if (n % 10 == 8)
	  {
	    if ( (n/10) % 10 == 8)
	      return 2 + count8(n/10);
	    else
	      return 1 + count8(n/10);
	  }
	  else
	    return count8(n/10);
	}
	
	public int powerN(int base, int n) 
	{
	  if (base == 1)
	    return 1;
	  else if (n == 1)
	    return base;
	  else
	    return base * powerN(base, n-1);
	}
	
	public int countX(String str) 
	{
	  if (str.length() == 0)
	    return 0;
	  else if (str.substring(str.length()-1).equals("x"))
	    return 1 + countX( str.substring(0, str.length()-1) );
	  else
	    return countX( str.substring(0, str.length()-1) );
	}
	
	public static String allStar(String str)
	{
		if(str.equals(""))
			return "";
		else if (str.length() == 1)
			return str;
		else
			return str.substring(0, 1) + "*" + allStar(str.substring(1));
	}
}
