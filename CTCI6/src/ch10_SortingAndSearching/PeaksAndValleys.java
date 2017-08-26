package ch10_SortingAndSearching;

public class PeaksAndValleys {

	public static void main(String args[])
	{
		int[] array = {1,3,10,5,8,11,12};
		sortPeaks(array);
		for(int i : array)
		{
			System.out.print(i+" ");
		}
	}
	
	//Time complexity is O(n^2)
	public static void sort(int[] array)
	{
		for(int i = 0 ; i < array.length-1; i++)
		{
			int maxIndex = findMax(array, i);
			swap(array,i,maxIndex);
			int minIndex = findMin(array, ++i);
			swap(array, i,minIndex);
		}
	}
	
	public static int findMax(int[] array, int index)
	{
		int max = index;
		for(int i = index+1; i< array.length; i++)
		{
			if(array[i] > array[max])
			{
				 max = i;
			}
		}
		return max;
	}
	
	public static int findMin(int[] array, int index)
	{
		int min = index;
		for(int i = index+1; i< array.length; i++)
		{
			if(array[i] < array[min])
			{
				 min = i;
			}
		}
		return min;
	}
	
	public static void swap(int[] array, int index1, int index2)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	//Time complexity is O(n)
	public static void sortPeaks(int[] array)
	{
		if(array == null || array.length == 0)
			return;
		for(int i = 1 ; i< array.length-1; i++)
		{
			if(array[i] < array[i-1] && array[i] > array[i+1])
			{
				swap(array,i+1,i);
			}
			else if(array[i] > array[i-1] && array[i] < array[i+1])
			{
				swap(array,i, i+1);
			}
		}
	}
}
