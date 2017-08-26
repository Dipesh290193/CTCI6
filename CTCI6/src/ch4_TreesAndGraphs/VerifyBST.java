package ch4_TreesAndGraphs;

public class VerifyBST {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(7);
		root.right = new TreeNode(18);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(20);
		root.left.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(10);
		root.right.right.right = new TreeNode(21);
		
		System.out.println(isBST(root));
	}
	
	public static boolean isBST(TreeNode node)
	{
		return isBST(node, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private static boolean isBST(TreeNode node, int min, int max)
	{
		if(node  == null)
			return true;
		if(node.getData() >= min && node.getData() < max)
			return  isBST(node.left,min,node.getData()) && isBST(node.right,node.getData(),max);
		return false;
	}
	
}
