package ConcurrentModificationErroSolution;

import java.util.*;

public class Solution {
    public static void main(String args[]){
       ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));
       Iterator<String> it = list.iterator();
       while(it.hasNext()){
            String s = it.next();
            if(s.equals("a")){
                it.remove();
            }
       }
       System.out.println(list.toString());
       Map<String, Integer> map = new HashMap<String, Integer>();
       map.put("Dipesh", 1);
       map.put("Harsh", 2);
       List<Map.Entry<String, Integer>> list1 = new ArrayList(map.entrySet());
       System.out.println(list1.get(0).getKey());
       Map m = Collections.unmodifiableMap(map);
    }
}
