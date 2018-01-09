package Test;

import java.util.*;

public class FindDistance {

    public static void main(String args[]){
        List<List<Integer>> allLocations = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(4);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(-1);
        allLocations.add(l);
        allLocations.add(l1);
        allLocations.add(l2);
        closetDistance(3,allLocations,2);
    }

    public static List<List<Integer>> closetDistance(int totalCrates, List<List<Integer>> allLocations, int truckCapacity){
        TreeMap<Double,List<Integer>> distances = new TreeMap<>();
        for(List<Integer> loction : allLocations){
            double distance = Math.sqrt((loction.get(0)* loction.get(0))+ (loction.get(1)*loction.get(1)));
            distances.put(distance,loction);
        }
        List<List<Integer>> result = new ArrayList<>();
        Iterator iterator = distances.entrySet().iterator();
        while(truckCapacity > 0 && iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            ArrayList<Integer> d = new ArrayList<Integer>((List<Integer>)entry.getValue());
            result.add(d);
            truckCapacity--;
        }
        return result;
    }
}
