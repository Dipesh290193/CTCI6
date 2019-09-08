package programmingInterview;

public class Permutation {

	public static void main(String args[])
	{
		printPermutation("123".toCharArray(), 0);
	}
	public static void printPermutation(char[] inputs, int currentFocus)
	{
		if(currentFocus==inputs.length-1)
		{
			System.out.println(new String(inputs));
			return;
		}
		printPermutation(inputs, currentFocus+1);
		
		for(int i=currentFocus+1;i<inputs.length;i++)
		{
			char temp=inputs[currentFocus];
			inputs[currentFocus]=inputs[i];
			inputs[i]=temp;
			
			printPermutation(inputs, currentFocus+1);
		}
	}
}
