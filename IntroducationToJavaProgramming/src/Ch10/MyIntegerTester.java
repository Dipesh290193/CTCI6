package Ch10;

public class MyIntegerTester {

	public static void main(String args[])
	{
		MyInteger num=new MyInteger(11);
		System.out.println("Even: "+num.isEven());
		System.out.println("Odd: "+num.isOdd());
		System.out.println("Prime: "+num.isPrime());
		char[] ch={'1','2','3'};
		System.out.println(MyInteger.parseInt(ch));
		String str="123";
		System.out.println(MyInteger.parseInt(str));
	}
}
