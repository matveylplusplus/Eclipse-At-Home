package cmsc131.recursion;

//https://youtu.be/ngCos392W4w
//Write a function that counts the number of ways you can partition N objects using partitions composed by a maximum of M objects
public class PartitionToM 
{
	public static void main(String[] args)
	{
		System.out.println(P2M(9, 5));
	}
	
	private static int P2M(int N, int M)
	{
		if (N == 0 || M == 0)
			return 0;
			//Whether there is no object or a maximum of no partitions, the possible number of partitions in both cases is 0
		else if (N == 1 || M == 1)
			return 1;
			//Whether there is only one object or a maximum of one partition, the possible number of partitions in both cases is 1
		else if (M > N)
			return P2M(N,N);
			//If M is greater than N in P2M(N, M), the answer will ALWAYS be identical to P2M(N, N). Therefore, we can reduce it like so to avoid the infinite recursion that would occur in line 21 (P2M(N-M, M) --> P2M(2-3, 3) --> P2M(-1, 3) --> Uh oh, we flipped over the base case and will now recurse toward negative infinity)
		else
		{
			int countUrself = 0;
			if (N == M)
				countUrself++;
			return P2M(N, M-1) + P2M(N-M, M) + countUrself;
			/*
			 * We're building a result for P2M(N, M) by summing together all the results from P2M(N, 1) UP TO P2M(N, M). That's the key here.
			 * 
			 * When M == 2, for example, we know that, on top of the results of when M == 1, the new possible partitions available when M == 2 are going to have a set of 2 objects PLUS some other stuff. 
			 * 
			 * P2M(6,2) --> **|(**|**), **|(*|*|**), **|(*|*|*|*)
			 * So P2M(N-M, M) addresses the PARENTHESES. This is the "some other stuff." It finds all the ways to divide them and that's ultimately added on. 
			 * 
			 * But because none of these address the case where there's only 1 part (******), we have to make a countUrself variable to count the whole set when N == M 
			 * 
			 * this is hard to explain
			 */
		}	
	}
}
