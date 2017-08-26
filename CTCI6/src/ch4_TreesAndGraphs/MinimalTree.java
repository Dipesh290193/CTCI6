package ch4_TreesAndGraphs;

public class MinimalTree {

	public static void main(String[]  args)
	{
		int[] nodes ={1,4,7,9,10,15,17,18,20};
		TreeNode root = createTree(nodes);
		System.out.println(root);
	}
	
	//Time complexity O(n)
	public static TreeNode createTree(int[] nodes)
	{
		int n = nodes.length /2;
		TreeNode root = new TreeNode(n);
		createTree(0,n-1,root.left,nodes);
		createTree(n+1,nodes.length-1,root.right,nodes);
		return root;
	}
	
	private static void createTree(int	 startIndex, int endIndex, TreeNode node, int[] nodes )
	{
		if(startIndex > endIndex)
			return;
		int n = (startIndex + endIndex) / 2;
		node = new TreeNode(nodes[n]);
		createTree(startIndex, n-1, node.left, nodes);
		createTree(n+1, endIndex, node.right, nodes);
	}
	
	//CTCI soultion, time complexity O(n), but looks clean
	public static TreeNode createMinimalBST(int[] nodes)
	{
		return createMinimalBST(nodes, 0 , nodes.length-1);
	}
	
	private static TreeNode createMinimalBST(int[] nodes, int start, int end)
	{
		if(start>end)
			return null;
		int mid =(start + end)/2;
		TreeNode n = new TreeNode(nodes[mid]);
		n.left = createMinimalBST(nodes, start,mid-1);
		n.right = createMinimalBST(nodes, mid+1, end);
		return n;
	}
	
}

class TreeNode
{
	private int data;
	TreeNode left;
	TreeNode right;
	int childerns;
	TreeNode parent;
	
	public TreeNode(int data)
	{
		this.setData(data);
		childerns = 0;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o)
			return true;
		if(!(o instanceof TreeNode))
			return false;
		TreeNode node = (TreeNode) o;
		return  getData() == node.getData();
	}
	
	@Override
	public int hashCode()
	{
		return this.data * 31;
	}
	
}


