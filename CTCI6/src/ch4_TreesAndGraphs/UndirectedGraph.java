package ch4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph<T> {

	HashMap<Node<T>, HashSet<Edge>> nodeNeg;
	
	public UndirectedGraph()
	{
		 this.nodeNeg = new HashMap<Node<T>, HashSet<Edge>>();
	}
	
	public boolean addNode(Node<T> n)
	{
		if(!nodeNeg.containsKey(n))
		{
			nodeNeg.put(n, new HashSet<Edge>());
			return true;
		}
		
		return false;
	}
	
	public boolean addEdge(Node<T> from, Node<T> to, int value)
	{
		Edge edge = new Edge(from, to, value);
		Edge e = new Edge(to,from, value);
		nodeNeg.get(to).add(e);
		return nodeNeg.get(from).add(edge);
	}
	
	public boolean removeNode(Node<T> n)
	{
		if(nodeNeg.containsKey(n))
		{
			for(Edge edge : nodeNeg.get(n))
			{
				nodeNeg.get(edge.getTo()).remove(new Edge(edge.getTo(),n,edge.getValue()));
			}
			nodeNeg.remove(n);
			return true;
		}
		
		return false;
	}
	
	public boolean removeEdge(Edge e)
	{
		if(nodeNeg.containsKey(e.getFrom()))
		{
			nodeNeg.get(e.getFrom()).remove(e);
			nodeNeg.get(e.getTo()).remove(e);
		}
		return false;
	}
	
	public List<Node> neighbors(Node n)
	{
		if(nodeNeg.containsKey(n))
		{
			List<Node> neighbours= new ArrayList<>();
			for(Edge e: nodeNeg.get(n))
			{
				neighbours.add(e.getTo());
			}
			
			return neighbours;
		}
		
		return null;
	}
	
	
	public int distance(Node from, Node to)
	{
		if(nodeNeg.containsKey(from))
		{
			for(Edge e:nodeNeg.get(from))
			{
				if(e.getTo().equals(to))
				{
					return e.getValue();
				}
			}
		}
		return -1;
	}
	
	public boolean DFS(Node s, Node t){
		HashSet<Node> visited = new HashSet<>();
		return DFS(s, t,visited);
	}
	
	private boolean DFS(Node s, Node t, HashSet<Node> visited)
	{
		visited.add(s);
		if(s.equals(t))
			return true;
		for(Edge edge: nodeNeg.get(s))
		{
			if(!visited.contains(edge.getTo()))
				return DFS(edge.getTo(),t,visited);
		}
		return false;
	}
	
	public boolean BFS(Node s, Node t)
	{
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		nextToVisit.add(s);
		visited.add(s);
		while(!nextToVisit.isEmpty())
		{
			if(nextToVisit.peek().equals(t))
				return true;
			for(Edge e: nodeNeg.get(nextToVisit.removeFirst()))
			{
				if(!visited.contains(e.getTo()))
				{
					nextToVisit.addLast(e.getTo());
					visited.add(e.getTo());
				}
			}
		}
		
		return false;
	}
			
	
}
