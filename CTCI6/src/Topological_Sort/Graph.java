package Topological_Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Graph {

	HashMap<String,Project> map = new HashMap<String, Project>();
	
	public Project getOrCreateNode(String name)
	{
		if(!map.containsKey(name))
		{
			map.put(name, new Project(name));
		}
		
		return map.get(name);
	}
	
	public void addEdge(String startName, String endName)
	{
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		
		start.addChild(end);
	}
	
	public List<Project> getProjects()
	{
		return new ArrayList<>(map.values());
	}
}
