package Ch10;


public class MyInteger {

	private int value;

	public MyInteger() {
		this(0);
	}

	public MyInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public boolean isEven() {
		if (this.value % 2 == 0) {
			return true;
		}
		return false;
	}

	public boolean isOdd() {
		if (this.value % 2 == 0) {
			return false;
		}

		return true;
	}

	public boolean isPrime() {
		for (int i = 2; i < this.value; i++) {
			if (this.value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEven(int value) {
		if (value % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean isOdd(int value) {
		if (value % 2 == 0) {
			return false;
		}
		return true;
	}

	public static boolean isPrime(int value) {
		for (int i = 2; i < value; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEven(MyInteger num) {
		if (num.value % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean isOdd(MyInteger num) {
		if (num.value % 2 == 0) {
			return false;
		}
		return true;
	}

	public static boolean isPrime(MyInteger num) {
		for (int i = 2; i < num.value; i++) {
			if (num.value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public boolean equals(int value) {
		if (this.value != value) {
			return false;
		}
		return true;
	}
	public boolean equals(MyInteger num)
	{
		if (num.value != this.value) {
			return false;
		}
		return true;
	}
	public static int parseInt(char[] ch)
	{
		int sum=0;
		for(int i=0;i<ch.length;i++)
		{
			sum+=Character.getNumericValue(ch[i])*(Math.pow(10,ch.length-(i+1)));
		}
		return sum;
	}
	public static int parseInt(String num)
	{
		int sum=0;
		for(int i=0;i<num.length();i++)
		{
			sum+=Character.getNumericValue(num.charAt(i))*(Math.pow(10,num.length()-(i+1)));
		}
		return sum;
	}

}
