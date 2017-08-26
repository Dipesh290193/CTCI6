package Ch25_BST;

public class TestBSTDelete {

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
		tree.insert(59);
		tree.insert(101);
		printTree(tree);
		
		tree.delete(55);
		System.out.println("Tree After deleting 55");
		printTree(tree);
		
	}
	@SuppressWarnings("rawtypes")
	public static void printTree(BinarySearchTree tree)
	{
		System.out.print("Inorder ");
		tree.inorder();
		System.out.print("\nPostorder ");
		tree.postorder();
		System.out.print("\nPreorder ");
		tree.preorder();
		System.out.println("\n Number of Node in tree= "+tree.getSize());
	}
}
