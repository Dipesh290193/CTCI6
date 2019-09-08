package Ch20;

import java.util.*;
public class CollectionsStaticMethod {

	public static void main(String args[])
	{
		List<Integer> list= Arrays.asList(2,4,5,7,8,10,12,17);
		System.out.println("(1) Index: "+Collections.binarySearch(list, 7));
		System.out.println("(2) Index: "+Collections.binarySearch(list, 9));
		List<String> list2=Arrays.asList("blue","green","red");
		System.out.println("(3) Index: "+Collections.binarySearch(list2,"red"));
		System.out.println("(4) Index: "+Collections.binarySearch(list2,"black"));
		System.out.println(Collections.binarySearch(list2, "abc"));
		List<String> list3=Arrays.asList("White","Black","green","red");
		Collections.copy(list3, list2);
		System.out.println(list3);
		Collection<String> collection1=Arrays.asList("red","green");
		Collection<String> collection2=Arrays.asList("red","black");
		Collection<String> collection3=Arrays.asList("pink","abc");
		System.out.println(Collections.disjoint(collection1, collection2));
		System.out.println(Collections.disjoint(collection2,collection3));
		System.out.println(Collections.frequency(list3, "red"));
		
		List<String> list4=Arrays.asList("yellow","red","black","green");
		Collections.reverse(list4);
		System.out.println(list4);
		Collections.reverse(list4);
		System.out.println(list4);
	}
}
