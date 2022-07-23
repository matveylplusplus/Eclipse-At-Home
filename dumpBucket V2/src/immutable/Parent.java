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
		//Situation 1
		int[] arr1; 
		//Declaration: memory is allocated for reference value that links to (currently nonexistent) object in heap. This object's compile-time type is declared to be the reference type array, as indicated by '[]'; similar to a primitive in the sense that if compile-time type is array then run-time type CANNOT be different or can be considered to not exist at all. this is one of the reasons array is a special kind of object
		//array ELEMENTS have their own compile/run-time types however. 'int' in the declaration indicates that every element will have compile-time type int.
		
		arr1 = new int[4]; 
		//Instantiation: instantiate object of run-time type array in heap, where every element in the array is of run-time type int using an Array Creation Expression.
		//because compile-time type of the elements is primitive, run-time type CANNOT be written differently here... 
		arr1 = new boolean[4];
		//otherwise compiler will ree
		
		//default initialization takes place, so printing arr1 yields [0|0|0|0]; default values for int
		
		
		//Situation 2
		Parent Parent1 = new Parent();
		Parent[] arr4 = new Parent[5]; 
		//compile-time type of object (and the ONLY type) is reference type array. 'Parent' in declaration indicates every element has compile-time type Parent, and compiler will treat elements as such. 
		arr4[0].printParent();//method written in Parent; runs despite arr4[0] being null
		
		arr4[0].printChild();//method written in Child; won't run because compile-time type of array is Parent. Not type safe
		arr4[1].printChild();//method written in Child
		//compiler reeee
		
		//Because this is an object of compile-time type array and elements are of compile-time type Parent(an object), the elements' run-time types are actually set to be the null type by default; this is the 3rd type next to primitive and reference types, and represents the complete absence of information. The null type is not an object; it doesn't have a class.
		//default initialization takes place, so printing arr4 yields [null|null|null|null]; default values for any object
		//We can still instantiate null types into objects like so...
		arr4[0] = new Parent();
		arr4[0] = new Child();

		System.out.println("arr4[0] = " + arr4[0].IdentityStr);//prints "arr4[0] = parent"
		System.out.println("arr4[1] = " + arr4[1].IdentityStr);//prints "arr4[1] = child"
		//Once instantiation completes in both situations, the array�s memory address (reference value) is written to the stack memory we allocated during declaration
	}
	
	public Parent()
	{
		IdentityStr = "Parent!";
	}
	
	public void printParent()
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
