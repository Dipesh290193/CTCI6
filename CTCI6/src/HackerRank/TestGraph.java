package HackerRank;

public class TestGraph {

	public static void main(String args[])
	{
		Graph g= new Graph();
		g.add(new Node(1), new Node(2));
		g.add(new Node(1), new Node(3));
		g.add(new Node(3), new Node(4));
		g.add(new Node(2), new Node(5));
		g.add(new Node(1), new Node(6));
		g.add(new Node(2), new Node(7));
		g.add(new Node(6), new Node(8));
		g.add(new Node(8), new Node(9));
		g.add(new Node(8), new Node(10));
		System.out.println(g.decomposition());
	}
	
	
	
	/*2 1
	3 1
	4 3
	5 2
	6 1
	7 2
	8 6
	9 8
	10 8*/
}
