package Ractional;

public class Rational implements Comparable<Rational>{

	private long numerator;
	private long denominator;
	
	public Rational()
	{
		this(0,1);
	}
	public Rational(long numerator,long denominator)
	{
		long gcd= gcd(numerator,denominator);
		this.numerator=(numerator>0?1:-1)*(numerator/gcd);
		this.denominator=denominator/gcd;
	}
	
	public long gcd(long n,long d)
	{
		long n1=Math.abs(n);
		long d1=Math.abs(d);
		int gcd=1;
		
		for(int i= 1; i<=n1 && i<=d1 ;i++)
		{
			if(n1%i==0 && d1%i==0)
			{
				gcd=i;
			}
		}
		return gcd;
	}
	public long getNumerator()
	{
		return this.numerator;
	}
	public long getDenominator()
	{
		return this.denominator;
	}
	public Rational add(Rational secondRational)
	{
		long numerator=(this.numerator*secondRational.denominator)+(this.denominator*secondRational.numerator);
		long denominator=this.denominator*secondRational.denominator;
		return new Rational(numerator,denominator);
	}
	public Rational subtract(Rational secondRational)
	{
		long numerator=(this.numerator*secondRational.denominator)-(this.denominator*secondRational.numerator);
		long denominator=this.denominator*secondRational.denominator;
		return new Rational(numerator,denominator);
	}
	public Rational multiply(Rational secondRational)
	{
		long numerator=(this.numerator*secondRational.numerator);
		long denominator=this.denominator*secondRational.denominator;
		return new Rational(numerator,denominator);
	}
	public Rational divide(Rational secondRational)
	{
		long numerator=(this.numerator*secondRational.denominator);
		long denominator=this.denominator*secondRational.numerator;
		return new Rational(numerator,denominator);
	}
	@Override
	public String toString()
	{
		return (String) ((this.denominator == 1) ? this.numerator:this.numerator+"/"+this.denominator);
	}
	@Override
	public int compareTo(Rational o) {
		if(this.subtract(o).numerator>0)
			return 1;
		
		else if(this.subtract(o).numerator<0)
		return -1;
		
		else
			return 0;
	}
}
