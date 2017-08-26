import java.util.Date;

public class DateExample {

	public static void main(String args[])
	{
		Date date=new Date(123456);
		System.out.println(date.getDate());
		m1(date);
		System.out.println(date.getDate());
	}
	
	public static void m1(Date d)
	{
		d=null;
	}
}
