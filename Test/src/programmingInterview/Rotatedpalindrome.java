package programmingInterview;

public class Rotatedpalindrome {

	public static void main(String args[])
	{
		System.out.println(isRotatedPalindrome("545123321"));
	}
	public static boolean isPalindrome(String in)
	{
		char[] ins=in.toCharArray();
		
		for(int i=0;i<ins.length/2;i++)
		{
			if(ins[i]!=ins[ins.length-1-i])
				return false;
		}
		return true;
	}
	public static boolean isRotatedPalindrome(String in)
	{
		for(int i=0;i<in.length();i++)
		{
			String left=in.substring(0,i);
			String right=in.substring(i);
			if(isPalindrome(right+left))
				return true;
		}
		return false;
	}
}
