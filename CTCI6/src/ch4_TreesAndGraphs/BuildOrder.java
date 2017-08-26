package ch4_TreesAndGraphs;

import java.util.HashMap;
import java.util.HashSet;

public class BuildOrder {

	static HashMap<String, HashSet<String>> proDepends = new HashMap<String, HashSet<String>>();
	
	public static void main(String[] args) {
		
		addProjects("a");
		addProjects("b");
		addProjects("c");
		addProjects("d");
		addProjects("e");
		addProjects("f");
		addDependences("a", "d");
		addDependences("f", "b");
		addDependences("b", "d");
		addDependences("f", "a");
		addDependences("d", "c");
		addDependences("e", "f");
		buildOrder();
	}
	
	public static void addProjects(String project)
	{
		if(!proDepends.containsKey(project))
			proDepends.put(project, new HashSet<String>());
	}
	
	public static void addDependences(String project, String dependent)
	{
		if(!proDepends.containsKey(dependent))
			proDepends.put(dependent, new HashSet<String>());
		proDepends.get(dependent).add(project);
	}
	
	
	public static void buildOrder()
	{
		while(proDepends.size() > 0)
		{
			boolean block = true;
			for(String project:proDepends.keySet())
			{
				if(proDepends.get(project).size() == 0)
				{
					block =false;
					for(HashSet<String> depend:proDepends.values())
					{
						if(depend.contains(project))
							depend.remove(project);
					}
					System.out.print(project+", ");
					proDepends.remove(project);
					break;
				}
				
			}
			if(block)
			{
				System.out.println("ERROR");
				return;
			}
		}
	}
}

