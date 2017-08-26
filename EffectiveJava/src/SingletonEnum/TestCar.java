package SingletonEnum;

public class TestCar {

	public static void main(String args[]){
		Car c =Car.INSTANCE;
		c.setColor("Blue");
		Car car = Car.INSTANCE;
		car.setColor("YELLOW");
		
		System.out.println(c.getColor());
		System.out.println(car.getColor());
	}
}
