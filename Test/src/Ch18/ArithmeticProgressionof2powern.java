package Ch18;



public class ArithmeticProgressionof2powern {

	public static void main(String args[])
	{
		System.out.println(sum(2));
	}
	public static int sum(int n)
	{
		if(n==0)
			return 1;
		return (int)Math.pow(2, n)+sum(n-1);
	}
}
