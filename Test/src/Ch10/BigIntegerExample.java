package Ch10;

import java.math.BigInteger;

public class BigIntegerExample {

	public static void main(String args[])
	{
		BigInteger x= new BigInteger("3");
		BigInteger y= new BigInteger("5");
		BigInteger z=x.add(y);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
	}

}
