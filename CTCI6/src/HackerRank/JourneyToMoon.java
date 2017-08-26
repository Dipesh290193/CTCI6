package HackerRank;

import java.util.HashMap;
import java.util.HashSet;

public class JourneyToMoon {
	
	public static void main(String args[]){
		int N = 4;
		World w = new World();
		for(int i = 0 ; i < N ; i++){
			w.addSci(i);
		}
		
		//w.addContry(0, 1);
		//w.addContry(0, 4);
		w.addContry(0, 2);
		HashSet<Integer> visited = new HashSet<Integer>();
		 long combinations = 0;	
		 int ways = 0;
		for(int i : w.sci.keySet()){
			if(!visited.contains(i)){
				int count = count(w, w.sci.get(i), visited);
				combinations+=(count*ways);
				ways+=count;
			}
		}
			
		 System.out.println(combinations);
		
	}
	
	public static int count(World w, Scientist s, HashSet<Integer> visited){
		int count = 1;
		visited.add(s.number);
		for(int i: s.scientists){
			if(!visited.contains(i)){
				count+=count(w, w.sci.get(i), visited);
			}
		}
		return count;
	}
}

class World {
	HashMap<Integer, Scientist> sci;

	public World(){
		sci = new HashMap<Integer, Scientist>();
	}

	public void addSci(int cityNumber) {
		Scientist city = new Scientist(cityNumber);
		sci.put(cityNumber, city);
	}

	public void addContry(int s1, int s2) {
		sci.get(s1).scientists.add(s2);
		sci.get(s2).scientists.add(s1);
	}
}

class Scientist {

	int number;
	HashSet<Integer> scientists;

	public Scientist(int number) {
		this.number = number;
		scientists = new HashSet<Integer>();
	}

}
