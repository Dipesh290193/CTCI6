package Ch25_BST;

import java.util.ArrayList;
public class TestBinarySearchTree {

	public static void main(String args[])
	{
		BinarySearchTree<Integer> tree=new BinarySearchTree<>();
		tree.insert(60);
		tree.insert(55);
		tree.insert(100);
		tree.insert(45);
		tree.insert(57);
		tree.insert(67);
		tree.insert(107);
		tree.insert(35);
		tree.insert(50);
		tree.insert(56);
		tree.insert(59);
		tree.insert(65);
		tree.insert(68);
		tree.insert(101);
		tree.insert(108);
		System.out.print("Inorder sorted:");
		tree.inorder();
		System.out.println();
		System.out.print("Postorder sorted:");
		tree.postorder();
		System.out.println();
		System.out.print("Preoreder Sorted:");
		tree.preorder();
		System.out.println();
		System.out.println("Search 100 in tree is "+tree.searchRecursion(100));
		System.out.println("Search 102 in tree is "+tree.searchRecursion(102));
		
		ArrayList<TreeNode<Integer>> list=tree.path(59);
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i).element+" ");
		}
		System.out.println();
		System.out.println("Length of tree from root to 59 is "+tree.length(59));
		System.out.println("Length of Tree = "+tree.length());
	}
}
