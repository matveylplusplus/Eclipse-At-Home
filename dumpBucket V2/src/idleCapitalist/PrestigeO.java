package idleCapitalist;

//Another program for "IdleCapitalist." This one finds the most optimal
//purchasing sequence of prestige points, which increase your incoem multiplier!
public class PrestigeO 
{
	private double p;
	private double i;
	private double rr;
	
	PrestigeO(double price, double income, double raterate)
	{
		p = price;
		i = income;
		rr = raterate;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		//Default
		PrestigeO five = new PrestigeO(10, 0.05, 10);
		PrestigeO fifteen = new PrestigeO(50, 0.15, 50);
		PrestigeO thirty = new PrestigeO(250, 0.3, 250);
		PrestigeO fifty = new PrestigeO(750, 0.5, 750);
		PrestigeO hundred = new PrestigeO(2500, 1, 2500);
		//
		
		/*Custom
		PrestigeO five = new PrestigeO(10, 0.05, 10);
		PrestigeO fifteen = new PrestigeO(50, 0.15, 50);
		PrestigeO thirty = new PrestigeO(250, 0.3, 250);
		PrestigeO fifty = new PrestigeO(1500, 0.5, 750);
		PrestigeO hundred = new PrestigeO(2500, 1, 2500);
		*/
		
		calculate(five, fifteen, thirty, fifty, hundred, 1158903);
		
		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime)/1000000000;
		System.out.println(totalTime);
	}
	
	//Precondition: Objects are in the correct order 
	public static void calculate(PrestigeO a, PrestigeO b, PrestigeO c, PrestigeO d, PrestigeO e, double m)
	{
		double total = 0.0;
		double cost = 0.0;
		
		int counter5 = 0;
		int counter15 = 0;
		int counter30 = 0;
		int counter50 = 0;
		int counter100 = 0;
		
		for(double x = m; x > 0; x -= cost)
		{
			double min = a.p;
			String perc = "5";
			
			if (x > min)
			{
				if( ((b.p)/3) < min)
				{
					if (x > b.p)
					{
						min = ((b.p)/3);
						perc = "15";
					}
				}
				
				if( ((c.p)/6) < min)
				{
					if (x > c.p)
					{
						min = ((c.p)/6);
						perc = "30";
					}
				}
				
				if( ((d.p)/10) < min)
				{
					if (x > d.p)
					{
						min = ((d.p)/10);
						perc = "50";
					}
				}
				
				if( ((e.p)/20) < min)
				{
					if (x > e.p)
					{
						min = ((e.p)/20);
						perc = "100";
					}
				}
				
				if(perc == "5")
				{
					cost = a.p;
					total += a.i;
					a.p += a.rr;
					counter5++;
				}
				
				else if (perc == "15")
				{
					cost = b.p;
					total += b.i;
					b.p += b.rr;
					counter15++;
				}
				
				else if (perc == "30")
				{
					cost = c.p;
					total += c.i;
					c.p += c.rr;
					counter30++;
				}
				
				else if (perc == "50")
				{
					cost = d.p;
					total += d.i;
					d.p += d.rr;
					counter50++;
				}
				
				else if (perc == "100")
				{
					cost = e.p;
					total += e.i;
					e.p += e.rr;
					counter100++;
				}
			}
		}
		total += 4.85;
		
		System.out.println("x5: " + counter5);
		System.out.println("x15: " + counter15);
		System.out.println("x30: " + counter30);
		System.out.println("x50: " + counter50);
		System.out.println("x100: " + counter100);
		System.out.println("Final multiplier: " + total);
	}
}