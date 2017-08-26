package ch10_SortingAndSearching;

public class SortedMerge {

	public static void main(String args[])
	{
		int[] A = {2,3,7,9,10,11,12,13,17,Integer.MAX_VALUE-6,Integer.MAX_VALUE-5,Integer.MAX_VALUE-4,Integer.MAX_VALUE-3,Integer.MAX_VALUE-2,Integer.MAX_VALUE};
		int[] B = {1,7,8,10,21,22};
		merge(A,B,9,6);
		for(int i : A)
		{
			System.out.println(i);
		}
		
	}
	
	//Time complexity is O(A+B), Space complexity is O(A)
	public static int[] merge(int[] A,int[] B)
	{
		int[] temp = new int[A.length];
		int k = 0, i = 0;
		for(int j = 0; j < B.length;k++)
		{
			if(A[i] < B[j])
			{
				temp[k] = A[i];
				i++;
			}
			else
			{
				temp[k] = B[j];
				j++;
			}
		}
		
		for(;k<temp.length;i++,k++)
		{
			temp[k] = A[i]; 
		}
		
		return temp;
	}
	
	//Time complexity is O(A+B), Space complexity O(1)
	public static void merge(int[] a, int[] b, int lastA, int lastB)
	{
		int indexA = lastA- 1;
		int indexB  = lastB -1;
		int indexMerged = lastA + lastB -1;
		
		while(indexB >= 0)
		{
			if( indexA >= 0 && a[indexA] > b[indexB])
			{
				a[indexMerged] = a[indexA];
				indexA --;
			}
			else
			{
				a[indexMerged] = b[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}
}
