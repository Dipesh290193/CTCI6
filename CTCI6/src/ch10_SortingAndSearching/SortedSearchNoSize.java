package ch10_SortingAndSearching;

public class SortedSearchNoSize {

	
	public static void main(String arsg[])
	{
		
	}
	
	//If we don't know the length of the sorted array
	//Time complexity is O(nlogn) 
	public static int search(int[] a, int value)
	{
		int index= 1;
		while(a[index] != -1 && a[index] < value)
		{
			index*=2;
		}
		return binarySearch(a, value, 0, index);
	}
	
	public static int binarySearch(int[] a, int value, int start, int end)
	{
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		if(a[mid] == -1)
			return binarySearch(a, value, start, mid-1);
		else if(value < a[mid])
			return binarySearch(a, value, start, mid-1);
		else if(value > a[mid])
			return binarySearch(a, value, mid+1, end);
		else
			return mid;
	}
}
