package DirectedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DirectedGraph<T> {

	HashMap<Node<T>, HashSet<Edge>> nodeNeighbour;
	
	public DirectedGraph()
	{
		nodeNeighbour = new HashMap<Node<T>, HashSet<Edge>>();
	}
	
	public boolean addNode(Node node)
	{
		if(!nodeNeighbour.containsKey(node))
		{
			nodeNeighbour.put(node, new HashSet<Edge>());
			return true;
		}
	return false;	
	}
	
	
	public boolean addEdge(Node from, Node to, int value)
	{
		if(from == null || to == null)
			return false;
		if(!nodeNeighbour.containsKey(from))
			return false;
		Edge edge = new Edge(from, to , value);
		return nodeNeighbour.get(from).add(edge);
	}
	
	public boolean DFS(Node s, Node t)
	{
		if(!nodeNeighbour.containsKey(s) || !nodeNeighbour.containsKey(t))
			return false;
		HashSet<Node> visited = new HashSet<Node>();
		return DFS(s,t,visited);
	}
	
	private boolean DFS(Node s, Node t, HashSet<Node> visited)
	{
		visited.add(s);
		if(s.equals(t))
			return true;
		for(Edge edge: nodeNeighbour.get(s))
		{
			if(!visited.contains(edge.getTo()))
				return DFS(edge.getTo(),t,visited);
		}
		
		return false;
	}
	
	public boolean BFS(Node s, Node t)
	{
		if(!nodeNeighbour.containsKey(s) || !nodeNeighbour.containsKey(t))
			return false;
		HashSet<Node> visited = new HashSet<Node>();
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		nextToVisit.add(s);
		visited.add(s);
		
		while(!nextToVisit.isEmpty())
		{
			if(nextToVisit.peek().equals(t))
				return true;
			for(Edge edge: nodeNeighbour.get(nextToVisit.removeFirst()))
			{
				if(!visited.contains(edge.getTo()))
				{
					nextToVisit.addLast(edge.getTo());
					visited.add(edge.getTo());
				}
			}
		}
		
		return false;
	} 
}

