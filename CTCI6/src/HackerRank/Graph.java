package HackerRank;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

	HashMap<Node,HashSet<Node>> nodeNeighbour;
	
	public Graph()
	{
		nodeNeighbour = new HashMap<>();
	}
	
	public void add(Node from, Node to)
	{
		if(!nodeNeighbour.containsKey(from))
			nodeNeighbour.put(from, new HashSet<>());	
		nodeNeighbour.get(from).add(to);
	}
	
	private int decomposition = 0;
	
	public int decomposition()
	{
		HashSet<Node> visitedNode = new HashSet<Node>();
		decomposition(new Node(1),visitedNode);
		return this.decomposition;
	}
	
	private int decomposition(Node n, HashSet<Node> visitedNode)
	{
		visitedNode.add(n);
		if(nodeNeighbour.get(n) == null ||nodeNeighbour.get(n).size() == 0)
			return 1;
		int count = 0;
		for(Node node : nodeNeighbour.get(n))
		{
			if(!visitedNode.contains(node))
			{
				int temp = decomposition(node,visitedNode);
				if(temp % 2 == 0 )
					this.decomposition++;
				else
					count+= temp;
			}
		}
		return count+1;
	}
}
