package cmsc131;

public class Rational implements Comparable<Rational>
{
	private int numerator;
	private int denominator;
	
	public static void main(String[] args)
	{
		Object r1 = new Object();
		Rational r2 = new Rational(3, 1);
		System.out.println(r2.compareTo(r1));
	}
	
	public Rational(int n, int d)
	{
		numerator = n;
		denominator = d;
	}
	
	public int getNum()
	{
		return numerator;
	}
	
	public int getDenom()
	{
		return denominator;
	}
	
	@Override
	public int compareTo(Object other) {
		try {
			Rational compare = (Rational) other;
			double paramResult = (double)(compare.getNum() / compare.getDenom());
			double thisResult = (double)(this.getNum() / this.getDenom());
			
			if (paramResult > thisResult)
				return 1;//argument is greater than object
			else if (paramResult == thisResult)
				return 0;//argument is equal to object
			else
				return -1;//argument is less than object
		}
		catch(ClassCastException e){
			throw new IllegalArgumentException("Parameter is not Rational!");
		}	
	}
}

interface Comparable <T>
{
	public int compareTo(Object other);
}
