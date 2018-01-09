package Test;

import java.util.*;

public class TopKFrquent {
    public static void main(String args[]){
        int[] nums = {1};
        topKFrequent(nums, 1);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if(k > nums.length){
            return null;
        }
        HashMap<Integer,Integer> map= new HashMap<Integer, Integer>();
        for(int i : nums){
            if(map.get(i) == null){
                map.put(i, 0);
            }
            map.put(i, map.get(i)+1);
        }

        Set<Integer>[] frequent = new Set[nums.length+1];
        for(int i : map.keySet()){
            int f = map.get(i);
            if(frequent[f] == null){
                frequent[f] = new HashSet<Integer>();
            }
            frequent[f].add(i);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = frequent.length-1; i >= k; i--){
            if(frequent[i] != null){
                result.addAll(frequent[i]);
            }
        }
        return result;
    }
}
