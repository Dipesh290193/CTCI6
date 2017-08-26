package ch10_SortingAndSearching;

public class SparseSearch {

	public static void main(String args[])
	{
		
	}
	public static int sparseSearch(String[] array, String str)
	{
		return sparseSearch(array, str, 0, array.length);
	}
	
	public static int sparseSearch(String[] array, String str, int start, int end)
	{
		if(start > end)
			return -1;
		int mid = (start+end)/2;
		
		if(array[mid].isEmpty())
		{
			int left = mid - 1;
			int right = mid + 1;
			while(left >= start || right <= end)
			{
				if(left >= start && !array[left].isEmpty())
				{
					mid = left;
					break;
				}
				else if(right <= end && !array[right].isEmpty())
				{
					mid = right;
					break;
				}
				left -- ;
				right ++;
			}
			
			if(left < start && right > end)
				return -1;
		}
		
		if(array[mid].equals(str))
			return mid;
		else if(array[mid].compareTo(str) > 0)
		{
			return sparseSearch(array, str, start, mid-1);
		}
		else
		{
			return sparseSearch(array, str, mid+1, end);
		}
		
		
	}
}
