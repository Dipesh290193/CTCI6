package programmingInterview;

public class PrintAllPairsSumM {

	public static void main(String args[])
	{
		int[] a={1,2,3,4,9,9,10};
		PrintAllPairs(a, 12);
	}
	public static void PrintAllPairs(int[] a, int M)
	{
		int left=0;
		int right=a.length-1;
		
		while(left<right)
		{
			int temp=a[left]+ a[right];
			if(temp==M)
			{
				System.out.println("Sum of {"+a[left]+", "+a[right]+"} ="+M);
				left++;
				right--;
			}
			else if(temp>M)
			{
				right--;
			}
			else
				left++;
		}
	}
}
