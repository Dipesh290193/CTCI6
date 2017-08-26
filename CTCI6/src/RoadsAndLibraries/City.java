package RoadsAndLibraries;

import java.util.HashSet;

public class City {

	int number;
	HashSet<Integer> connectedCity;
	boolean hasLibrary =false;
	
	public City(int number){
		this.number = number;
		connectedCity = new HashSet<Integer>();
	}

}
