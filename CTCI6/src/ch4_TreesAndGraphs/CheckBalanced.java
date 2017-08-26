package ch4_TreesAndGraphs;

public class CheckBalanced {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(15);
	//	root.childerns = 9;
		root.left = new TreeNode(7);
		//root.left.childerns = 4;
		root.right = new TreeNode(18);
		//root.right.childerns = 3;
		root.left.left = new TreeNode(1);
		//root.left.left.childerns = 1;
		root.left.right = new TreeNode(9);
		//root.left.right.childerns = 1;
		root.right.left = new TreeNode(17);
		//root.right.left.childerns = 0;
		root.right.right = new TreeNode(20);
		//root.right.right.childerns = 1;
		root.left.left.right = new TreeNode(4);
		//root.left.left.right.childerns = 0;
		root.left.right.right = new TreeNode(10);
		//root.left.right.right.childerns= 0;
		root.right.right.left = new TreeNode(21);
		//root.right.right.left.childerns = 0;
		
		System.out.println(isBalanced(root));
		
	}
	
	
	//Time complexity is O(n), space complexity is O(H) where H is height of the tree
	public static boolean isBalanced(TreeNode root)
	{
		return checkBalanced(root) != -1;
	}
	
	private static int checkBalanced(TreeNode node)
	{
		if(node == null)
			return 0;
		int left = checkBalanced(node.left);
		int right = checkBalanced(node.right);
		if(left == -1 || right == -1)
			return -1;
		int diff = Math.abs(left - right);
		if(diff > 1)
			return -1;
		return left+right+1;
	}
	
	
	//If we store number of children at each node in TreeNode class while inserting the node
	public static boolean isBalance(TreeNode node)
	{
		if(node == null ||node.childerns == 0 )
			return true;
		int left = (node.left != null ? node.left.childerns: 0);
		int right = (node.right != null ? node.right.childerns : 0);
		int diff = Math.abs(left -right);
		if(diff > 1)
			return false;
		if(!isBalance(node.left) || !isBalance(node.right))
			return false;
		return true;
	
	}
}
