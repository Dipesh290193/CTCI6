package Ch24;

public class TestMyLinkedList {

	public static void main(String args[])
	{
		MyLinkedList<Integer> list=new MyLinkedList<>();
		list.add(2);
		System.out.println(list);
		list.add(0, 1);
		list.add(5,75);
		System.out.println(list);
		list.add(5);
		System.out.println(list);
		list.addFirst(-1);
		list.addLast(100);
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(2));
		System.out.println(list.remove(-1));
	}
}
