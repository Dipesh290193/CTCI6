package Ractional;

public class RationalTester {

	public static void main(String args[])
	{
		Rational r1=new Rational(15, 60);
		Rational r2=new Rational(6,9);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r1.add(r2));
		System.out.println(r1.subtract(r2));
		
	}
}
