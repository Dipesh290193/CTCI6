package SingletonEnum;

public class TestCar {

	public static void main(String args[]){
		Car c =Car.INSTANCE;
		c.setColor("YELLOW");
		c.getColor();
	}
}
