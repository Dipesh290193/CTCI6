package Topological_Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Project {

	private String name;
	
	private HashMap<String, Project> childrens;
	
	public enum State {COMPLETE, PARTICAL, BLANK};
	
	private State state= State.BLANK;
	
	public Project (String name)
	{
		this.name = name;
		childrens =  new HashMap<String, Project>(); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void addChild(Project p)
	{
		if(!childrens.containsKey(p.getName()))
		{
			childrens.put(p.getName(), p);
		}
	}
	
	public List<Project> getChildrens()
	{
		return new ArrayList<Project>(childrens.values());
	}
	
}
