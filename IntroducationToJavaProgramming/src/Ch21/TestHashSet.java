package Ch21;

import java.util.*;

public class TestHashSet {
	
	public static void main (String args[])
	{
		HashSet<String> set= new HashSet<>();
		set.add("b");
		set.add("Dipesh");
		set.add("Meet");
		set.add("Dsp");		
		set.add("Dsp");
		set.add("dsp");
		set.add("a");
		set.add("c");
		
		System.out.println(set);
		for (String string : set) {
			System.out.print(string.toUpperCase()+" ");
		}
		System.out.println();
		System.out.println("Using iterator");
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
