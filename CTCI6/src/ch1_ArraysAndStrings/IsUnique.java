package ch1_ArraysAndStrings;

import java.util.Arrays;

public class IsUnique {

	public static void main(String args[]){
		System.out.println(isUni("abc"));
	}
	
	// Assuming that char has all ASCII character
	//Space complexity is O(1), Time complexity is O(n)
	public static boolean isUnique(String str){
		boolean[] valid =new  boolean[128];
		for(char c : str.toCharArray()){
			if(valid[c]){
				return false;
			}
			valid[c] = true;
		}
		return true;
	}
	
	//Without using additional data structure
	//Time complexity is O(n^2), space complexity is O(1)
	public static boolean isUni(String str){
		for(int i = 0 ; i < str.length(); i++ ){
			for(int j = i+1 ; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
	
}
