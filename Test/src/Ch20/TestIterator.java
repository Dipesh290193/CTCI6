package Ch20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestIterator {

	public static void main(String args[])
	{
		Collection<String> collection=new ArrayList<>();
		collection.add("New york");
		collection.add("California");
		collection.add("Chicago");
		
		Iterator<String> iterator=collection.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
