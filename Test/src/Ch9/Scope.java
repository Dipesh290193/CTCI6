package Ch9;

public class Scope {

	int i=1;
	int j=2;
	
	public Scope(int i,int j)
	{
		i=i;
		this.j=j;
	}
	
	public void s()
	{
		int i=5;
		System.out.println(i);
		System.out.println(j);
	}
}
