package programmingInterview;

public class FindFirstIndex {

	public static void main(String args[])
	{
		int[] nums={1,2,2,2,3};
		System.out.println(getFirstIndex(nums, 2, 0, nums.length-1));
	}
	public static int getFirstIndex(int[] nums,int a, int start, int end)
	{
		if(start>end)
		{
			return -1;
		}
		if(a>nums[end])
			return -1;
		if(a<nums[start])
			return -1;
		int mid=(start+end)/2;
		if(nums[mid]==a)
		{
			 int firstIndex = getFirstIndex(nums, a, start, mid-1);
			return firstIndex==-1?mid:firstIndex;
		}
		else if(nums[mid]>a)
		{
			return getFirstIndex(nums, a, start, mid-1);
		}
		else
		{
			return getFirstIndex(nums, a, mid+1, end);
		}
		
	}
}
