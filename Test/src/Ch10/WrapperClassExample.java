package Ch10;

public class WrapperClassExample {

	public static void main(String args[])
	{
		Integer in=new Integer("5");
		System.out.println(in);
		Integer i=new Integer(5);
		System.out.println(i);
		Integer intg=Integer.valueOf(6);
		System.out.println(intg);
		int inu=(Double.valueOf("26.5")).intValue();
		System.out.println(in.compareTo(new Integer(8)));
		System.out.println(inu);
		int f=new Integer(5)+new Integer(6);
		System.out.println(f);
		Double d=3.6;
		System.out.println(d.intValue());
		System.out.println(d.compareTo(4.5));
		
	}
}
