package Ch20;
import java.util.*;
public class PriorityQueueDemo {

	public static void main(String args[])
	{
		PriorityQueue<String> q1=new PriorityQueue<>();
		q1.offer("z");
		q1.offer("b");
		q1.offer("a");
		q1.offer("b");
		
		while(q1.size()>0)
		{
			System.out.println(q1.remove());
		}
		
		PriorityQueue<String> q2=new PriorityQueue<>(4,Collections.reverseOrder());
		q2.offer("meet");
		q2.offer("darshan");
		q2.offer("sidd");
		q2.offer("dip");
		
		while(q2.size()>0)
		{
			System.out.println(q2.remove());
		}
		
		PriorityQueue<Integer> q3=new PriorityQueue<>();
		q3.offer(25);
		q3.offer(2);
		q3.offer(0);
		q3.offer(-1);
		
		while(q3.size()> 0)
		{
			System.out.println(q3.remove());
		}
	}
}
