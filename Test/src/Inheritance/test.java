package Inheritance;

public class test {

	public static void main(String args[])
	{
		Fruit fruit=new Fruit();
		Orange orange=new Orange();
		System.out.println("--------------------");
		System.out.println(fruit instanceof Apple);
		System.out.println(orange instanceof Fruit);
		System.out.println(fruit instanceof McIntoSh);
		
		GoledenDelicious g= new GoledenDelicious();
		g.color();
		Fruit f=new Apple();
	
		System.out.println();
		McIntoSh m=new McIntoSh();
		m.color();
		
	}
}
