package cmsc131;

public interface Animal 
{
	public String getName();
	public void setName(String s);
	public String makeSound();
	public String toString();
}

class Cat implements Animal
{
	private String name;
	private int miceCaught;
	public static void main(String[] args)
	{
		Cat Ronald = new Cat("Ronald");
		System.out.println("Ronald's name = " + Ronald.getName());
		System.out.println("Ronald's mice count = " + Ronald.getMouseCount());
		System.out.println(Ronald.makeSound());
		Ronald.caughtAnother();
		System.out.println("Ronald's mice count = " + Ronald.getMouseCount());
		
		System.out.println();
		System.out.println("Ronald is being duplicated...");
		System.out.println(Ronald.makeSound());
		Cat Ronald2 = new Cat(Ronald);
		
		System.out.println("Ronald2's name = " + Ronald2.getName());
		System.out.println("Ronald2's mice count = " + Ronald2.getMouseCount());
		System.out.println(Ronald2.makeSound());
		Ronald2.caughtAnother();
		System.out.println("Ronald2's mice count = " + Ronald2.getMouseCount());

	}
	
	public Cat(String n)
	{
		setName(n); 
		setMouseCount(0);
	}
	
	public Cat (Cat c)
	{
		setName(c.getName());
		setMouseCount(c.getMouseCount());
	}
	
	@Override
	public String getName() 
	{
		return name;
	}
	
	@Override
	public void setName(String s) 
	{
		name = s;
	}
	
	@Override
	public String makeSound() 
	{
		return "MEEEEEEEEEEEEEEOOOOOOOOOOOOOOOOOOOOOOOO";
	}
	
	public void caughtAnother()
	{
		setMouseCount(getMouseCount()+1);
	}
	
	private void setMouseCount(int m)
	{
		miceCaught = m;
	}
	
	public int getMouseCount()
	{
		return miceCaught;
	}
}