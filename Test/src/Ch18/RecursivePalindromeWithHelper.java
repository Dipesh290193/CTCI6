package Ch18;

public class RecursivePalindromeWithHelper {
	
	public static void main(String args[])
	{
		System.out.println("Is moon a palindrome?: "+isPalindrome("moon"));
		System.out.println("Is noon a palindrome?: "+isPalindrome("noon"));
		System.out.println("Is abcba a palindrome?: "+isPalindrome("abcba"));
		System.out.println("IS accba a palindrome?: "+isPalindrome("accba"));
	}
	public static boolean isPalindrome(String s)
	{
		return isPalindrome(s, 0, s.length()-1);
	}
	public static boolean isPalindrome(String s,int low,int high)
	{
		if(high<=low)
			return true;
		else if(s.charAt(low) != s.charAt(high))
			return false;
		else
			return isPalindrome(s,low+1,high-1);
	}
}
