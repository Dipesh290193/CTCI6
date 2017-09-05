package ch1_ArraysAndStrings;

public class CheckPermutation {

	public static boolean checkPermutation(String a, String b){
		if(a.length() != b.length()){
			return false;
		}
		//Assuming ASCII code
		int[] counts = new int[128];
		
		for(char c: a.toCharArray()){
			counts[c]++;
		}
		
		for(char c: b.toCharArray()){
			counts[c]--;
			if(counts[c ]<0){
				return false;
			}
		}
		return true;
	}
}
