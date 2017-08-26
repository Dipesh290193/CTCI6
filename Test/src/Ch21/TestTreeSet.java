package Ch21;

import java.util.*;

public class TestTreeSet {

	public static void main(String args[])
	{
		Set<Integer> set=new HashSet<>();
		set.add(10);
		set.add(15);
		set.add(5);
		set.add(0);
		set.add(-5);
		set.add(20);
		
		TreeSet<Integer> treeSet=new TreeSet<>(set);
		System.out.println(	"Sorted Tree set:" +treeSet);
		
		System.out.println("First():"+treeSet.first());
		System.out.println("Last():"+treeSet.last());
		System.out.println("HeadSet(10):"+treeSet.headSet(10));
		System.out.println("tailSet(10):" +treeSet.tailSet(10));
		System.out.println("lower(2):"+treeSet.lower(2));
		System.out.println("Higher(2):"+treeSet.higher(2));
		System.out.println("Floor(2):"+treeSet.floor(2));
		System.out.println("ceiling(2):" +treeSet.ceiling(2));
		System.out.println("pollFirst():" +treeSet.pollFirst());
		System.out.println("pollLast:"+treeSet.pollLast());
		System.out.println("New Tree Set:"+treeSet);
		
	}
}
