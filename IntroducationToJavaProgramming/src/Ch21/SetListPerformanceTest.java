package Ch21;

import java.util.*;

public class SetListPerformanceTest {
	static final int N=50000;
	public static void main(String args[])
	{
	  
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			list.add(i);
		}
		Collections.shuffle(list);
		
		Collection<Integer> hashSet=new HashSet<>(list);
		System.out.println("Member Hashset test time: " +getTestTime(hashSet));
		System.out.println("Remove HashTime Remove time: "+getRemoveTime(hashSet));
		
		Collection<Integer> linkedHashSet=new LinkedHashSet<>(list);
		System.out.println("member LinkedHashSet test Time: "+getTestTime(linkedHashSet));
		System.out.println("member LinkedHashset Remove Time: "+getRemoveTime(linkedHashSet));
		
		Collection<Integer> treeSet= new TreeSet<>(list);
		System.out.println("member Treeset test Time: "+getTestTime(treeSet));
		System.out.println("member TreeSet remove time: "+getRemoveTime(treeSet));
		
		Collection<Integer> arrayList=new ArrayList<>(list);
		System.out.println("member ArrayList test Time: "+getTestTime(arrayList));
		System.out.println("member ArrayList Remove Time: "+getRemoveTime(arrayList));
		
		Collection<Integer> linkedList=new LinkedList<>(list);
		System.out.println("member LinkedList test Time: "+getTestTime(linkedList));
		System.out.println("member LinkedList Remove Time: "+getRemoveTime(linkedList));
		
	}
	public static long getTestTime(Collection<Integer> c)
	{
		long startTime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
		{
			c.contains((int)Math.random()*2*N);
		}
		return System.currentTimeMillis()-startTime;
	}
	public static long getRemoveTime(Collection<Integer> c)
	{
		long startTime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
		{
			c.remove(i);
		}
		return System.currentTimeMillis()-startTime;
	}
}
