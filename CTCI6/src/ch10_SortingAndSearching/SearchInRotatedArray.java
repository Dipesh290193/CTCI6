package ch10_SortingAndSearching;

public class SearchInRotatedArray {

	public static void main(String args[])
	{
		int[] array = {1,3};
		System.out.println(search(array,3,0, array.length-1));
	}
	
	public static int search(int[] array, int value)
	{
		if(array == null || array.length == 0)
			return -1;
		int index = 0;
		while(index < array.length -1 && array[index] < array[index+1])
		{
			if(array[index] == value)
				return index;
			index++;
		}
		
		if(array[index+1] <= value && value <= array[array.length-1])
		{
			return binarySearch(array, value, index+1, array.length-1);
		}
		return -1;
		
	}
	
	public static int binarySearch(int[] array, int value, int start, int end)
	{
		if(start > end)
			return -1;
		int mid = (start+end)/2;
		if(array[mid] > value)
			return binarySearch(array, value, start, mid-1);
		else if(array[mid] < value)
			return binarySearch(array, value, mid+1,end);
		return mid;
	}
	
	public static int modifyBinarySearch(int[] a, int start, int end, int value)
	{
		int mid = (start+end)/2;
		if(a[mid] == value)
			return mid;
		if(start > end)
			return -1;
		
		if(a[start] < a[mid])
		{
			if(a[start] <= value && a[mid] < value)
			{
				return modifyBinarySearch(a, start, mid-1, value);
			}
			else
			{
				return modifyBinarySearch(a, mid+1, end, value);
			}
		}
		else if(a[start] > a[mid])
		{
			if(value > a[mid] && value <= a[end])
			{
				return modifyBinarySearch(a, mid+1, end, value);
			}
			else
			{
				return modifyBinarySearch(a, start, mid-1, value);
			}
		}
		else if(a[mid] == a[start]){
			if(a[mid] != a[end])
				return modifyBinarySearch(a, mid+1, end, value);
			else
			{
				int result  = modifyBinarySearch(a, start, mid-1, value);
				if(result == -1)
					return modifyBinarySearch(a, mid+1, end, value);
				return result;
			}
		}
		return -1;
	}

	public static int search(int[] nums, int target, int start, int end)
	{
		if(start > end){
			return -1;
		}
		int mid =(start + end ) /2 ;
		if(nums[mid] == target)
			return mid;
		else if(nums[start] < nums[mid])
		{
			if(nums[start] <= target && nums[mid] > target)
				return search(nums, target, start, mid-1);
			else
				return search(nums, target, mid+1, end);
		}
		else if(nums[start] > nums[mid])
		{
			if(target > nums[mid] && target <= nums[end])
			{
				return search(nums, target,mid+1, end);
			}
			else
			{
				return search(nums, target ,start, mid-1);
			}
		}
		return -1;
	}
}
