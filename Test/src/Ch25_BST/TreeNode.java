package Ch25_BST;

class TreeNode<E> {
	 
	 protected E element;
	 protected TreeNode<E> left;
	 protected TreeNode<E> right;
	 
	 TreeNode(E e)
	 {
		 this.element=e;
		 this.left = null;
		 this.right = null;
	 }

}
