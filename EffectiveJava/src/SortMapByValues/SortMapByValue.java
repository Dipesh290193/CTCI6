package SortMapByValues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SortMapByValue {
    public static void main(String args[]){
        List<String> list= new CopyOnWriteArrayList<String>();
        HashMap<String, Integer> map =new HashMap<>();
        map.put("v",10);
        map.put("b",20);
        map.put("a", 30);
        System.out.println(map);

        TreeMap<String,Integer> sortedValue = new TreeMap<>(new ValueComparator<String, Integer>(map));
        sortedValue.putAll(map);
        System.out.println(sortedValue);
    }
}

class ValueComparator<K,V extends Comparable<V>> implements Comparator<K> {
    HashMap<K,V> map =new HashMap<>();
    public ValueComparator(HashMap<K,V> map){
        this.map.putAll(map);
    }

    @Override
    public int compare(K s1, K s2){
        return map.get(s1).compareTo(map.get(s2));
    }
}
