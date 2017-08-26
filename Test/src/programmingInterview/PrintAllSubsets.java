package programmingInterview;

public class PrintAllSubsets {

	public static void main(String args[])
	{
		int[] nums={1,2,3};
		printSubsets(nums);
	}
	public static void printSubsets(int[] nums)
	{
		for(int i=0;i<=nums.length;i++)
		{
			boolean[] ifPrint=new boolean[nums.length];
			printSubsets(nums, ifPrint, 0, i);
		}			
	}
	public static void printSubsets(int[] nums,boolean[] ifPrint, int start, int remain)
	{
		if(remain==0)
		{
			System.out.print("{");
			for(int i=0;i<ifPrint.length;i++)
			{
				if(ifPrint[i])
					System.out.print(nums[i]+",");
			}
			System.out.print("}\n");
		}
		else
		{
			if(start+remain>nums.length)
				;
			else
			{
				for(int i=start;i<nums.length;i++)
				{
					if(!ifPrint[i])
					{
						ifPrint[i]=true;
						printSubsets(nums,ifPrint,i+1, remain-1);
						ifPrint[i]=false;
					}
				}
			}
		}
	}
}
