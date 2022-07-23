package cmsc131;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RationalTest {

	@Test
	void ArgumentGreaterThanObject()
	{
		Rational r1 = new Rational(4, 5);
		Rational r2 = new Rational(3, 1);
		assertEquals(1, r1.compareTo(r2));
	}
	
	@Test
	void ArgumentLessThanObject()
	{
		
		Rational r1 = new Rational(4, 5);
		Rational r2 = new Rational(3, 1);
		assertEquals(-1, r2.compareTo(r1));
	}
	
	@Test
	void ArgumentEqualToObject()
	{
		Rational r1 = new Rational(4, 5);
		Rational r2 = new Rational(r1.getNum(), r1.getDenom());
		assertEquals(0, r1.compareTo(r2));
	}
	
	@Test
	void ArgumentNonsense()
	{
		Object obj = new Object();
		Rational r2 = new Rational(3, 1);
		assertThrows(IllegalArgumentException.class, 
				() -> {
					r2.compareTo(obj);
				});
	}
}
