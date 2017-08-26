package programmingInterview;

public class CountOccurance {

	public static void main(String[] args)
	{
		int[] inputs={1,2,2,2,2,2,2,3,4,5,6,6,6,6,6,6,6,7,8,9,10};
		System.out.println(getOccurance(inputs, 6, 0, inputs.length-1));
	}
	public static int getOccurance(int[] inputs , int a, int startIndex, int endIndex )
	{
		if(startIndex>endIndex)
			return 0;
		if(a < inputs[startIndex])
			return 0;
		if(a > inputs[endIndex])
			return 0;
		int midIndex=(startIndex+endIndex)/2;
		
		if(a == inputs[midIndex])
			return 1+getOccurance(inputs, a, startIndex, midIndex-1)+getOccurance(inputs, a,midIndex+1 , endIndex);
		else if(a < inputs[midIndex])
			return getOccurance(inputs, a, startIndex, midIndex-1);
		else
			return getOccurance(inputs, a, midIndex+1, endIndex);
	}
}
