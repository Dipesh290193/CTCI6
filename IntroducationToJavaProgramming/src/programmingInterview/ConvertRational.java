package programmingInterview;

public class ConvertRational {

	public static void main(String args[])
	{
		System.out.println(getRational(0.125));
	}
	public static String getRational(double a)
	{
		int tenPoly=1;
		while(a*tenPoly - (int)(a*tenPoly) != 0)
		{
			tenPoly*=10;
		}
		int gcd=0;
		int divident=(int)(a*tenPoly);
		int divisor=tenPoly;
		if(divident>divisor) 
			gcd=GCD(divident,divisor);
		else
			gcd=GCD(divisor,divident);
		divident/=gcd;
		divisor/=gcd;
		String result=divident+"/"+divisor;
		return result;
	}
	private static int GCD(int a, int b)
	{
		int reminder=a%b;
		if(reminder==0)
			return b;
		else
			return GCD(b,reminder);
	}
}
