package ch8_RecursionAndDyanamicProgramming;

import java.util.ArrayList;

public class EightQueens {

	public static void main(String args[])
	{
		Integer[] columns = new Integer[8];
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		placeQueens(0,columns, results);
		for(Integer[] c : results)
		{
			for(int i = 0; i< c.length; i++)
			{
				System.out.println("( "+i+", "+c[i]+") ");
			}
			System.out.println();
		}
	}
	
	
	public static void placeQueens(int row, Integer[] columns,ArrayList<Integer[]> results)
	{
		if(row == 8)
		{
			results.add(columns.clone());
		}
		else
		{
			for(int col = 0 ; col < 8 ; col++)
			{
				if(checkValid(columns, row, col))
				{
					columns[row] = col;
					placeQueens(row+1, columns, results);
				}
			}
		}
		
	}
	
	public static boolean checkValid(Integer[] columns, int r, int c)
	{
		for(int row = 0 ; row < r; row++)
		{
			int column = columns[row];
			if(c == column)
			{
				return false;
			}
			
			int coluDistance = Math.abs(column-c);
			int rowDistance = r - row;
			if(coluDistance == rowDistance)
				return false;
		}
		return true;
	}
	
	public static ArrayList<ArrayList<Point>> getPoints()
	{
		ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
		boolean[][] board = new boolean[8][8];
		ArrayList<Point> list = new ArrayList<Point>();
		getPoint(board, list, 0, result);
		return result;
	}
	
	public static void getPoint(boolean[][] board, ArrayList<Point> list, int row, ArrayList<ArrayList<Point>> result)
	{
		if(row == 8)
		{
			result.add(list);
			board = new boolean[8][8];
		}
		
		for(int i = row ; i<board.length;i++)
		{
			for(int j = 0 ; j < board[0].length; j++)
			{
				if(!board[i][j])
				{
					list.add(new Point(i,j));
					check(board,i,j, true);
					getPoint(board, list, row+1, result);
					check(board,i,j,false);
				}
			}
		}
	}
	
	public static void check(boolean[][] board, int r, int c, boolean value)
	{
		for(int i = 0; i< board.length;i++)
		{
			board[r][i] = value;
		}
		for(int i = 0 ;i < board[0].length; i++)
		{
			board[i][c] = value;
		}
		if(c >= r)
		{
			for(int i = 0,j = c-r; j<board.length; i++,j++)
			{
				board[i][j] =value;
			}
		}
		else
		{
			for(int i = r -c,j=0;i<board.length;i++,j++)
			{
				board[i][j] = value;
			}
		}
		for(int i = r,j=c; i>=0 && j>=0 && i<board.length&& j<board.length;i++,j--)
		{
			board[i][j] = value;
		}
		for(int i = r-1,j=c+1; i>=0 && j>=0 && i<board.length&& j<board.length;i--,j++)
		{
			board[i][j] = value;
		}
	}
}
