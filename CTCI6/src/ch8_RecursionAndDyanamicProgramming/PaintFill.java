package ch8_RecursionAndDyanamicProgramming;

public class PaintFill {

	public static void main(String args[])
	{
		
	}
	
	public static void fillColor(Color[][] screen, int row, int column , Color newColor)
	{
		if(screen[row][column] == newColor)
			return;
		fillColor(screen, row, column, screen[row][column], newColor);
	}
	
	public static void fillColor(Color[][] screen, int row, int column, Color oldColor, Color newColor)
	{
		if(row < 0 || row > screen.length || column < 0 || column > screen[0].length || screen[row][column] != oldColor)
			return;
		screen[row][column] = newColor;
		fillColor(screen, row+1, column, oldColor, newColor);
		fillColor(screen, row-1, column, oldColor, newColor);
		fillColor(screen, row, column+1, oldColor, newColor);
		fillColor(screen, row, column-1, oldColor, newColor);
	}
	
}

enum Color{
	BLACK, WHITE, GREEN, BLUE, YELLOW, RED
}