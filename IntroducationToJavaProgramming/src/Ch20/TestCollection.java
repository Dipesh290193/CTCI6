package Ch20;

import java.util.ArrayList;

public class TestCollection {

	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		ArrayList<String> collection1=new ArrayList<>();
		collection1.add("Dipesh");
		collection1.add("Sidd");
		collection1.add("Darshan");
		collection1.add("Dipak");
		System.out.println("Print all elements in collection1");
		System.out.print(collection1);
		System.out.println("\nIs Dipak in the collection?");
		System.out.print(collection1.contains("Dipak"));
		collection1.remove("Dipak");
		System.out.println(collection1);
		
		ArrayList<String> collection2 =new ArrayList<>();
		collection2.add("Meet");
		collection2.add("Dhruv");
		collection2.add("Dipesh");
		
		ArrayList<String> c1=(ArrayList<String>)collection1.clone();
		c1.addAll(collection2);
		System.out.println(c1);
		
		c1=(ArrayList<String>)collection1.clone();
		c1.retainAll(collection2);
		System.out.println(c1);	
		
		c1=(ArrayList<String>)collection1.clone();
		c1.removeAll(collection2);
		System.out.println(c1);
	}
}
