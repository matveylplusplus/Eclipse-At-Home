package idleCapitalist;

//Rebooted version of the IdleCapitalist program. Instead of a graph,
//it works very similarly to PrestigeO in that it finds the most optimal purchasing sequence
//for businesses instead of prestige points. 

public class IC2 
{
	private double p;
	private double i;
	private double rr;
	private int a;
	
	IC2(double price, double income, double raterate, int amount)
	{
		p = price;
		i = income;
		rr = raterate;
		a = amount;
	}
	
	public static void main(String[] args)
	{
		/*Earth
		IC2 pizza = new IC2 (262500, 1.1*68.3, 10.5, 25000);
		
		IC2 car = new IC2 (625000, 3.9*68.3, 25, 25000);
		
		IC2 restaurant = new IC2 (1875000, 14*68.3, 75, 25000);
		
		IC2 bank = new IC2 (7125000, 39*68.3, 285, 25000);
		
		IC2 oil = new IC2 (14672000, 60*68.3, 1000, 14672);
		
		IC2 airport = new IC2 (29342400, 120*68.3, 2400, 12226);
		
		IC2 hospital = new IC2 (46950000, 192*68.3, 5000, 9390);
		
		IC2 shipyard = new IC2 (102708000, 420*68.3, 12000, 8559);
		
		IC2 carfactory = new IC2 (190740000, 715*68.3, 34000, 5610);
		
		//INPUT CAP BELOW
		calculate (pizza, car, restaurant, bank, oil, airport, hospital, shipyard, carfactory, 1238706759113L, 25000);
		*/
		
		IC2 satellite = new IC2 (4070, 1*4.85, 22, 185);
		
		IC2 outpost = new IC2 (12225, 3*4.85, 75, 163);
		
		IC2 solar = new IC2 (186300, 12*4.85, 900, 207);
		
		IC2 hotel = new IC2(18000, 150*4.85, 6000, 3);
		
		//INPUT CAP BELOWWW
		calculateMoon (satellite, outpost, solar, hotel, 18514063, 25000);
	}
	
	//Precondition: objects are in correct order
	public static void calculate(IC2 p, IC2 c, IC2 r, IC2 b, IC2 o, IC2 a, IC2 h, IC2 s, IC2 cf, long m, int cap)
	{
		double total = 0.0;
		double cost = 0.0;
		
		int counterP = 0;
		int counterC = 0;
		int counterR = 0;
		int counterB = 0;
		int counterO = 0;
		int counterA = 0;
		int counterH = 0;
		int counterS = 0;
		int counterCF = 0;
		
		int maxP = cap - p.a;
		int maxC = cap - c.a;
		int maxR = cap - r.a;
		int maxB = cap - b.a;
		int maxO = cap - o.a;
		int maxA = cap - a.a;
		int maxH = cap - h.a;
		int maxS = cap - s.a;
		int maxCF = cap - cf.a;
		
		for (long x = m; x > 0; x-= cost)
		{
			double min = 1000000;
			String perc = "x";
			
			if( ((p.p)/p.i) < min && counterP < maxP)
			{
				min = (p.p)/(p.i);
				perc = "p";
			}
			
			if( ((c.p)/c.i) < min && counterC < maxC)
			{
				min = (c.p)/(c.i);
				perc = "c";
			}
			
			if ( ((r.p)/r.i) < min && counterR < maxR)
			{
				min = ((r.p)/r.i);
				perc = "r";
			}
			
			if ( ((b.p)/b.i) < min && counterB < maxB)
			{
				min = ((b.p)/b.i);
				perc = "b";
			}
			
			if ( ((o.p)/o.i) < min && counterO < maxO)
			{
				min = ((o.p)/o.i);
				perc = "o";
			}
			
			if ( ((a.p)/a.i) < min && counterA < maxA)
			{
				min = ((a.p)/a.i);
				perc = "a";
			}
			
			if ( ((h.p)/h.i) < min && counterH < maxH)
			{
				min = ((h.p)/h.i);
				perc = "h";
			}
			
			if ( ((s.p)/s.i) < min && counterS < maxS)
			{
				min = ((s.p)/s.i);
				perc = "s";
			}
			
			if ( ((cf.p)/cf.i) < min && counterCF < maxCF)
			{
				min = ((cf.p)/cf.i);
				perc = "cf";
			}
			
			//BREAKAKKKK
			//
			//
			//
			//
			//p c r b o h a s cf
			
			if(perc == "x")
			{
				x = 0;
			}
			
			else if(perc == "p")
			{
				cost = p.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}	
				total += p.i;
				p.p += p.rr;
				p.a += 1;
				counterP++;
			}
			
			else if (perc == "c")
			{
				cost = c.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += c.i;
				c.p += c.rr;
				c.a += 1;
				counterC++;
			}
			
			else if (perc == "r")
			{
				cost = r.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += r.i;
				r.p += r.rr;
				r.a += 1;
				counterR++;
			}
			
			else if (perc == "b")
			{
				cost = b.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += b.i;
				b.p += b.rr;
				b.a += 1;
				counterB++;
			}
			
			else if (perc == "o")
			{
				cost = o.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += o.i;
				o.p += o.rr;
				o.a += 1;
				counterO++;
			}
			
			else if (perc == "h")
			{
				cost = h.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += h.i;
				h.p += h.rr;
				h.a += 1;
				counterH++;
			}
			
			else if (perc == "a")
			{
				cost = a.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += a.i;
				a.p += a.rr;
				a.a += 1;
				counterA++;
			}
			
			else if (perc == "s")
			{
				cost = s.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += s.i;
				s.p += s.rr;
				s.a += 1;
				counterS++;
			}
			
			else if (perc == "cf")
			{
				cost = cf.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += cf.i;
				cf.p += cf.rr;
				cf.a += 1;
				counterCF++;
			}
		}
		
		for (int x = 1; x > 0; x-= 1)
		{
			double min = 10000000;
			String perc = "x";
			
			//INPUT RESEARCH PRICE AND CURRENT INCOME BOOST
			double pPDI = (70000)/((1.1 * (p.i*p.a)) - (p.i*p.a));
			double cPDI = (89620000)/((1.1 * (c.i*c.a)) - (c.i*c.a));
			double rPDI = (372360760000L)/((1.1 * (r.i*r.a)) - (r.i*r.a));
			double bPDI = (179175580000L)/((1.1 * (b.i*b.a)) - (b.i*b.a));
			double oPDI = (52797360000L)/((1.1 * (o.i*o.a)) - (o.i*o.a));
			double aPDI = (342990720000L)/((1.1 * (a.i*a.a)) - (a.i*a.a));
			double hPDI = (2491324610000L)/((1.1 * (h.i*h.a)) - (h.i*h.a));
			double sPDI = (10328959180000L)/((1.1 * (s.i*s.a)) - (s.i*s.a));
			double cfPDI = (258886130000L)/((1.1 * (cf.i*cf.a)) - (cf.i*cf.a));
			
			if( pPDI > min)
			{
				min = pPDI;
				perc = "p";
			}
			
			if( cPDI > min)
			{
				min = cPDI;
				perc = "c";
			}
			
			if( rPDI < min)
			{
				min = rPDI;
				perc = "r";
			}
			
			if( bPDI < min)
			{
				min = bPDI;
				perc = "b";
			}
			
			if( oPDI < min)
			{
				min = oPDI;
				perc = "o";
			}
			
			if( aPDI < min)
			{
				min = aPDI;
				perc = "a";
			}
			
			if( hPDI < min)
			{
				min = hPDI;
				perc = "h";
			}
			
			if( sPDI < min)
			{
				min = sPDI;
				perc = "s";
			}
			
			if( cfPDI < min)
			{
				min = cfPDI;
				perc = "cf";
			}
			
			if(perc == "p")
			{
				System.out.println("Research Pizza!");
			}
			
			else if (perc == "c")
			{
				System.out.println("Research Carwash!");
			}
			
			else if (perc == "r")
			{
				System.out.println("Research Restaurant!");
			}
			
			else if (perc == "b")
			{
				System.out.println("Research Bank!");
			}
			
			else if (perc == "o")
			{
				System.out.println("Research Oil!");
			}
			
			else if (perc == "h")
			{
				System.out.println("Research Hospital!");
			}
			
			else if (perc == "a")
			{
				System.out.println("Research Airport!");
			}
			
			else if (perc == "s")
			{
				System.out.println("Research Shipyard!");
			}
			
			else if (perc == "cf")
			{
				System.out.println("Research Car Factory!");
			}
			
		}
		
		System.out.println("Pizza: " + counterP);
		System.out.println("Carwash: " + counterC);
		System.out.println("Restaurant: " + counterR);
		System.out.println("Bank: " + counterB);
		System.out.println("Oil: " + counterO);
		System.out.println("Airport: " + counterA);
		System.out.println("Hospital: " + counterH);
		System.out.println("Shipyard: " + counterS);
		System.out.println("Car Factory: " + counterCF);
		
		System.out.println("Income Gained: " + total);
		
		//DOESNT WORK
		System.out.println("Money left after purchases: " + m);

		System.out.println();
		
		System.out.println("Pizza 10% income gain: " + ( (1.1 * (p.i*p.a)) - (p.i*p.a)));
		System.out.println("Carwash 10% income gain: " + ( (1.1 * (c.i*c.a)) - (c.i*c.a)));
		System.out.println("Restaurant 10% income gain: " + ( (1.1 * (r.i*r.a)) - (r.i*r.a)));
		System.out.println("Bank 10% income gain: " + ( (1.1 * (b.i*b.a)) - (b.i*b.a)));
		System.out.println("Oil 10% income gain: " + ( (1.1 * (o.i*o.a)) - (o.i*o.a)));
		System.out.println("Airport 10% income gain: " + ( (1.1 * (a.i*a.a)) - (a.i*a.a)));
		System.out.println("Hospital 10% income gain: " + ( (1.1 * (h.i*h.a)) - (h.i*h.a)));
		System.out.println("Shipyard 10% income gain: " + ( (1.1 * (s.i*s.a)) - (s.i*s.a)));
		System.out.println("Car Factory 10% income gain: " + ( (1.1 * (cf.i*cf.a)) - (cf.i*cf.a)));
	}
	
	public static void calculateMoon(IC2 sat, IC2 o, IC2 sol, IC2 h, long m, int cap)
	{
		double total = 0.0;
		double cost = 0.0;
		
		int counterSAT = 0;
		int counterO = 0;
		int counterSOL = 0;
		int counterH = 0;
		
		int maxSAT = cap - sat.a;
		int maxO = cap - o.a;
		int maxSOL = cap - sol.a;
		int maxH = cap - h.a;
		
		for (long x = m; x > 0; x-= cost)
		{
			double min = 1000000;
			String perc = "x";
			
			if( ((sat.p)/sat.i) < min && counterSAT < maxSAT)
			{
				min = (sat.p)/(sat.i);
				perc = "sat";
			}
			
			if( ((o.p)/o.i) < min && counterO < maxO)
			{
				min = (o.p)/(o.i);
				perc = "o";
			}
			
			if ( ((sol.p)/sol.i) < min && counterSOL < maxSOL)
			{
				min = ((sol.p)/sol.i);
				perc = "sol";
			}
			
			if ( ((h.p)/h.i) < min && counterH < maxH)
			{
				min = ((h.p)/h.i);
				perc = "h";
			}
			
			//BREAKAKKKK
			//
			//
			//
			//
			//p c r b o h a s cf
			
			if(perc == "x")
			{
				x = 0;
			}
			
			else if(perc == "sat")
			{
				cost = sat.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}	
				total += sat.i;
				sat.p += sat.rr;
				sat.a += 1;
				counterSAT++;
			}
			
			else if (perc == "o")
			{
				cost = o.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += o.i;
				o.p += o.rr;
				o.a += 1;
				counterO++;
			}
			
			else if (perc == "sol")
			{
				cost = sol.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += sol.i;
				sol.p += sol.rr;
				sol.a += 1;
				counterSOL++;
			}
			
			else if (perc == "h")
			{
				cost = h.p;
				if (cost > x)
				{
					m = x;
					x = 0;
				}
				total += h.i;
				h.p += h.rr;
				h.a += 1;
				counterH++;
			}
		}
		
		for (int x = 1; x > 0; x-= 1)
		{
			double min = 10000000;
			String perc = "x";
			
			//INPUT RESEARCH PRICE AND CURRENT INCOME BOOST
			double SATPDI = (40000)/((1.1 * (sat.i*sat.a)) - (sat.i*sat.a));
			double OPDI = (250000)/((1.1 * (o.i*o.a)) - (o.i*o.a));
			double SOLPDI = (9000000)/((1.1 * (sol.i*sol.a)) - (sol.i*sol.a));
			double HPDI = (100000000)/((1.1 * (h.i*h.a)) - (h.i*h.a));
			
			if(SATPDI > min)
			{
				min = SATPDI;
				perc = "sat";
			}
			
			if( OPDI > min)
			{
				min = OPDI;
				perc = "o";
			}
			
			if( SOLPDI < min)
			{
				min = SOLPDI;
				perc = "sol";
			}
			
			if( HPDI < min)
			{
				min = HPDI;
				perc = "h";
			}
		
			
			if(perc == "sat")
			{
				System.out.println("Research satellite!");
			}
			
			else if (perc == "o")
			{
				System.out.println("Research outpost!");
			}
			
			else if (perc == "sol")
			{
				System.out.println("Research Solar!");
			}
			
			else if (perc == "h")
			{
				System.out.println("Research Hotel!");
			}
		}
		
		System.out.println("Satellite: " + counterSAT);
		System.out.println("Outpost: " + counterO);
		System.out.println("Solar: " + counterSOL);
		System.out.println("Hotel: " + counterH);
		
		System.out.println("Income Gained: " + total);

		System.out.println();
		
		System.out.println("Satellite 10% income gain: " + ( (1.1 * (sat.i*sat.a)) - (sat.i*sat.a)));
		System.out.println("Carwash 10% income gain: " + ( (1.1 * (o.i*o.a)) - (o.i*o.a)));
		System.out.println("Solar 10% income gain: " + ( (1.1 * (sol.i*sol.a)) - (sol.i*sol.a)));
		System.out.println("Hotel 10% income gain: " + ( (1.1 * (h.i*h.a)) - (h.i*h.a)));
	}
	
	//300,000 diff, 3,900,000 diff, 85,380,000 diff
	
	//Pizza: $1.53 PDI (per dollar of income)
	//Carwash: $1708.76 PDI
	//Restaurant: $1647.14 PDI
	//Bank: $1681.63 PDI
	//Oil: $1629.58 PDI
	//Airport: $2108 PDI
	//Hospital: $2127 PDI
	//Shipyard: $1807 PDI
	//Car Factory: $2259 PDI
}