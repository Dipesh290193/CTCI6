package ch4_TreesAndGraphs;

public class CheckSubtree {

	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(12);
		root.left= new TreeNode(10);
		root.left.left= new TreeNode(7);
		root.left.right= new TreeNode(11);
		root.right= new TreeNode(15);
		root.right.left= new TreeNode(13);
		root.right.right= new TreeNode(18);
		
		TreeNode root2 = new TreeNode(15);
		root2.left = new TreeNode(13);
		root2.right = new TreeNode(18);
		
		System.out.println(isSubtree(root,root2));
	}
	
	public static boolean isSubtree(TreeNode n1, TreeNode n2)
	{
		if(n2 == null)
			return true;
		if(n1 == null)
			return false;
		if(n1.equals(n2))
			return identical(n1,n2);
		if(isSubtree(n1.left,n2))
			return true;
		return isSubtree(n1.right, n2);
	}
	
	public static boolean identical(TreeNode n1, TreeNode n2)
	{
		if(n1 == null && n2 == null)
			return true;
		if(!n1.equals(n2))
			return false;
		boolean left = identical(n1.left,n2.left);
		boolean right = identical(n1.right, n2.right);
		if(left && right)
			return true;
		return false;
	}
}
