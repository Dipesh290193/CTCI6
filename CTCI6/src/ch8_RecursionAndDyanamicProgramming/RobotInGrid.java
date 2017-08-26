package ch8_RecursionAndDyanamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RobotInGrid {

	public static void main(String args[])
	{
		boolean[][] grid = new boolean[8][8];
		for(boolean[] b : grid)
		{
			Arrays.fill(b, true);
		}
		grid[1][2] = false;
		grid[1][6] = false;
		grid[2][4] = false;
		grid[3][0] = false;
		grid[3][2] = false;
		grid[3][5] = false;
		grid[3][7] = false;
		grid[4][2] = false;
		grid[5][3] = false;
		grid[5][4] = false;
		grid[5][6] = false;
		grid[6][1] = false;
		grid[6][5] = false;
		ArrayList<Point> paths =  getPaths(grid);
		for(Point p : paths)
		{
			System.out.println(p.toString());
		}
	}
	
	//Get numbers of path from left top to right bottom of the grid
	public static int paths(boolean[][] grid)
	{
		if(grid == null || grid.length == 0)
			return 0;
	
		int[][] memo = new int[grid.length][grid[0].length];
		for(int[] row: memo)
			Arrays.fill(row, -1);
		return paths(grid, 0 , 0, memo);
	}
	
	//Time complexity is O(rc) 
	//Space complexity is O(rc)
	//where r is number of rows and c is number of columns 
	private static int paths(boolean[][] grid, int row, int column, int[][] memo)
	{
		if(row >= grid.length || column >= grid[0].length || !grid[row][column])
			return 0;
		if(grid.length-1 == row && grid[0].length-1 == column)
			return 1;
		if(memo[row][column] == -1)
		{
			memo[row][column] = paths(grid, row, column+1, memo) + paths(grid, row+1, column, memo);
		}
		return memo[row][column];
	}
	
	
	//Get actual path from left top to bottom right of the grid
	public static ArrayList<Point> getPaths(boolean[][] grid)
	{
		if(grid == null || grid.length == 0)
			return null;
		ArrayList<Point> paths = new ArrayList<Point>();
		HashSet<Point> memo = new HashSet<Point>();
		if(getPaths(grid, grid.length-1 , grid[0].length-1, paths, memo))
		{
			return paths;
		}
		return null;
	}
	
	//Time complexity is O(rc) 
	//Space complexity is also O(rc)
	//where r is number of rows and c is number of columns
	public static boolean getPaths(boolean[][] grid, int row, int column, ArrayList<Point> paths, HashSet<Point> memo)
	{
		if(row < 0 || column < 0 || !grid[row][column]){
			return false;
		}
		
		Point p = new Point(row, column);
		
		if(memo.contains(p)){
			return false;
		}
		
		boolean isOrigin = (row == 0) && (column == 0);
		
		if(isOrigin || getPaths(grid, row -1, column , paths, memo) || getPaths(grid, row, column-1, paths, memo))
		{
			paths.add(p);
			return true;
		}
		
		memo.add(p);
		return false;
	}
}

class Point{
	int row;
	int column;
	public Point(int row, int column){
		this.row =row;
		this.column = column; 
	}
	
	@Override
	public String toString()
	{
		return "(" + this.row + ", " +this.column+ ")"; 
	}
	
	@Override
	public int hashCode()
	{
		return this.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if( o == null){
			return false;
		}
		if(!(o instanceof Point))
			return false;
		Point p = (Point) o;
		if(p.row == row && p.column == column)
		{
			return true;
		}
		return false;
	}
}
