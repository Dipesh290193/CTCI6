package HackerRank;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {

	public static void main(String[] args) {
        String s = "ab";
        HashSet<Character> set = new HashSet<Character>();
        HashSet<Character> repeatSet = new HashSet<Character>();
        for(int i = 0 ; i < s.length()-1; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if(a == b){
                set.remove(a);
                repeatSet.add(a);
            }
            else
            {
	            if(!repeatSet.contains(a)){
	                set.add(a);
	            }
	            if(!repeatSet.contains(b)){
	                set.add(b);
	            }
	        }
        }
        int maxLength = 0;
        if(set.size() > 1){
            ArrayList<Character> list = new ArrayList<Character>(set);

            for(int i = 0 ; i < list.size()-1; i++){
                for(int j = i+1 ; j < list.size(); j++){
                   String str =  makeString(s, list.get(i), list.get(j));
                   if(check(str,list.get(i), list.get(j)) && str.length()>maxLength){
                           maxLength = str.length();
                   }
                }
           }
        }
        
        System.out.println(maxLength);
    }
    
    public static String makeString(String s, char a, char b){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == a || c == b){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static boolean check(String s, char a, char b){
        if(s.isEmpty()){
            return false;
        }
        boolean bolA = s.charAt(0) == a ? false : true;
        boolean bolB = s.charAt(0) == b ? false : true;
        
        for(int i = 1; i < s.length(); i++)
        {
            if(bolA && s.charAt(i) == a){
                bolA = false;
                bolB = true;
            }
            else if(bolB && s.charAt(i) == b){
                bolB = false;
                bolA = true;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
