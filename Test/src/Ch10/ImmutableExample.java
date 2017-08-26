package Ch10;

public class ImmutableExample {

	private int num;
	private String name;
	
	public ImmutableExample()
	{
		this.name=null;
	}
	public ImmutableExample(String name,int num)
	{
		this.num=num;
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	public int getNum()
	{
		return num;
	}
}
