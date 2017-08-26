package SingletonEnum;

public enum Car {

	INSTANCE;
	
	private Car(){
		
	}	
	
	private String color;
	private boolean isStarted;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isStarted() {
		return isStarted;
	}
	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
		
}
