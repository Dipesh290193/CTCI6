package Ch24;

import java.util.Iterator;

public class MyLinkedList<E>  extends MyAbstractList<E>{

	Node<E> head=null;
	Node<E> tail=null;
	
	public MyLinkedList()	{
		
	}
	public MyLinkedList(E[] elements)
	{
		for(int i=0;i<elements.length;i++)
		{
			add(elements[i]);
		}
	}
	public void addFirst(E element)
	{
		Node<E> newNode=new Node<E>(element);
		newNode.next=head;
		head=newNode;
		size++;
		if(tail==null)
		{
			tail=head;
		}
	}
	public void addLast(E element)
	{
		Node<E> newNode=new Node<E>(element);
		if(tail !=null)
		{
			tail.next=newNode;
			tail=newNode;
			//tail=tail.next;
		}
		else
		{
			tail=newNode;
			head=tail;			
		}
		size++;
	}
	public E getFirst(E element)
	{
		return head.element;
	}
	public E getLast(E element)
	{
		return tail.element;
	}
	public E removeFirst()
	{		
		if(size != 0)
		{
			Node<E> removeElement=head;
			head=head.next;
			size--;
			if(head == null)
				tail= null;
			return removeElement.element;	
		}
		return null;
	}
	public E removeLast()
	{
		if(size== 0)
			return null;
		else if(size == 1)
		{
			Node<E> lastElement=tail;
			head=tail=null;
			size--;
			return lastElement.element;
		}
		else
		{
			Node<E> current=head;
			for(int i=1;i<size-1;i++)
				current=current.next;
			Node<E> temp=current.next;
			tail=current;
			tail.next=null;
			size--;
			return temp.element;
		}
	}
	@Override
	public void add(int index, E e) 
	{
		if(index == 0)
			addFirst(e);
		else if(index>=size)
			addLast(e);
		else
		{
			Node<E> current=head;
			for(int i=1;i<index;i++)
				current=current.next;
			Node<E> temp=current.next;
			current.next=new Node<E>(e);
			(current.next).next=temp;
			size++;
		}
	}
	@Override
	public void clear() {
			size=0;
			head=tail=null;			
	}
	@Override
	public boolean contains(E e) {
		Node<E> current=head;
		if(current.element.equals(e))
			return true;
		for(int i=1;i<size;i++)
		{
			current=current.next;
			if(current.element.equals(e))
				return true;
		}
		return false;
	}
	@Override
	public E get(int index) {
		if(index<0 || index >= size)
			return null;		
		else if(index==0)
			return head.element;
		else if(index==size-1)
			return tail.element;
		else
		{
			Node<E> current=head;
			for(int i=1;i<=index;i++)
				current=current.next;
			return current.element;
		}
	}
	@Override
	public int indexOf(E e) {
		if(head.element.equals(e))
			return 0;
		else if(tail.element.equals(e))
			return size-1;
		else
		{
			Node<E> current=head;
			for(int i=1;i<size;i++)
			{
				current=current.next;
				if(current.equals(e))
				{
					return i;
				}
			}
		}
		return -1;
	}
	@Override
	public int lastIndexOf(E e) {
		if(tail.element.equals(e))
			return size-1;
		else
		{
			Node<E> current=head;
			int index=-1;
			for(int i=1;i<size;i++)
			{
				current=current.next;
				if(current.equals(e))
				{
					index=i;
				}
			}
			return index;
		}
	}
	@Override
	public E remove(int index) {
		if(index<0 || index>=size)
			return null;
		else if(index==0)
			return removeFirst();
		else if(index == size-1)
			return removeLast();
		else
		{
			Node<E> previous=head;
			for(int i=1;i<index;i++)
				previous =previous.next;
			Node<E> current=previous.next;
			previous.next=current.next;
			size--;
			return current.element;
		}
	}
	@Override
	public E set(int index, E e) {
		if(index < 0 || index>= size)
			return null;
		else if(index == 0)
			return head.element=e;
		else if(index == size-1)
			return tail.element=e;
		else
		{
			Node<E> current=head;
			for(int i=1;i<=index;i++)
				current=current.next;
			E element=current.element;
			current.element=e;
			return element;			
		}
	}
	
	@Override
	public String toString()
	{
		String result="[";
		Node<E> current=head;
		for(int i=0;i<size;i++)
		{
			result+=current.element;
			current=current.next;
			if(current != null)
			{
				result+=", ";
			}
		}
		result+="]";
		return result;
	}
	@Override
	public Iterator<E> iterator() {
		return new MyLinkedListIterator();
	}
	private class MyLinkedListIterator implements Iterator<E>
	{
		private Node<E> current=head;
		@Override
		public boolean hasNext() {
			return (current != null);
		}

		@Override
		public E next() {
			E e = current.element;
			current=current.next;			
			return e;
		}

		@Override
		public void remove() {
			int index= indexOf(current.element);	
			MyLinkedList.this.remove(index);
		}		
	}
	private static class Node<E>
	{
		E element;
		Node<E> next;
		
		public Node(E e)
		{
			this.element=e;
		}
	}
}
