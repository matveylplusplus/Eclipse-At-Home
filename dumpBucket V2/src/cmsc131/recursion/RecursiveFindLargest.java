package cmsc131.recursion;

public class RecursiveFindLargest 
{
	public static void main(String[] args)
	{
		int[] YOLO = {2000000, 399, 9, 4000, 56, 4};
		System.out.println("Max in array is " + findMax(YOLO, YOLO.length-1));
	}
	
	public static int findMax(int[] list, int front)///front works like an index
	{
		if (front == 0)
			return list[front];
		else
		{
			//you could do this:
			return(Math.max(list[front], findMax(list, front-1)));
			
			//OR just:
	//			int a = list[front];
	//			int b = findMax(list, front-1);
	//			
	//			if (a >= b)
	//				return a;
	//			else
	//				return b;
		}
	}
}
