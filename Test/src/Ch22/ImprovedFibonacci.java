package Ch22;

import java.util.*;

public class ImprovedFibonacci {

	public static void main(String args[])
	{
		Scanner out=new Scanner(System.in);
		System.out.println("Enter Index number");
		int index=out.nextInt();
		System.out.println("Fibonacci number at index: "+fib(index));
		out.close();
	}
	
	public static long fib(int n)
	{
		long f0=0;
		long f1=1;
		long f2=1;
		
		if(n==0)
		{
			return f0;
		}
		else if(n==1)
		{
			return f1;
		}
		else if(n==2)
		{
			return f2;
		}
		else
		{
			for(int i=3;i<=n;i++)
			{
				f0=f1;
				f1=f2;
				f2=f0+f1;
			}
		}
		return f2;
	}
}
