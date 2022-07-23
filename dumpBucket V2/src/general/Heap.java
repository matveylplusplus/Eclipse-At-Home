package general;

//implementation is done as an array (as opposed to a tree of linked lists, which is more intuitive to work with) because it's a lower space complexity; space complexity is harder to measure than time complexity and largely depends on local hardware but excessive space complexity will have very similar if not identical disadvantages that an excessive time complexity would: it's memory. So if cache can't hold it then it will go to RAM and if RAM can't hold it then it will go to the Hard Drive and if there's no space in the Hard Drive then your computer sets on fire
public class Heap 
{
	//the actual storage structure for your heap
	private int[] arr;
	private int size;
	private int firstEmpty;//stores index of the first element (going up from 0) that comes up empty (has a 0)

	//constructor for your heap
	//feel free to make one that takes in an array if you prefer for your testing purposes.
	//note that we will not be inserting more than 100 elements into our array so you need not worry about re-sizing
	//the array
	public Heap() 
	{
		size = 100;
		firstEmpty = 0;
		arr = new int[size];//an element with value 0 is considered to be null
	}
	
	//TESTING START
	public static void main(String[] args) 
	{
		Heap ho = new Heap();
		
		ho.add(70);
		ho.add(13);
		ho.add(45);
		ho.add(1);
		ho.add(2);
		System.out.println("First addition");
		ho.visualize(ho.arr);//visual
		System.out.println("");
		
		ho.add(69);
		ho.add(46);
		ho.add(9);
		ho.add(22);
		System.out.println("Second addition");
		ho.visualize(ho.arr);//visual
		System.out.println("");
		
		System.out.println("Removal of " + ho.arr[0]);
		ho.removeMax();
		ho.visualize(ho.arr);//visual
		System.out.println("");
		
		ho.add(17);
		ho.add(24);
		System.out.println("Third addition, post-removal of root");
		ho.visualize(ho.arr);//visual
		System.out.println("");
		
		System.out.println("Removal of " + ho.arr[0] + "; final result");
		ho.removeMax();
		ho.visualize(ho.arr);//visual
		System.out.println("");
	}
	
	public void visualize(int[] arr)
	{
		int count = 0;
		int h = 0;
		
		while(count < size)
		{
			double ran = 0;
			while (ran != Math.pow(2, h))
			{
				if(count < size)
				{
					System.out.print(arr[count] + " ");
					count++;
					ran++;
				}
					
				else//cancel loop immediately; no more elements to look at
					ran = Math.pow(2, h);
			}
			System.out.println("");
			h++;
		}
		//After each height increment, output next 2^height nodes in the array on a new line. 2^0 (root level, height = 0) yields 1 element. 2^2 (height = 2) yields 4 elements.
	}
	//TESTING END

	//create this function to add elements to your heap
	//all heap properties must be preserved
	// 5 points
	public void add(int toAdd) 
	{
		if (firstEmpty < size)
		{
			arr[firstEmpty] = toAdd;
			siftUp(firstEmpty);
			firstEmpty++;//increment firstEmpty so we know what the highest, leftmost (if you think about it as a tree) null element is. Thus we know where to add stuff
		}
		else
			System.out.println("Array is maxed out!!! stoppp");
	}

	//remove the largest element of the heap (the root) and re-heapafy
	//5 points
	public void removeMax() 
	{
		if (arr[0] != 0)
		{
			arr[0] = arr[firstEmpty-1];
			arr[firstEmpty-1] = 0;//erase the deepest rightmost element so it can "switch" to the root position, as is done in the line above
			siftDown(0);
			firstEmpty--;
		}
		else
			System.out.println("No root!!! stoppp");
	}

	//this should check and alter the tree after an item is inserted
	//3 points
	private void siftUp(int index) 
	{
		while((arr[(index-1)/2] < arr[index]) && (index != 0))//while the parent of arr[index] is lesser than arr[index] AND index isn't the root, keep moving it up
		{
			int temp = arr[(index-1)/2];//set temp equal to value of parent element
			arr[(index-1)/2] = arr[index];//set parent's value equal to the value of its child (which is getting sifted up)
			arr[index] = temp;//Position previously occupied by the child is now occupied by former parent
			index = ((index-1)/2);//update index accordingly for while loop to worky
		}
	}

	//this should check and alter the tree after an item is deleted.
	//3 points
	private void siftDown(int index) 
	{
		int left = arr[(2*index)+1];
		int right = arr[(2*index)+2];
		
		while((left > arr[index]) || (right > arr[index]))//while the left child OR right child are greater than arr[index], the heap property is false so we must keep sifting down
		{
			//we want to pick the largest child to sift down with, so we check for both 1) which of the children is bigger and 2) whether they're bigger than arr[index] itself. This is assuming there are no duplicate nodes
			if((left > right) && (left > arr[index]))
			{
				int temp = arr[index];
				arr[index] = left;
				arr[(2*index)+1] = temp;
				index = (2*index)+1;
			}
				
			else if ((right > left) && (right > arr[index]))
			{
				int temp = arr[index];
				arr[index] = right;
				arr[(2*index)+2] = temp;
				index = (2*index)+2;
			}
			left = arr[(2*index)+1];
			right = arr[(2*index)+2];
			//update left and right accordingly for while loop to worky
		}
	}
}