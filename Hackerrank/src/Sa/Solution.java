package Sa;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void main(String args[]){
		System.out.println(solution("23:59"));
	}
	static int min = Integer.MAX_VALUE;
	 public static String solution(String S) {
	        // write your code in Java SE 8
	        String[] hourMin = S.split(":");
	        
	        int hour = Integer.parseInt(hourMin[0]);
	        int min = Integer.parseInt(hourMin[1]);
	        
	        char[] numbers = {hourMin[0].charAt(0), hourMin[0].charAt(1), hourMin[1].charAt(0), hourMin[1].charAt(1)};
	        
	        Set<String> possibleNumbers = permutation(numbers);
	       
	        
	        int minutes = Integer.MAX_VALUE;
        	String m = "";
        	for(String i :possibleNumbers){
        		int j = Integer.parseInt(i);
        		if(j > min && j <= 59){
        			if(j < minutes){
        				minutes = j;
        				m = i;
        			}
        		}
        	}
        	
        	if(minutes == Integer.MAX_VALUE){
        		
        		int hours = Integer.MAX_VALUE;
            	String h = "";
            	for(String i :possibleNumbers){
            		int j = Integer.parseInt(i);
            		if(j > hour && j <= 23){
            			if(j < minutes){
            				hours = j;
            				h = i;
            			}
            		}
            	}
            	int minimum = min(new int[]{hour/10,hour%10, min/10,min%10});
            	if(hours == Integer.MAX_VALUE){
            		return minimum+""+minimum+":"+minimum+""+minimum;
            	}
            	
            	else{
            		return h+":"+minimum+""+minimum;
            	}
        	}
        	else{
        		return hour+":"+m;
        	}
        	
        	
	    }
	 
	 
	 public static Set<String> permutation(char[] numbers){
		 
		 Set<String> sets = new HashSet<String>();
		 for(int i = 0 ; i < numbers.length; i++){
			 for(int j = 0; j < numbers.length; j++){
				sets.add(numbers[i]+""+numbers[j]);
			}
		 }
		 
		 return sets; 
	 }
	 
	 public static int min(int[] numbers){
		 
		 int min = Integer.MAX_VALUE;
		 
		 for(int i: numbers){
			 if(i < min){
				 min = i;
			 }
		 } 
		 
		 return min;
	 }
}
