package cmsc131.recursion;

//https://youtu.be/ngCos392W4w
//Write a function that will show the number of unique paths from the top left corner of a NxM grid to its bottom right corner. You can only move down and right. And only 1 unit at a time
public class NMGrid 
{
	public static void main(String[] args)
	{
		System.out.println(uniqueDownRightPath(5, 12));
	}
	
	public static int uniqueDownRightPath(int N, int M)
	{
		if(N <= 1 && M <= 1)//really exists only for the scenario in which the user plugs in 1,1 or 0,1 or 1,0 or 0,0 or some negative shit
			return 0;
		else if( N == 1 || M == 1 )//Once any dimension gets down to 1, there HAS to be only 1 possible path.
			return 1;
		else
			return uniqueDownRightPath(N-1, M) + uniqueDownRightPath(N, M-1);
	}
}