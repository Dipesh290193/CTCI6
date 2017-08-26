package ch8_RecursionAndDyanamicProgramming;

import java.util.ArrayList;

public class Sudoku {

	public static void main(String[] args) {
		int[][] board = new int[6][6];
		board[0][0] = 5;
		board[0][1] = 3;
		board[0][2] = 0;
		board[0][3] = 0;
		board[0][4] = 7;
		board[0][5] = 0;
		board[1][0] = 6;
		board[1][1] = 0;
		board[1][2] = 0;
		board[1][3] = 1;
		board[1][4] = 9;
		board[1][4] = 5;
		board[2][0] = 0;
		board[2][1] = 9;
		board[2][2] = 8;
		board[2][3] = 0;
		board[2][4] = 0;
		board[2][5] = 0;
		board[3][0] = 8;
		board[3][1] = 0;
		board[3][2] = 0;
		board[3][3] = 0;
		board[3][4] = 6;
		board[3][5] = 0;
		board[4][0] = 4;
		board[4][1] = 0;
		board[4][2] = 0;
		board[4][3] = 8;
		board[4][4] = 0;
		board[4][5] = 3;
		board[5][0] = 7;
		board[5][1] = 0;
		board[5][2] = 0;
		board[5][3] = 0;
		board[5][4] = 2;
		board[5][5] = 0;
		boolean s = sudokuSolver(board);
		System.out.println(s);
	}
	
	public static boolean sudoku(int[][] board){
		if(board == null | board.length == 0){
			return false;
		}
		return sudoku(board, 0 , 0);
	}
	
	public static boolean sudoku(int[][] board, int row, int column){
		if(row >= board.length || column >= board[0].length)
			return true;
		ArrayList<Integer> possibleValues = null;
		if(board[row][column] == 0){
			possibleValues = getPossibleValues(board, row, column);
		}
		else{
			possibleValues = new ArrayList<Integer>();
			possibleValues.add(board[row][column]);
		}
		
		for(int value :possibleValues){
			board[row][column] = value;
			boolean r = sudoku(board, row+1, column);
			boolean c = sudoku(board, row, column+1);
			if(r && c){
				return true;
			}
		}
		return false;
	}
	
	public static boolean sudokuSolver(int[][] board){
		if(isComplete(board)){
			return true;
		}
		int[] emptySpot = getFirstEmptySpot(board);
		if(emptySpot == null)
			return false;
		ArrayList<Integer> possibleValues = getPossibleValues(board, emptySpot[0], emptySpot[1]);
		
		for(int value : possibleValues){
			board[emptySpot[0]][emptySpot[1]] = value;
			if(sudokuSolver(board)){
				return true;
			}
			board[emptySpot[0]][emptySpot[1]] = 0;
		}
		return false;
	}
	
	public static boolean isComplete(int[][] board){
		int[] emptySpot = getFirstEmptySpot(board);
		if(emptySpot != null){
			return false;
		}
		if(!isRowContainsAllNumbers(board) || !isColumnContainsAllNumbers(board) || !isSubboardContainsAllNumbers(board)){
			return false;
		}
		return true;
	}
	
	public static boolean isRowContainsAllNumbers(int[][] board)
	{
		boolean[] check ;
		for(int i = 0 ; i < board.length; i++){
			check = new boolean[10];
			for(int j = 0 ; j < board[0].length; j++){
				check[board[i][j]] = true;
			}
			for(int k = 1 ; k < board.length; k++){
				if(!check[k]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isColumnContainsAllNumbers(int[][] board)
	{
		boolean[] check ;
		for(int i = 0 ; i < board[0].length; i++){
			check = new boolean[10];
			for(int j = 0 ; j < board[0].length; j++){
				check[board[j][i]] = true;
			}
			for(int k = 1 ; k < board.length; k++){
				if(!check[k]){
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isSubboardContainsAllNumbers(int[][] board){
		boolean[] check ;
		int row = board.length/3;
		int column = board[0].length/3;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < column ; j++){
				check = new boolean[10];
				for(int m = row*3 ; m < (row*3)+3 ; m++){
					for(int n = column*3; n < (column*3)+3; n++){
						check[board[m][n]] = true;
					}
				}
				for(int k = 1 ; k < board.length; k++){
					if(!check[k]){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static int[] getFirstEmptySpot(int[][] board){
		for(int i = 0 ; i < board.length; i++){
			for(int j = 0 ;j < board[0].length; j++){
				if(board[i][j] == 0){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}
	
	public static ArrayList<Integer> getPossibleValues(int[][] board, int row, int column){
		boolean[] check = new boolean[10];
		for(int i = 0 ; i < board.length; i++){
			check[board[row][i]] = true;
		}
		
		for(int i = 0 ; i < board.length; i++){
			check[board[i][column]] = true;
		}
		
		int subBoardRow = (row/3)*3;
		int subBoardColumn = (column/3)*3;
		
		for(int i = subBoardRow ; i< subBoardRow+3 ; i++){
			for(int j = subBoardColumn ; j< subBoardColumn+3 ; j++){
				check[board[i][j]] = true;
			}
		}
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		for(int i = 1 ; i < check.length; i++)
		{
			if(!check[i]){
				list.add(i);
			}
		}
		return list;
	}
}
