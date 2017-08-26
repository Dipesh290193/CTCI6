package Ch18;

public class ArithmeticProgression {

	public static void main(String args[])
	{
		System.out.println("sum = "+sum(5));
	}
	public static int sum(int n)
	{
		if(n==1)
			return 1;//Base Case
		return n+sum(n-1);
	}
}
