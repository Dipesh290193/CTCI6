package ch4_TreesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class ListofDepths {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(7);
		root.right = new TreeNode(18);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(20);
		root.left.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(10);
		root.right.right.left = new TreeNode(21);
		
		for(LinkedList<TreeNode> nodes: depthBFS(root).values())
		{
			while(!nodes.isEmpty())
			{
				System.out.print(nodes.removeFirst().getData()+" ,");
			}
			System.out.println();
		}
	}
	
	
	//Using recursion, Time complexity is O(n) where n is number of nodes in Binary tree
	public static HashMap<Integer,LinkedList<TreeNode>> depths(TreeNode root)
	{
		HashMap<Integer,LinkedList<TreeNode>> maps= new HashMap<Integer, LinkedList<TreeNode>>();
		depths(0,root,maps);
		return maps;
	}
	
	private static void depths(int level, TreeNode node, HashMap<Integer, LinkedList<TreeNode>> maps)
	{
		if(node == null)
			return;
		if(!maps.containsKey(level))
			maps.put(level, new LinkedList<>());
		maps.get(level).add(node);
		depths(level+1,node.left,maps);
		depths(level+1,node.right,maps);
	}
	
	
	//Using modified BFS, Time complexity O(n) where n is number of nodes in Binary tree
	public static Stack<LinkedList<TreeNode>> depth(TreeNode root)
	{
		LinkedList<TreeNode> top = new LinkedList<TreeNode>();
		if(root != null)
			top.add(root);
		Stack<LinkedList<TreeNode>> stack = new Stack<>();
		stack.push(top);
		while(!stack.peek().isEmpty())
		{
			LinkedList<TreeNode> newList = new LinkedList<TreeNode>();
			for(TreeNode node:stack.peek())
			{
				if(node.left != null)
					newList.add(node.left);
				if(node.right != null)
					newList.add(node.right);
			}
			stack.push(newList);
		}
		stack.pop();
		return stack;
	}
	
	public static HashMap<Integer,LinkedList<TreeNode>> depthBFS(TreeNode root)
	{
		int level = 0;
		HashMap<Integer, LinkedList<TreeNode>> maps = new HashMap<>();
		maps.put(level, new LinkedList<TreeNode>());
		if(root != null)
			maps.get(level).add(root);
		while(!maps.get(level).isEmpty())
		{
			LinkedList<TreeNode> nodes= maps.get(level);
			maps.put(++level, new LinkedList<TreeNode>());
			for(TreeNode node:nodes)
			{
				if(node.left != null)
					maps.get(level).add(node.left);
				if(node.right != null)
					maps.get(level).add(node.right);
			}
		}
		maps.remove(level);
		return maps;
	}
	
	
}

