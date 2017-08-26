package ch8_RecursionAndDyanamicProgramming;

public class RecursiveMultiply {

	public static void main(String args[])
	{
		System.out.println(recursiveMultiply(11, 110));
	}
	
	public static int recursiveMultiply(int a , int b)
	{
		if( a == 0 || b == 0)
			return 0;
		if( a < b)
			return multiply(b, a);
		return multiply(a, b);
	}
	
	//Time complexity is O(logb) where b is smallest of two numbers
	public static int multiply(int a , int b)
	{
		if( b == 1)
			return a;
		if(b % 2 == 0)
			return  multiply(a, b >> 1) << 1;
		return a + multiply(a, b-1);
	}
}
