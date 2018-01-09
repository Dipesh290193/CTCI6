package Test;

import java.util.*;

public class LongestWordDictionary {
    public static void main(String args[]){
        List<String> d = new ArrayList<>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        d.add("b");
       System.out.println(findLongestWord("bab", d));
        System.out.println("ba".compareTo("ab"));
    }

    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        for(int i = 0 ; i < d.size(); i++){
            if(isMatch(s, d.get(i)))
            {
                if(result.length() < d.get(i).length()){
                    result = d.get(i);
                }
                else if(result.length() == d.get(i).length()){
                    result = result.compareTo(d.get(i))  < 0 ? result : d.get(i);
                }
            }
        }
        return result;
    }

    public static boolean isMatch(String s1, String s2){
        int i = 0 , j = 0;
        for(; i < s1.length() && j < s2.length();){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(i >= s1.length() && s1.length() != s2.length()){
            return false;
        }
        return true;
    }
}
