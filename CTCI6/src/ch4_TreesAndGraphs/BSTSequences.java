package ch4_TreesAndGraphs;

import java.util.List;
import java.util.ArrayList;

public class BSTSequences {

	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(12);
		root.left= new TreeNode(10);
		root.left.left= new TreeNode(7);
		root.left.right= new TreeNode(11);
		root.right= new TreeNode(15);
		root.right.left= new TreeNode(13);
		root.right.right= new TreeNode(18);
		List<String> possibleArray = getPossibleArray(root);
		for(String s : possibleArray)
		{
			System.out.println(s);
		}
		
	}
	
	public static List<String> getPossibleArray(TreeNode n)
	{
		List<String> list= getStrings(n);
		for(int i=0;i<list.size();i++)
		{
			String s= list.get(i);
			list.set(i, n.getData()+", "+s);
		}
		return list;
	}
	private static List<String> getStrings(TreeNode n)
	{
		if(n.left == null && n.right ==null)
		{
			List<String> list= new ArrayList<>();
			return list;
		}
		else if(n.left == null)
		{
			String s = n.right.getData()+"";
			List<String> list= new ArrayList<>();
			list.add(s);
			return list;
		}
		else if(n.right == null)
		{
			String s =n.left.getData()+"";
			List<String> list= new ArrayList<>();
			list.add(s);
			return list;
		}
		
		List<String> left = getStrings(n.left);
		List<String> right = getStrings(n.right);
		
		List<String> list= new ArrayList<String>();
		
		String leftFirst = n.left.getData()+", "+n.right.getData();
		if(left.size() == 0)
			list.add(leftFirst);
		else
		{
			for(String s:left)
			{
				String l = leftFirst + ", "+s;
				for(String s1:right)
				{
					String l1= l+", "+s1;
					list.add(l1);
				}
			}
		}
		
		String rightFirst = n.right.getData()+", "+n.left.getData();
		
		if(right.size() == 0)
		{
			list.add(rightFirst);
		}
		else
		{
			for(String s:right)
			{
				String l = rightFirst + ", "+s;
				for(String s1:left)
				{
					String l1= l+", "+s1;
					list.add(l1);
				}
			}
		}
		return list;
		
	}
}
