package src.Visa;

import java.util.*;

public class Solution2 {
    public static void main(String arsg[]){
        /*String[] u = {"Dipesh","DSP", "Dipesh","DSP", "DSP", "DSP", "Dipesh"};
        System.out.print(usernameSystem(Arrays.asList(u)));*/
        print();
    }

    public static List<String> usernameSystem(List<String> u){
        Map<String, Integer> counts = new HashMap<>();
        List<String> usernames = new ArrayList<>();
        for(String username: u){
            Integer count = counts.get(username);
            if(count == null || count == 0) {
                usernames.add(username);
                counts.put(username, 1);
            }else{
                usernames.add(username+count);
                counts.put(username, ++count);
            }

        }
        return usernames;
    }

    public static void print(){
        int[] fid = {1,1,2,3,5,8,13,21,34,55};
        int q = 10;
        int lo = 0, hi = 8;
        while(lo < hi){
            int mid = (lo + hi) /2;
            if(q < fid[mid]){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        System.out.print(lo);
    }

}
