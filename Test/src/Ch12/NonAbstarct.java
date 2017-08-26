package Ch12;


public class NonAbstarct {

	public static void main(String args[])
	{
		Number x=new Integer(10);
		System.out.println(x.intValue());
		System.out.println(((Integer)x).compareTo(new Integer(4)));
		
		Integer in=new Integer(15);
		System.out.println(in instanceof Object);
		//Geometric g=new Circle();
		main(null);
	}
}
