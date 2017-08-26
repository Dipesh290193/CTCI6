package Ch23_Sorting;

public class BubbleSort {

	public static void main(String args[])
	{
		int[] list={2,9,5,4,8,1};
		bubbleSort(list);
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
		
	}
	//Time Complexity O(n^2)
	public static void bubbleSort(int[] list)
	{
		boolean needMoreSwap=true;
		for(int k=1;k<list.length && needMoreSwap;k++)
		{
			needMoreSwap=false;
			for(int i=0;i<list.length-k;i++)
			{
				if(list[i]>list[i+1])
				{
					int temp=list[i];
					list[i]=list[i+1];
					list[i+1]=temp;
					needMoreSwap=true;
				}
			}
		}
	}
}
