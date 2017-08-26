package ch10_SortingAndSearching;

public class BubbleSort {

	public static void main(String args[])
	{
		int[] array = {5,2,3,6,9,11,1};
		bubbleSort(array);
		for(int i = 0 ; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
	
	public static void bubbleSort(int[] array)
	{
		boolean isSort = false;
		int length = array.length -1;
		while(!isSort)
		{
			isSort = true;
			for(int i = 0; i< length;i++)
			{
				if(array[i] > array[i+1])
				{
					swap(array, i, i+1);
					isSort = false;
				}
			}
			length--;
		}
	}
	
	public static void swap(int[] array, int left, int right)
	{
		int temp = array[left];
		array[left] = array[right];
		array[right]= temp;
	}
}
