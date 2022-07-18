package cmsc131.recursion;

public class MergeSort 
{
	public static void main(String[] args)
	{
		int[] arr = {5, -1, 4};
		System.out.println(ArrayString(arr, arr.length-1));
		System.out.println(ArrayString(mergeSort(arr), arr.length-1));
	}
	
	public static int[] mergeSort(int[] array)
	{
		//CopyArray Method, to avoid mutating original array
		int[] toMerge = new int[array.length];
		
		//could do this...
		copyArray(toMerge, array, 0);
		//OR...
		//toMerge = array.clone();
		
		//Then restructure array by sorting small arrays that are then sorted with other small arrays to make bigger arrays and so forth
		return toMerge;
	}
	
	//STRING VERSION
	public static String ArrayString(int[] array, int index)
	{
		String result = "";
		if (index > 0)
		{
			if(index == array.length-1)
				result = ArrayString(array, index-1) + array[index] + "]";
			else
				result = ArrayString(array, index-1) + array[index] + "|";
		}
		else if (index == 0)
		{
			result = "[" + array[index] + "|";
		}
		return result;
	}
	
	public static void copyArray(int[] toBeCopiedTo, int[] toCopy, int index)
	{
		if (index == toCopy.length-1)
			toBeCopiedTo[index] = toCopy[index];
		else if (index >= 0)
		{
			toBeCopiedTo[index] = toCopy[index];
			copyArray(toBeCopiedTo, toCopy, index+1);
		}
		else
			return;
	}

//	//VOID VERSION
//	public static void printArray(int[] array, int index)
//	{
//		if (index > 0)
//		{
//			printArray(array, index-1);
//			if(index == array.length-1)
//				System.out.print(array[index] + "]");
//			else
//				System.out.print(array[index] + "|");
//		}
//		else if (index == 0)
//		{
//			System.out.print("[" + array[index] + "|");
//			return;
//		}
//	}
}
