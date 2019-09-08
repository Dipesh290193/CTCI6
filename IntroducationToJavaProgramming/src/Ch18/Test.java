package Ch18;

public class Test {

	public static void main(String args[])
	{
		xmethod(123456);
	}
	public static void xmethod(int n)
	{
		//no base case
		if(n>0)
		{
			System.out.println(n % 10);
			xmethod(n % 10);
		}
	}
}
