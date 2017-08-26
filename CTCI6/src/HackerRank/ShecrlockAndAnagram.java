package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;

public class ShecrlockAndAnagram {

	public static void main(String[] args) {
		System.out.println(sherlockAnagram("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	static int sherlockAnagram(String s){
		int count = 0;
		for(int i= 1; i< s.length(); i++){
			ArrayList<String> list = new ArrayList<String>();
			
			for(int j = 0 ; j+i <= s.length() ; j++){
				list.add(s.substring(j, j+i));
			}
			
			for(int k = 0 ; k < list.size(); k++){
				for(int l = k+1; l < list.size(); l++){
					if(isAnagram(list.get(k), list.get(l))){
						count++;
					}
				}
			}
		}
		return count;
	}
    
    static boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s1.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }
        
        for(char c: s2.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            else{
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }
}
