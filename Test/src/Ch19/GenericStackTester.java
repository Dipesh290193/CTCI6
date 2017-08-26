package Ch19;

public class GenericStackTester {

	public static void main(String args[])
	{
		GenericStack<String> list=new GenericStack<>();
		list.push("Dipesh");
		list.push("Siddh");
		list.push("Malav");
		System.out.println(list.toString());
		System.out.println(list.getSize());
		System.out.println(list.isEmpty());
		System.out.println(list.pop());
		System.out.println(list.toString());
		GenericStack<Integer> listInt=new GenericStack<>();
		listInt.push(1);		
		
		//Raw type and Backward Compatibility
		//GenericStack list2=new GenericStack<String>();
		//list2.push("Dipesh");
		//list2.push(1);
	}
}
