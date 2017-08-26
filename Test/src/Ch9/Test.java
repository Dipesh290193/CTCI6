package Ch9;

public class Test {
	
	public static void main(String args[])
	{
		Count c= new  Count(0);
		int times=0;
		for(int i=0;i<10;i++)
		{
			times= increment(c, times);
			System.out.println("Count is "+c.count);
			System.out.println("Times is "+times);			
		}
		
	}
	
	public static int increment(Count c,int times)
	{
		c.count++;
		times++;
		return times;
	}

}
