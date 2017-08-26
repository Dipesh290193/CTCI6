package ch4_TreesAndGraphs;

public class Successor {

	public static void main(String[] args) {
		
	}
	
	public static TreeNode next(TreeNode n)
	{
		if(n == null)
			return null;
		if(n.right != null)
		{
			n =n.right;
			while(n.left != null)
				n = n.left;
			return n;
		}
		
		else
		{
			TreeNode q =n;
			TreeNode parent = q.parent;
			while(parent != null && parent.left != q)
			{
				q =parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

}
