package ch8_RecursionAndDyanamicProgramming;

public class MagicIndex {

	public static void main(String args[])
	{
		int[] a = new int[] {-1,-1,1,2,2,2,4,6,7,7,8,8,8,13};
		System.out.println(findMagicalIndex(a));
	}
	
	
	
	public static int findMagicalIndex(int[] a)
	{
		if(a == null || a.length == 0)
			return -1;
		return findIndex(a , 0 , a.length-1);
	}
	
	//Sorted Array of distinct values
	// Time complexity is O(logn)
	public static int findMagicalIndex(int[] a, int min, int max)
	{
		if(min > max)
			return -1;
		int mid = (min + max)/2;
		
		if(a[mid] == mid)
			return mid;
		if(a[mid] > mid)
			return findMagicalIndex(a, min, mid-1);
		if(a[mid] < mid)
			return findMagicalIndex(a, mid+1, max);
		return -1;
	}
	
	//sorted Array of without distinct values
	//Time complexity is O(logn)
	public static int findIndex(int[] a , int min, int max)
	{
		if(min > max)
			return -1;
		int mid = (min + max)/2;
		
		if(a[mid] == mid)
			return mid;
		
		if(a[mid] >= 0 && a[mid] < a.length)
		{
			if(a[a[mid]] == a[mid])
				return a[mid];
		}
		if(a[mid] < mid)
		{
			int i = findIndex(a, mid+1, max);
			if( i != -1)
				return i;
			if(a[mid] > 0 && a[mid] < a.length)
			{
				return findIndex(a, min, a[mid]-1);
			}
			
		}
		if(a[mid] > mid)
		{
			int j = findIndex(a, min, mid-1);
			if( j != -1)
				return j;
			if(a[mid] > 0 && a[mid] < a.length)
			{
				return findIndex(a, a[mid]+1, max);
			}
			
		}
		return -1;
	}
}
