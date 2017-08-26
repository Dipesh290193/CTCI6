package Ch20;

import java.util.*;

public class TestArrayListAndLinkedList {
	
	public static void main(String args[])
	{
		List<Object> arrayList=new ArrayList<>();
		arrayList.add(1);
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(0, 25);
		arrayList.add(2,50);
		System.out.println("A list of Integer in the array list");
		System.out.print(arrayList);
		
		System.out.println();
		
		LinkedList<Object> linkedList = new LinkedList<>(arrayList);
		linkedList.add(1,"Red");
		linkedList.removeLast();
		linkedList.addFirst("Green");
		
		System.out.println("Display LinkedList in Forward");
		ListIterator<Object> listIterator = linkedList.listIterator();
		
		while(listIterator.hasNext())
		{
			System.out.print(listIterator.next()+" ");
		}
		System.out.println();
		System.out.println(linkedList.get(1));
		System.out.println();
		System.out.println("Display LinkedList in backward");
		listIterator=linkedList.listIterator(linkedList.size());
		while(listIterator.hasPrevious())
		{
			System.out.print(listIterator.previous()+" ");
		}
		System.out.println();
		System.out.println(linkedList.get(1));
		
		arrayList.removeAll(linkedList);
		System.out.println(arrayList);
		
		/*arrayList.add(linkedList);
		System.out.println(arrayList);
		System.out.println(arrayList.get(arrayList.size()-1));*/
	}

}
