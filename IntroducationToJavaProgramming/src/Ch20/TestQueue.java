package Ch20;
import java.util.*;
public class TestQueue {

	public static void main(String args[])
	{
		Queue<String> queue =new LinkedList<>();
		queue.offer("Dipesh");
		queue.offer("Dsp");
		queue.offer("Sidd");
		queue.offer("meet");
		
		while(queue.size()>0)
		{
			System.out.println(queue.remove());
		}
	}
}
