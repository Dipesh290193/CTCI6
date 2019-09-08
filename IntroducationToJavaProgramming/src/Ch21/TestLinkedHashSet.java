package Ch21;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String args[])
	{
		Set<String> set= new LinkedHashSet<>();
		
		set.add("Dharshan"); 
		set.add("Dsp");
		set.add("Dipesh");
		set.add("Meet");
		set.add("Sidd");
		for(String str: set)
		{
			System.out.println(str);
		}
		
		
		LinkedHashSet<String> linkedSet=new LinkedHashSet<>(set);
		for(String str:linkedSet)
		{
			System.out.println(str);
		}
		System.out.println(set.equals(linkedSet));
		System.out.println(set.hashCode()== linkedSet.hashCode());
	}
}
