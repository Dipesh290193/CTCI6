package ch7_ObjectOrientedDesign;

import java.util.List;

public class ParkingLot {

	private Level[] levels;
	
}
enum VehicleSize
{
	Motorcycle, Compact, Large
}
abstract class Vehicle
{
	protected List<ParkingSpot> parkingSopt;
	protected String licensePlate;
	protected int spotsNeed;
	protected VehicleSize size;
}

class Bus extends Vehicle{
	public Bus()
	{
		this.size = VehicleSize.Large;
		this.spotsNeed = 5;
	}
}

class Car extends Vehicle{
	public Car()
	{
		this.size = VehicleSize.Compact;
		this.spotsNeed = 1;
	}
}

class Motorcycle extends Vehicle{
	public Motorcycle()
	{
		this.size = VehicleSize.Motorcycle;
		this.spotsNeed = 1;
	}
}

class ParkingSpot{
	private Vehicle vehicle;
	private VehicleSize vehicleSize;
	private int row;
	private int spotNumber;
	private Level level;
}

class Level{
	private int floor;
	private ParkingSpot[] parkingSpots;
	private int availableSpots;
}
