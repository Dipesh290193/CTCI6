package Ch9;

public class TestCircle {

	public static void main(String args[])
	{
		Circle c1=new Circle(10);
		Circle c2=new Circle(15);

		swap1(c1, c2);
		System.out.println("After swap1");
		System.out.println("Circle c1 radius= "+c1.radius);
		System.out.println("Circle c2 radius= "+c2.radius);
		
		swap2(c1,c2);
		System.out.println("After swap2");
		System.out.println("Circle c1 radius= "+c1.radius);
		System.out.println("Circle c2 radius= "+c2.radius);
	}
	public static void swap1(Circle c1,Circle c2)
	{
		Circle tem=c1;
		c1=c2;
		c2=tem;
	}
	public static void swap2(Circle c1, Circle c2)
	{
		double temp=c1.radius;
		c1.radius=c2.radius;
		c2.radius=temp;
	}
}
