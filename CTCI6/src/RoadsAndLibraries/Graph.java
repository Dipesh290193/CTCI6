package RoadsAndLibraries;

import java.util.HashMap;

public class Graph {

	HashMap<Integer, City> cities;
	
	public Graph(){
		cities = new HashMap<Integer, City>();
	}
	
	public void addCity(int cityNumber){
		City city = new City(cityNumber);
		cities.put(cityNumber, city);
	}
	
	public void addRoads(int cityNumber1, int cityNumber2){
		/*if(!cities.containsKey(cityNumber1) || !cities.containsKey(cityNumber1)){
			throw new Exception("City not found");
		}*/
		cities.get(cityNumber1).connectedCity.add(cityNumber2);
		cities.get(cityNumber2).connectedCity.add(cityNumber1);
	}

}
