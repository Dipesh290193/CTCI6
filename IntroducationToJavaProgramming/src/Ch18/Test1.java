package Ch18;

public class Test1 {

	public static void main(String args[])
	{
		xmethod(1234567);
	}
	public static void xmethod(int n)
	{
		if(n > 0)
		{
			System.out.println(n);
			xmethod(n/10);
		}
	}
}
