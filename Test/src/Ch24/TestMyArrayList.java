package Ch24;

public class TestMyArrayList {

	public static void main(String args[])
	{
		
		MyArrayList<Integer> list=new MyArrayList<>();
		list.add(5);
		list.trimToSize();
		list.add(10);
		list.add(-1);
		list.add(23);
		list.add(0, 0);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		System.out.println(list.get(3));
		System.out.println(list.indexOf(4));
	}
}
