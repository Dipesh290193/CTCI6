package ch4_TreesAndGraphs;

public class RandomNode {

	public static void main(String[] args)
	{
		BST tree = new BST();
		tree.insert(5);
		tree.insert(3);
		tree.insert(10);
		tree.insert(0);
		tree.insert(7);
		tree.insert(12);
		tree.insert(4);
		tree.insert(-4);		
		tree.inorder();
		
		//System.out.println(tree.getRandomNode().getData());
	}
}
class BST
{
	private TreeNode root;
	public boolean insert(int n)
	{
		if(root == null)
		{
			root = new TreeNode(n);
			return true;
		}
		return insert(root,n);
	}
	
	private boolean insert(TreeNode node, int n)
	{
		if(node.left ==null && node.getData() >= n)
		{
			node.left = new TreeNode(n);
			node.childerns++;
			return true;
		}
		else if(node.right == null && node.getData() < n)
		{
			node.right = new TreeNode(n);
			node.childerns++;
			return true;
		}
		if(node.getData() >= n)
		{
			node.childerns++;
			return insert(node.left, n);
		}
		else if(node.getData() < n)
		{
			node.childerns ++;
			return insert(node.right,n);
		}
		return false;
	}
	
	public boolean find(int n)
	{
		return find(root, n);
	}
	
	private boolean find(TreeNode node, int n)
	{
		if(node == null)
			return false;
		if(node.getData() == n)
			return true;
		return find(node.left,n) || find(node.right,n);
	}
	
/*	public boolean remove(int n)
	{
		return remove(root,n);
	}
	
	private boolean remove(TreeNode node, int n)
	{
		if(node == null)
			return false;
		if(node.getData() == n)
		{
			if(node.left == null && node.right == null)
			{
				node = null;
				return true;
			}
			else if(node.left != null)
			{
				
			}
			else if(node.right != null)
			{
				
			}
			else
			{
				
			}
		}
		else if(node.getData() > n)
		{
			if(remove(node.left,n))
			{
				node.childerns--;
				return true;
			}
				
		}
		else
		{
			if(remove(node.right,n))
			{
				node.childerns--;
				return true;
			}
				
		}
		return false;
	}*/
	
	public TreeNode getRandomNode()
	{
		return getRandomNode(this.root);
	}
	private TreeNode getRandomNode(TreeNode node)
	{
		if(node.childerns == 0)
			return node;
		int random = (int)Math.floor(Math.random() * (node.childerns+1));
		int left = node.left==null?0:node.left.childerns;
		if(random < left)
		{
			return getRandomNode(node.left);
		}
		else if(random > left)
		{
			return getRandomNode(node.right);
		}
		else
		{
			return node;
		}
	}
	
	public void inorder()
	{
		inorder(this.root);
	}
	private void inorder(TreeNode root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.println(root.getData() +" "+root.childerns);
		inorder(root.right);
	}
}