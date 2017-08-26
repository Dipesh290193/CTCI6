package ch4_TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathsWithSum {
 
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		
		System.out.println(getPathsWithSum(root, 8));
	}
	
	public static int getPathsWithSum(TreeNode n, int targetSum)
	{
		return getPathsWithSum(n,0,targetSum,new HashMap<Integer, Integer>());
	}
	
	private static int getPathsWithSum(TreeNode n, int runningSum, int targetSum, HashMap<Integer, Integer> map)
	{
		if(n == null)
			return 0;
		runningSum+=n.getData();
		int sum = runningSum - targetSum;
		int paths = map.getOrDefault(sum, 0);
		if(runningSum == targetSum)
			paths++;
		
		map.put(runningSum, 1);
		
		paths+=getPathsWithSum(n.left, runningSum, targetSum, map);
		paths+=getPathsWithSum(n.right, runningSum, targetSum, map);
		map.put(runningSum,map.get(runningSum)-1);
		
		if(map.get(runningSum) == 0)
			map.remove(runningSum);
		return paths;
	}
	
	public static int countPaths(TreeNode root, int targetSum)
	{
		if(root == null)
			return 0;
		int pathsFromRoot = countPaths(root,targetSum,0);
		int pathsFromLeft = countPaths(root.left,targetSum,0);
		int pathsFromRight = countPaths(root.right,targetSum,0);
		return pathsFromLeft+pathsFromRight+pathsFromRoot;
	}
	
	public static int countPaths(TreeNode node, int targetSum, int currentSum)
	{
		if(node == null)
			return 0;
		currentSum+=node.getData();
		int totalPaths = 0;
		if(currentSum == targetSum)
			totalPaths++;
		totalPaths += countPaths(node.left, targetSum, currentSum);
		totalPaths += countPaths(node.right, targetSum, currentSum);
		
		return totalPaths;
	}
	
	private static int count = 0;
	public static int paths(TreeNode root,int sum)
	{
		traverse(root,sum);
		return count;
	}
	private static List<Integer> traverse(TreeNode n, int sum)
	{
		if(n == null)
			return null;
		if(n.left == null && n.right == null)
		{
			List<Integer> list= new ArrayList<>();
			list.add(n.getData());
			if(n.getData() == sum)
				count++;
			return list;
		}
		
		List<Integer> lists = new ArrayList<>();
		
		List<Integer> left = traverse(n.left,sum);
		if(left != null)
		{
			for(int list : left)
			{
				int check = list+ n.getData();
				if(check == sum)
					count++;
				lists.add(list+n.getData());
			}
		}
		
		List<Integer>right = traverse(n.right,sum);
		if(right != null)
		{
			for(int list : right)
			{
				int check = list+ n.getData();
				if(check == sum)
					count++;
				lists.add(list + n.getData());
			}
		}
		
		return lists;
	}
}
