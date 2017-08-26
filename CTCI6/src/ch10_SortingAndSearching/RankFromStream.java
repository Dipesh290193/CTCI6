package ch10_SortingAndSearching;

public class RankFromStream {

	public static void main(String args[])
	{
		
	}
}

class BinarySearchTree{
	
	private TreeNode root = null;
	
	public void track(int x)
	{
		if(root == null)
		{
			root = new TreeNode(x);
			return;
		}
		TreeNode n = root;
		TreeNode pre = null;
		while(n != null)
		{
			pre = n;
			if(n.data >= x)
			{
				n.leftNodes++;
				n = n.left;
			}
			else
			{
				n = n.right;
			}
		}
		
		if(x < pre.data)
			pre.left = new TreeNode(x);
		else
			pre.right = new TreeNode(x);
	}
	
	public int getRankofNumber(int x)
	{
		if(root == null)
			return 0;
		return getRankofNumber(root, x);
	}
	
	public int getRankofNumber(TreeNode n, int x)
	{
		if(n == null)
			return -1;
		if(n.data == x)
			return n.leftNodes;
		else if(n.data < x)
		{
			int rank = getRankofNumber(n.right, x);
			if(rank != -1)
			{
			 rank += 1 + n.leftNodes;
			}
			return rank;
		}
		else
		{
			return getRankofNumber(n.left, x);
		}
	}
}

class TreeNode{
	int data;
	int leftNodes = 0;
	TreeNode left = null;
	TreeNode right = null;
	
	public TreeNode(int data)
	{
		this.data = data;
	}
	
}
