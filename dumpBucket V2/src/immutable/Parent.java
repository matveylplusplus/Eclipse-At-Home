package immutable;
/*
 *DO NOT CHANGE!!!!!!!!!!!!!!!!!!!!! 
 *!!!!!!!!! 
 *!!!!!!!!!!!
 *!!!!!!!!!!!!
 *I linked this on gitghub to illustrate a very important concept
 */
public class Parent extends Object
{	
	String IdentityStr;
	public static void main (String[] Args)
	{
		
		Parent[] parray;//object of compile-time type array is declared, and memory is allocated for a reference value. This reference value currently does not exist, even in null form. 
//		System.out.println(parray);//doesn't compile; reference value isn't even initialized to null because parray is local
		
		//Now, to explain typing beyond just the surface, we have to ditch the words "compile-time type" and "run-time type" a little bit. 
		//"Parent" indicates that the COMPONENT TYPE of all elements is Parent. This is like a contract that says "okay, all my elements' compile-time types must be exactly this type or lower in the inheritance path (if component type is an object), and if not, I'm going to complain." It is regulating the ELEMENT TYPES, which is specific to each element and composed of element-specific compile-time and run-time types. So in this case, we are declaring that every element must have compile-time type Parent or Child.
		
		parray = new Parent[3];//instantiates array object whose elements all have the compile-time type Parent. This follows the contract set by the component type earlier. 
		System.out.println(parray);//parray's reference value is now initialized to point to array object in heap, whose elements are initialized to default values because the JLS says so (Section 4.12.5). Because elements were declared as compile-time type Parent (a reference type), and the default value for a reference type is null, every element is initialized to null. Thus, no run-time type exists for any of these elements as of this point as the objects themselves don't exist
		print1D(parray);//prints [null|null|null]
//		parray[1].printParent();//this is compiler-legal because component type is Parent, but causes a run-time error because parray[1] is currently a null reference and not an instantiated Parent or Child. no method can be invoked
		parray[1] = new Parent();//instantiates Parent object and tells its reference value to overwrite parray[1]'s null reference. run-time type of parray[1] therefore becomes Parent
		System.out.println();
		print1D(parray);//prints [null|immutable.Parent@1ce92674|null] *hash codes obviously change every time this is run*
		parray[0] = new Child();//instantiates Child object and tells its reference value to overwrite parray[0]'s null reference. run-time type of parray[0] therefore becomes Child
		System.out.println();
		print1D(parray);//prints [immutable.Child@6fd02e5|immutable.Parent@1ce92674|null]
		
		parray = new Child[3];//instantiates array object whose elements all have the compile-time type Child. This also follows the contract set by the component type earlier. 
		print1D(parray);//prints [null|null|null]
		
		System.out.println();
//		parray[1] = new Parent();//causes run-time error; parray[1] wants to have run-time type Parent but compile-time type of ALL elements was already set as Child in line 32. 
		parray[0] = new Child();//instantiates Child object and tells its reference value to overwrite parray[0]'s null reference. run-time type of parray[0] therefore becomes Child
//		parray[0].printChild();//this is compiler-illegal because component type of the array is Parent. The compiler doesn't care that the element's compile-time type AND run-time type is Child; it pays attention ONLY to the component type declared in line 15 when it comes to invoking methods
		System.out.println();
		print1D(parray);//prints [immutable.Child@6fd02e5|null|null]
		
		Parent[] parray2 = {new Parent(), new Child(), new Child()};//In this instance, the array's component type is still Parent, but each element's compile-time type is ALSO its run-time type.
		parray2[1] = new Parent();//However, initializing an array this way also means the compile-time type of each element isn't "locked" like it was in line 36. That means this statement doesn't cause a run-time error because we never indicated "hey, all elements in this array MUST have compile-time type x"
		
		Object obj = parray;//this is legal btw. even tho an array isnt a class at all. read Section 10 of JLS
	}
	
	public static void print1D(Object[] arr)
	{
		System.out.print("[");
		for(int i = 0; i < arr.length; i++)
		{
			if (i > 0)
				System.out.print("|");
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}
	
	public Parent()
	{
		IdentityStr = "Parent!";
	}
	
	private void printParent()
	{
		System.out.println("You are Parent z");
	}
}

class Child extends Parent
{
	boolean cheese;
	
	public Child()
	{
		IdentityStr = "Child!";
	}
	
	public void printChild()
	{
		System.out.println("cheese = " + cheese);
	}
}
