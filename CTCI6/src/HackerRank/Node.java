package HackerRank;


public class Node {

	private final int data;
	
	public Node(int data)
	{
		this.data  =data;
	}
	
	public int getData() {
		return data;
	}

	@Override
	public boolean equals(Object o)
	{
		Node n = (Node)o;
		return this.data == n.getData();
	}
	
	@Override
	public int hashCode()
	{
		int hashCode = 1;
		hashCode = 31 * this.data;
		return hashCode;
	}
}
