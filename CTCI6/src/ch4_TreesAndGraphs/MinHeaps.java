package ch4_TreesAndGraphs;

import java.util.ArrayList;

public class MinHeaps {

	private ArrayList<Integer> tree;
	
	public MinHeaps()
	{
		this.tree = new ArrayList<>();
	}
	
	public void insert(int node)
	{
		tree.add(node);
		maintainMinHeap();
	}
	
	private void maintainMinHeap()
	{
		int current = this.tree.size()-1;
		if(current == 0)
			return;
		while(current > 0)
		{
			int parent = (current-2)/2;
			if(this.tree.get(current) < this.tree.get(parent))
			{
				int temp = this.tree.get(current);
				this.tree.set(current, this.tree.get(parent));
				this.tree.set(parent, temp);
				current = parent;
			}
			else
			{
				return;
			}
		}
	}
	
	public int extract_min() 
	{
		if(this.tree.size() == 0)
			throw new IndexOutOfBoundsException("Tree is empty");
		return this.tree.get(0);
	}
	
	public int remove()
	{
		if(this.tree.size() == 0)
			throw new IndexOutOfBoundsException("Tree is empty");
		int result = this.tree.get(0);
		int last =  this.tree.remove(this.tree.size()-1);
		this.tree.set(0, last);
		maintainHeap();
		return result;
	}
	
	private void maintainHeap()
	{
		int current = 0;
		int left = 1;
		int right = 2;
		while(left < this.tree.size() && right < this.tree.size())
		{ 
			if(this.tree.get(right) < this.tree.get(current) && this.tree.get(right) < this.tree.get(left))
			{
				int temp = this.tree.get(right);
				this.tree.set(right,this.tree.get(current));
				this.tree.set(current, temp);
				current = right;
			}
			else if( this.tree.get(left) < this.tree.get(current) && this.tree.get(left) < this.tree.get(right))
			{
				int temp = this.tree.get(left);
				this.tree.set(left,this.tree.get(current));
				this.tree.set(current, temp);
				current= left;
			}
			else
			{
				return;
			}
			left = (2*current)+1;
			right  = (2*current)+2;
		}
	}
	
	public String toString()
	{
		StringBuilder result= new StringBuilder();
		for(Integer node : this.tree)
		{
			result.append(node+", ");
		}
		
		return result.toString();
	}
}
