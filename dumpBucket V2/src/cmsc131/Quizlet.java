package cmsc131;

public class Quizlet 
{
	int questions;
	boolean difficult;
	
	public static void main(String[] args)
	{
		int[][] ragged = {{5, 9, 45}, {4, 2, 13, 15, 17}, {9, 1, 4, 9}};
		print2DArray(ragged);
		String ss = "dis bich empty yeet";
		ss.toUpperCase();
		
		System.out.println();
		
		print1DArray(linearize(ragged));
	    System.out.println(System.getProperties().get("java.class.path"));
	}
	
	private Quizlet(int q, boolean d)
	{
		questions = q;
		difficult = d;
	}
	
	private static void print1DArray(int[] arr)
	{
		print1DArrayHelper(arr, arr.length-1);
	}
	
	private static void print2DArray(int[][] arr)
	{
		print2DArrayHelper(arr, arr.length-1, arr[arr.length-1].length-1);
	}
	
	private static void print2DArray(Quizlet[][] arr)
	{
		print2DArrayHelper(arr, arr.length-1, arr[arr.length-1].length-1);
	}
	
	private static void print1DArrayHelper(int[] arr, int index)
	{
		if(index == 0)
			System.out.print("[" + arr[index]);
		else
		{
			print1DArrayHelper(arr, index-1);
			System.out.print("|" + arr[index]);
		}
			
		if(index == arr.length-1)
			System.out.print("]");
	}
	
	private static void print2DArrayHelper(int[][] arr, int outerIndex, int innerIndex)
	{
		if(innerIndex == 0)
		{
			if(outerIndex != 0)
			{
				print2DArrayHelper(arr, outerIndex-1, arr[outerIndex-1].length-1);//moving to lower outerIndex since we have hit the first letter of this array
				System.out.print("[" + arr[outerIndex][innerIndex]);
			}
			else
				System.out.print("[" + arr[outerIndex][innerIndex]);
		}
		else 
		{
			print2DArrayHelper(arr, outerIndex, innerIndex-1);//moving backwards along current array, like you would with a 1D one
			System.out.print("|" + arr[outerIndex][innerIndex]);
		}
		
		if(innerIndex == arr[outerIndex].length-1)//closing brackets and moving to next line
			System.out.println("]");
	}
	
	private static void print2DArrayHelper(Quizlet[][] arr, int outerIndex, int innerIndex)
	{
		if(innerIndex == 0)
		{
			if(outerIndex != 0)
			{
				print2DArrayHelper(arr, outerIndex-1, arr[outerIndex-1].length-1);//moving to lower outerIndex since we have hit the first letter of this array
				System.out.print("[" + arr[outerIndex][innerIndex].difficult);
			}
			else
				System.out.print("[" + arr[outerIndex][innerIndex].difficult);
		}
		else 
		{
			print2DArrayHelper(arr, outerIndex, innerIndex-1);//moving backwards along current array, like you would with a 1D one
			System.out.print("|" + arr[outerIndex][innerIndex].difficult);
		}
		
		if(innerIndex == arr[outerIndex].length-1)//closing brackets and moving to next line
			System.out.println("]");
	}
	
	  private static Quizlet[][] QuizletDupliQuizletor(int[] rowSizes, Quizlet c)
	  {
	 		Quizlet[][] Quizlet2D = new Quizlet[rowSizes.length][];
	 		for (int i = 0; i < rowSizes.length; i++)
	 		{
	 			Quizlet2D[i] = new Quizlet[rowSizes[i]];
	 			for(int j = 0; j < rowSizes[i]; j++)
	 			{
	 				Quizlet2D[i][j] = c;
	 			}
	 		}
	 		return Quizlet2D;
	  }
	  
	public static int[] linearize(int[][] array)
	{
		int totalElements = 0;
		for (int i = 0; i < array.length; i++)
			totalElements += array[i].length;
		//System.out.println("TE = " + totalElements);
		
		int[] answer = new int[totalElements];
		int index = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
			{
				answer[index] = array[i][j];
				index++;
			}
		}
		return answer;
	}
}
