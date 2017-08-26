package ch10_SortingAndSearching;

public class FindDuplicates {

	public static void main(String args[])
	{
		int[] n = {123,121,152,255,58,552,82,1,2,5,9,99,100,121,123,588,255};
		findDuplicates(n);
	}
	
	public static void findDuplicates(int[] n)
	{
		int nums = 32000;
		int[] bitfield = new int[(int)(nums/32)+1];
		
		for(int i = 0; i < n.length ; i++)
		{
			int num = n[i];
			int bucketNumber = num >> 5;
			int bitPosition = 1 << (num % 32);
			if((bitfield[bucketNumber] & bitPosition) != 0)
			{
				System.out.println(num);
			}
			else
			{
				bitfield[bucketNumber] |= bitPosition;
			}
		}
	}
}
