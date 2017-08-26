package ch10_SortingAndSearching;

public class QuickSort {

	public static void main(String args[])
	{
		int[] array = {5,2,3,6,9,11,1,4};
		quickSort(array);
		for(int i : array)
		{
			System.out.println(i);
		}
	}
	
	public static void quickSort(int[] array)
	{
		quickSort(array, 0, array.length-1);
	}
	
	public static void quickSort(int[] array, int start, int end)
	{
		if(start >=  end)
			return;
		int pivot = array[(start+end)/2];
		int index = partition(array, start, end, pivot);
		quickSort(array, start, index-1);
		quickSort(array, index, end);
	}
	
	public static int partition(int[] array, int start, int end, int pivot)
	{
		while(start <= end)
		{
			while(array[start] < pivot)
				start++;
			while(array[end] > pivot)
				end--;
			if(start<=end)
			{
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
		return start;
	}
}
