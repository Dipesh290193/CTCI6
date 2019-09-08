package Ch9;

public class Circle {
	
	double radius;
	public static final double PI=3.14;
	Circle(double r)
	{
		this.radius=r;
	}	
	public double getArea()
	{
		return PI*radius*radius;
	}
}
