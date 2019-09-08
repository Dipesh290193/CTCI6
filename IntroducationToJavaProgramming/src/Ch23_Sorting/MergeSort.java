package Ch23_Sorting;

public class MergeSort {

	public static void main(String args[])
	{
		int[] list={0,-1,-2,5,-3};
		//System.out.println(list.length/2);
		mergeSort(list);
		
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	}
	//Time Complexity O(nlogn) less than O(n^2)
	public static void mergeSort(int[] list)
	{
		if(list.length > 1)
		{
			int[] firstHalf=new int[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			mergeSort(firstHalf);
			
			int secondHalfLength=list.length-(list.length/2);
			int[] secondHalf=new int[secondHalfLength];
			System.arraycopy(list, list.length/2, secondHalf, 0,secondHalfLength);
			mergeSort(secondHalf);
			
			merge(firstHalf,secondHalf,list);
		}
	}
	public static void merge(int[] list1,int[] list2, int[] temp)
	{
		int current1=0;//current index of list1
		int current2=0;//current index of list2
		int current3=0;//current index of temp
		
		while(current1<list1.length && current2<list2.length)
		{
			if(list1[current1]<list2[current2])
			{
				temp[current3++]=list1[current1++];
			}
			else
			{
				temp[current3++]=list2[current2++];
			}
		}
		while(current1<list1.length)
		{
			temp[current3++]=list1[current1++];
		}
		while(current2<list2.length)
		{
			temp[current3++]=list2[current2++];
		}
	}
}
