package ch7_ObjectOrientedDesign;

public class Othello {

}
enum Side{
	Black, White
}

class Player{
	private String name;
	private Side side;
	public Player(String name, Side side)
	{
		this.name = name;
		this.side = side;
	}
}
class Piece{
	private Side side;
	
	public void flip()
	{
		if(this.side == Side.Black)
		{
			this.side = Side.White;
		}
		else
		{
			this.side = Side.Black;
		}
	}
}

class Board{
	private Piece[][] pieces;
	private Player player1;
	private Player player2;
	private int numberOfBlack;
	private int numberOfWhite;
	private final int ROWS = 10;
	private final int COLUMNS = 10;
	
	public Board(Player player1, Player player2)
	{
		pieces = new Piece[ROWS][COLUMNS];
		this.player1 = player1;
		this.player2=player2;
	}
	
	public void putPiece(int row, int column, Side side)
	{
		
	}
	
}
