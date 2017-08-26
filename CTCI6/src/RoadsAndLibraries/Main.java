package RoadsAndLibraries;

import java.util.HashSet;

public class Main {

	public static void main(String args[]){
		int cLib = 2;
		int cRoad = 1;
		int city = 3;
		int roads = 3;
		Graph g = new Graph();
		g.addCity(1);
		g.addCity(2);
		g.addCity(3);
		
		g.addRoads(1, 2);
		g.addRoads(3, 1);
		g.addRoads(2, 3);
		
		if(cRoad >= cLib){
			System.out.println(cLib*city);
		}
		else{
		System.out.println(findMinCost(g, cLib, cRoad));
		}
	}
	
	public static int findMinCost(Graph g, int cLib,int cRoad){
		int minCost = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int i : g.cities.keySet()){
			if(!visited.contains(i)){
				int cost = findMinPath(g, g.cities.get(i), visited);
				minCost+=(cost-1)*cRoad;
				cost+=cLib;
			}
		}
		return minCost;
	}
	
	public static int findMinPath(Graph g, City city, HashSet<Integer> visited){
		int count = 1;
		visited.add(city.number);
		for(int c: city.connectedCity){
			if(!visited.contains(c)){
				count+=findMinPath(g, g.cities.get(c), visited);
			}
		}
		return count;
	}
	
}
