package Ch24;

public class TestGenericQueue {

	public static void main(String args[])
	{
		GenericQueue<String> queue=new GenericQueue<>();
		queue.enqueue("Dsp");
		queue.enqueue("Dipesh");
		queue.enqueue("Sidd");
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
				
	}
}
