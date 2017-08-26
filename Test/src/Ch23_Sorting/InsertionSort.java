package Ch23_Sorting;

public class InsertionSort {

	public static void main(String args[])
	{
		int[] list={2,9,5,4,8,1};
		insertionSort(list);
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	}
	//Time Complexity O(n^2)
	public static void insertionSort(int[] list)
	{
		for(int i=1;i<list.length;i++)
		{
			int currentElement=list[i];
			int k;
			for(k=i-1;k>=0 && list[k]>currentElement;k--)
			{
				list[k+1]=list[k];
			}
			list[k+1]=currentElement;
		}
	}
	
}
