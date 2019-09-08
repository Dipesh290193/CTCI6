package Ch10;

public class Person {

	Person()
	{
		System.out.println("In Person");
	}
	public String getInfo()
	{
		return "Person";
	}
	
	public void printPerson()
	{
		System.out.println(getInfo());
	}
}
