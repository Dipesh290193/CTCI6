package Topological_Sort;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		
		Graph graph =new Graph();
		
		graph.addEdge("f", "c");
		graph.addEdge("f", "b");
		graph.addEdge("f", "a");
		graph.addEdge("c", "a");
		graph.addEdge("b", "a");
		graph.addEdge("a", "e");
		graph.addEdge("b", "e");
		graph.addEdge("b", "h");
		graph.addEdge("d", "g");
		
		Stack<Project> stack =orderProject(graph.getProjects());
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop().getName()+", ");
		}
	}
	
	public static Stack<Project> orderProject(List<Project> projects)
	{
		Stack<Project> stack =new Stack<Project>();
		for(Project project : projects)
		{
			if(project.getState() == Project.State.BLANK)
			{
				if(!doBFS(project,stack))
					return null;
			}
		}
		return stack;
	}
	
	public static boolean doBFS(Project project, Stack<Project> stack)
	{
		if(project.getState() == Project.State.PARTICAL)
			return false;
		if(project.getState()  == Project.State.BLANK)
		{
			project.setState(Project.State.PARTICAL);
			for(Project p : project.getChildrens())
			{
					if(!doBFS(p,stack))
						return false;
			}
			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}

}
