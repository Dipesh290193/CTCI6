package ch8_RecursionAndDyanamicProgramming;

public class TripleStep {

	public static void main(String args[])
	{
		System.out.println(steps(10));
	}
	
	
	//Time complexity is O(n) because count save the computed values, So future we use same computation.
	//space complexity is O(n) because count consume n space to store the computation and recursion stack also consume n space
	// So n+n = 2n which is O(n)
	public static int steps(int n)
	{
		return steps(n, new int[n+1]);
	}
	private static int steps(int n, int[] count)
	{
		if(n == 0 || n == 1)
		{
			return 1;
		}
		if(n == 2)
		{
			return n;
		}
		if(count[n] == 0)
		{
			count[n] = steps(n-1, count) + steps(n-2, count) + steps(n-3, count);
		}
		return count[n];
		
	}
	
	
	//Time complexity is O(n)
	//Space complexity is constant O(1)
	public static int step(int n)
	{
		int a = 1,b = 1;
		int c = 2;
		for(int i = 3 ; i <= n ; i++)
		{
			int d = a+b+c;
			a = b;
			b = c;
			c = d;
		}
		return c;
	}
}
