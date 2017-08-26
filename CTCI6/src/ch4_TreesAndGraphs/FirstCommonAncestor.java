package ch4_TreesAndGraphs;

public class FirstCommonAncestor {

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
		
		TreeNode a = findAncestor(root, new TreeNode(7), new TreeNode(1));
		System.out.println(a.getData());
	}
	
	static TreeNode result = null;
	public static TreeNode findAncestor(TreeNode root, TreeNode first, TreeNode second)
	{
		if(!findAncesor(root, first, second))
			return null;
		return result;
	}
	
	private static boolean findAncesor(TreeNode node, TreeNode first, TreeNode second)
	{
		if(node == null)
			return false;
		if(node.equals(first) || node.equals(second))
			return true;
		
		boolean left = findAncesor(node.left,first,second);
		boolean right =findAncesor(node.right,first,second);
		
		/*if(first.getData() < node.getData() && second.getData() < node.getData())
			 return findAncesor(node.left,first,second);
		else if(first.getData() > node.getData() && second.getData() > node.getData())
			return right = findAncesor(node.right,first,second);
		else
		{
			left= findAncesor(node.left,first,second);
			right = findAncesor(node.right,first,second);
		}*/
		if(left && right)
		{
			result = new TreeNode(node.getData());
			return true;
		}
		
		if(left || right)
			return true;
		
		return false;
	}
	
	//This will only work when both node are available in the tree
	public static TreeNode find(TreeNode n , TreeNode first, TreeNode second)
	{
		if(n == null)
			return null;
		if( n.equals(first) && n.equals(second))
			return n;
		
		
		TreeNode left =  find( n.left ,  first,  second);
		TreeNode right = find(n.right,first,second);
		if(left != null && right != null)
			return n;
		
		if(n.equals(first) || n.equals(second))
			return n;
		
		else if(left != null)
			return left;
		else if(right != null)
			return right;
		
		return null;
		
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode first, TreeNode second)
	{
		Result result = findAnc(root,first,second);
		if(result.node != null)
			return result.node;
		return null;
		
	}
	
	private static Result findAnc(TreeNode n, TreeNode first, TreeNode second)
	{
		if(n == null)
			return new Result(false, null);
		if(n.equals(first) && n.equals(second))
			return new Result(true, n);
		
		Result left = findAnc(n.left, first, second);
		if(left.found)
			return left;
		Result right = findAnc(n.right,first,second);
		if(right.found)
			return right;
		
		if(left.node != null && right.node != null)
			return new Result(true, n);
		else if(n.equals(first) || n.equals(second))
		{
			boolean found= left.node != null || right.node != null;
			return new Result(found, n);
		}
		else
		{
			return new Result(false,(left.node!=null?left.node:right.node));
		}
	}
}

class Result{
	
	public boolean found;
	public TreeNode node;
	
	public Result(boolean found,TreeNode node)
	{
		this.found = found;
		this.node = node;
	}
	
}
