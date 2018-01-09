package Hacker;

public class Solution {

	 public static void main(String args[]){
	        System.out.println(solution("2-4A0r7-4k",3));
	    }

	    public static String solution(String S, int K) {
	        // write your code in Java SE 8
	        StringBuilder sb = new StringBuilder();
	        for(char c: S.toCharArray()){
	            if(c != '-'){
	                sb.append(Character.toUpperCase(c));
	            }
	        }
	        String result = "";
	        int c = 0;
	        for(int i =sb.length()-1;i>=0;i--){
	            if (c==K){
	                result = sb.charAt(i)+"-"+result;
	                c=1;
	            }
	            else{
	                result= sb.charAt(i)+result;
	                c++;
	            }
	        }
	        return result;
	    }
}
