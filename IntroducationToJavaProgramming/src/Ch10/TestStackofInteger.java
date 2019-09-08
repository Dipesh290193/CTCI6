package Ch10;

public class TestStackofInteger {
	
	public static void main(String args[])
	{
		StackofInteger st=new StackofInteger(15);
		for(int i=0; i<10;i++)
		{
			st.push(i);
		}
		System.out.println("Peek= "+st.peek());
		while(!st.empty())
		{
			System.out.print(st.pop()+" ");
		}
		
		System.out.println(st.getSize());
	}

}
