package ch10_SortingAndSearching;

public class SortedMatrixSearch {

	public static void main(String args[])
	{
		int[][] matrix = new int[5][3];
		matrix[0][0] = 2;
		matrix[0][1] = 7;
		matrix[0][2] = 9;
		matrix[1][0] = 5;
		matrix[1][1] = 9;
		matrix[1][2] = 11;
		matrix[2][0] = 8;
		matrix[2][1] = 13;
		matrix[2][2] = 15;
		matrix[3][0] = 10;
		matrix[3][1] = 17;
		matrix[3][2] = 21;
		matrix[4][0] = 12;
		matrix[4][1] = 18;
		matrix[4][0] = 22;
		
		search(matrix, 8);
				
	}
	
	public static void search(int[][] matrix, int value)
	{
		if(matrix == null  || matrix.length == 0)
			return;
		search(matrix, value, 0 , matrix.length-1, 0 , matrix[0].length-1);
	}
	
	public static boolean search(int[][] matrix, int value, int rowStart, int rowEnd, int columnStart, int columnEnd)
	{
		if(rowStart > rowEnd || columnStart > columnEnd)
			return false;
		int midRow =  (rowStart + rowEnd)/2;
		int midColumn = (columnStart+columnEnd)/2;
		
		if(matrix[midRow][midColumn] == value)
		{
			System.out.println(midRow+", "+midColumn);
			return true;
		}
		else if(matrix[midRow][midColumn] > value)
		{
			if(!search(matrix, value, rowStart, midRow-1, columnStart, columnEnd))
			{
				return search(matrix, value, rowStart, rowEnd, columnStart, midColumn-1);
			}
			return true;
		}
		else
		{
			if(!search(matrix, value, midRow+1, rowEnd, columnStart, columnEnd))
			{
				return search(matrix, value, rowStart, rowEnd,midColumn+1, columnStart);
			}
			return true;
		}
	}
}
