package Ch10;

public class TestString {

	public static void main(String args[])
	{
		System.out.println("Hi, ABC, good".matches("ABC "));
		System.out.println("Hi, ABC, good".matches(".*ABC*. "));
		System.out.println("A,B;C".replaceAll(",;", "#"));
		System.out.println("A,B;C".replaceAll("[,;]", "#"));
		
		String token[]="A,B;C".split("[,;]");
		for(int i=0;i<token.length;i++)
		{
			System.out.println(token[i]+" ");
		}
		
		//Object[] foo= new Object[50];
	}
}
