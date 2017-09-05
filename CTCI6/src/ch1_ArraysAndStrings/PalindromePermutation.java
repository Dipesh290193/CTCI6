package ch1_ArraysAndStrings;

public class PalindromePermutation {

	public static void main(String args[]){
		System.out.println(isPalindrome("Tact coa"));
	}
	public static boolean isPalindrome(String s){
		int[] letters = new int[128];
		int odd = 0;
		for(char c : s.toLowerCase().toCharArray()){
			if(c >= 97 && c <= 122)
			{
				letters[c]++;
				if(letters[c] % 2 == 0){
					odd--;
				}
				else{
					odd++;
				}
			}
		}
		return odd==1? true: false;
	}
}
