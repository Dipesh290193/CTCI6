package MethodEquals;

public class ColorPoint extends Point{

	private final String color;
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color =color;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof ColorPoint))
			return false;
		return super.equals(o) && ((ColorPoint)o).color == color;
	}

}
