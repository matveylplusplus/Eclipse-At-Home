package other;
import java.util.*;

//This program takes in the sum of the rankings of colleges I found on the internet,
//divides them by the amount of sources in which the ranking was reported, and then 
//orders them based on the new "mean ranking." Helped me make my college decisions :)

public class CR 
{	
	private double v;
	private String n;
	
	CR(double sum, String name)
	{
		v = sum;
		n = name;
	}
	
	public String toString()
	{
		return this.n + "(" + this.v + ")";
	}
	
	public static void main (String[] args)
	{	
		//ADJUSTED 
		CR UMD = new CR(263.0/9, "UMD");
		CR Carnegie = new CR(28.0/10, "Carnegie Mellon");
		CR JHU = new CR(201.0/9, "John Hopkins");
		CR Corn = new CR(89.0/9, "Cornell");
		CR MIT = new CR(35.0/10, "MIT");
		
		CR Prince = new CR(72.0/7, "Princeton");
		CR Columbia = new CR(131.0/10, "Columbia");
		CR CIT = new CR(146.0/7, "California Institute of Technology");
		CR Stanf = new CR(22.0/10, "Stanford");
		CR Syra = new CR(642.0/7, "Syracuse");
		
		CR CWR = new CR(436.0/8, "Case Western Reserve");
		CR BostonU = new CR(377.0/8, "Boston University");
		CR NE = new CR(443.0/9, "Northeastern");
		CR NYU = new CR(332.0/9, "New York University");
		CR Notre = new CR(350.0/7, "Notre Dame");
		
		CR Harv = new CR(121.0/9, "Harvard");
		CR Yale = new CR(161.0/8, "Yale");
		CR UPenn = new CR(165.0/10, "University of Pennsylvania");
		CR Emory = new CR(477.0/7, "Emory");
		CR Brown = new CR(192.0/8, "Brown University");
		
		CR Tuft = new CR(422.0/8, "Tufts");
		CR Duke = new CR(167.0/9, "Duke");
		CR Wash = new CR(405.0/8, "Washington in St. Louis");
		CR Vander = new CR(482.0/9, "Vanderbilt");
		CR Rice = new CR(198.0/8, "Rice University");
		
		CR Dart = new CR(321.0/8, "Dartmouth");
		CR Chicago = new CR(218.0/7, "University of Chicago");
		CR NW = new CR(296.0/9, "Northwestern");
		CR UVA = new CR(226.0/7, "University of Virginia");
		CR Brand = new CR(568.0/7, "Brandeis University");
		
		ArrayList<CR> list = new ArrayList<CR>( Arrays.asList(UMD, Carnegie, JHU,
		Corn, MIT, Prince, Columbia, CIT, Stanf, Syra, CWR, BostonU, NE, NYU, Notre,
		Harv, Yale, UPenn, Emory, Brown, Tuft, Duke, Wash, Vander, Rice, Dart, 
		Chicago, NW, UVA, Brand));
		
		for (int j = 0; j < list.size(); j++)
		{
			int minIndex = j;
			for (int k = j; k < list.size(); k++)
			{
				if ((list.get(k).v) < (list.get(minIndex).v))
				{
					minIndex = k;
				}
			}
			CR temp = list.get(minIndex);
			list.set(minIndex, list.get(j));
			list.set(j, temp);
			
			System.out.println("#" + (j+1) + ": " + list.get(j));
		}
		
		//https://www.indiaeducation.net/studyabroad/usa/top-100-schools-for-computer-science-in-the-us.html
		//https://www.usnews.com/best-graduate-schools/top-science-schools/computer-science-rankings
		//https://www.guide2research.com/ranking/US
		//https://www.collegefactual.com/majors/computer-information-sciences/computer-science/rankings/top-ranked/
		//http://csrankings.org/#/index?all&us
		//https://www.niche.com/colleges/search/best-colleges-for-computer-science/
		//DOOOOO https://www.collegevine.com/schools/best-colleges-for-computer-science
		//DOOOOO https://universityhq.org/best-colleges/rankings/computer-science-schools/
		//https://www.payscale.com/college-salary-report/best-schools-by-majors/computer-science/page/3
		//DOOOOO https://www.businessinsider.com/best-computer-science-engineering-schools-in-america-2015-7#32-new-york-university-111111111111111111111111111111111111111111111111111119
		
	}
}