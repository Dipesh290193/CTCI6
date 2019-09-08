package Ch19;

public class GenericMethodDemo {

	public static void main(String args[])
	{
		String[] strList={"Dipesh","Malav"};
		Integer[] intList={1,2,3};
		print(strList);
		print(intList);
	}
	public static <E> void print(E[] list)
	{
		for(int i=0;i<list.length;i++)
		{
			System.out.println(list[i]);
		}
	}
}
