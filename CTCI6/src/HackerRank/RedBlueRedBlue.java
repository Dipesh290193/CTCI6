package HackerRank;

import java.util.HashMap;

public class RedBlueRedBlue {

	public static void main(String args[]){
		System.out.println(isMatch("xyzyzxyzyz", "abcabc"));
	}
	
	public static int isMatch(String string, String pattern){
		HashMap<Character,String> map =new HashMap<Character, String>();
		if(isMatch(string, pattern, map)){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	private static boolean isMatch(String s, String p, HashMap<Character, String> map){
		if(s.isEmpty() && p.isEmpty()){
			return true;
		}
		if(s.isEmpty() || p.isEmpty()){
			return false;
		}
		if(map.containsKey(p.charAt(0))){
			String expectedString = map.get(p.charAt(0));
			if(s.length() < expectedString.length()){
				map.remove(p.charAt(0));
				return false;
			}
			String actualString = s.substring(0,expectedString.length());
			if(expectedString.equals(actualString)){
				return isMatch(s.substring(expectedString.length()), p.substring(1), map);
			}
			else{
			map.remove(p.charAt(0));
			return false;
			}
		}
		else{
			for(int i = 1 ; i < s.length(); i++){
				map.put(p.charAt(0), s.substring(0, i));
				if(isMatch(s.substring(i), p.substring(1), map)){
					return true;
				}
			}
		}
		return false;
	}
	
}
