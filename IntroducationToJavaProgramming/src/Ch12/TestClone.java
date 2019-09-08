package Ch12;

import java.util.Date;

public class TestClone implements Cloneable, Comparable<TestClone>{

	public static void main(String args[])
	{
		Date date=new Date();
		Date d=date;
		Date d2=(Date) d.clone();
		System.out.println(date==d);
		System.out.println(date==d2);
		System.out.println(date.equals(d2));
	}

	@Override
	public int compareTo(TestClone o) {
		return 0;
	}
}
