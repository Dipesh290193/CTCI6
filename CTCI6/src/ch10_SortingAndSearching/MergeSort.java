package ch10_SortingAndSearching;

public class MergeSort {

	public static void main(String args[])
	{
		int[] array = {5,2,3,6,9,11,1,4};
		mergeSort(array);
		for(int i : array)
		{
			System.out.println(i);
		}
	}
	
	public static void mergeSort(int[] array)
	{
		mergeSort(array, 0, array.length-1, new int[array.length]);
	}
	
	public static void mergeSort(int[] array, int start, int end, int[] temp)
	{
		if(start < end)
		{
			int mid = (start+end)/2;
			mergeSort(array,start, mid, temp);
			mergeSort(array,mid+1, end, temp);
			merge(array,start,mid,end,temp);
		}
	}
	public static void merge(int[] array, int start,int mid, int end, int[] temp)
	{
		int startLeft = start;
		int startRight = mid+1;
		int index = start;
		
		while(startLeft <= mid && startRight <= end)
		{
			if(array[startLeft] < array[startRight])
			{
				temp[index] = array[startLeft];
				startLeft++;
			}
			else
			{
				temp[index]= array[startRight];
				startRight++;
			}
			index++;
		}
		
		System.arraycopy(array, startLeft, temp, index, mid-startLeft+1);
		System.arraycopy(array, startRight, temp, index, end-startRight+1);
		System.arraycopy(temp, start, array, start, end-start+1);
	}
}
