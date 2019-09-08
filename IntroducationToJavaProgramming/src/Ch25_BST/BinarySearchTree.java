package Ch25_BST;

import java.util.Iterator;
import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E>{

	protected TreeNode<E> root;
	protected int size;

	public boolean search(E element)
	{
		TreeNode<E> current=root;
		while(current != null)
		{
			if(current.element.compareTo(element) > 0)
				current=current.left;
			else if(current.element.compareTo(element) < 0)
				current=current.right;
			else
				return true;
		}
		return false;
	}
	public boolean searchRecursion(E e)
	{
		return search(e,root);
	}
	protected boolean search(E e,TreeNode<E> root)
	{
		 if(root == null)
			return false;
		else if(root.element.equals(e))
			return true;			
		else if(root.element.compareTo(e)>0)
			return search(e,root.left);
		else
			return search(e,root.right);
	}
	public boolean insert(E element)
	{
		if(root == null)
		{
			root=new TreeNode<E>(element);
			return true;
		}
		else
		{
			TreeNode<E> parent;
			TreeNode<E> current;
			parent=current=root;
			while(current != null)
			{
				if(current.element.compareTo(element)>0)
				{
					parent=current;
					current=current.left;
				}
				else if(current.element.compareTo(element)<0)
				{
					parent=current;
					current=current.right;
				}
				else
				{
					return false;
				}
			}
			if(parent.element.compareTo(element)>0)
				parent.left=new TreeNode<>(element);			
			else
			{
				parent.right=new TreeNode<>(element);
			}
			size++;
			return true;
		}
	}
	public TreeNode<E> getRoot()
	{
		return root;
	}
	@Override
	public boolean delete(E e) {
		TreeNode<E> parent=null;
		TreeNode<E> current=root;
		while(current != null)
		{
			if(current.element.compareTo(e)>0)
			{
				parent=current;
				current=current.left;
			}
			else if(current.element.compareTo(e)<0)
			{
				parent=current;
				current=current.right;
			}
			else
			{
				break;
			}
		}
		
		if(current == null)
			return false;
		if(current.left == null)
		{
			if(parent == null)
			{
				root=current.right;
			}
			else
			{
				if(parent.element.compareTo(e)>0)
					parent.left=current.right;
				else
					parent.right=current.right;
			}
		}
		else
		{
			TreeNode<E> parentOfRightMost=current;
			TreeNode<E> rightMost=current.left;
			
			while(rightMost.right != null)
			{
				parentOfRightMost=rightMost.right;
				rightMost=rightMost.right;
			}
			
			current.element=rightMost.element;
			if(parentOfRightMost.right== rightMost)
				parentOfRightMost.right=rightMost.left;
			else
				parentOfRightMost.left=rightMost.right;
		}
		size--;
		return true;
	}
	@Override
	public int getSize() {
		return size;
	}
	@Override
	public void clear() {
		root=null;
		size=0;
	}
	@Override
	public void inorder()
	{
		inorder(root);
	}
	protected void inorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.element +" ");
		inorder(root.right);
	}
	@Override
	public void postorder()
	{
		postorder(root);
	}
	protected void postorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		//System.out.print(root.element + " ");
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	@Override
	public void preorder()
	{
		preorder(root);
	}
	protected void preorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		System.out.print(root.element+ " ");
		preorder(root.left);
		preorder(root.right);
		//System.out.print(root.element + " " );
	}
	
	public ArrayList<TreeNode<E>> path(E e)
	{
		ArrayList<TreeNode<E>> list=new ArrayList<>();
		TreeNode<E> current=root;
		while(current != null)
		{
			list.add(current);
			if(current.element.compareTo(e)>0)
				current=current.left;
			else if(current.element.compareTo(e)<0)
				current=current.right;
			else
				break;
		}
		return list;
	}
	public int length(E e)
	{
		ArrayList<TreeNode<E>> list=path(e);
		return list.size()-1;
	}
	
	public int length()
	{
		TreeNode<E> current=root;
		int length=0;
		while(current.left != null)
		{
			current=current.left;
			length++;
		}
		return length;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new InorderIterator();
	}
	private class InorderIterator implements Iterator<E>
	{
		private ArrayList<E> list=new ArrayList<>();
		private int current=0;
		public InorderIterator()
		{
			inorder();
		}
		private void inorder()
		{
			inorder(root);
		}
		private void inorder(TreeNode<E> e)
		{
			if(root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);			
		}
		@Override
		public boolean hasNext() {
			if(current<list.size())
				return true;
			return false;
		}

		@Override
		public E next() {
			return list.get(current++);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}
}
