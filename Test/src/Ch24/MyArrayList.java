package Ch24;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E>{
	
	public static final int INITINAL_CAPACITY=16;
	@SuppressWarnings("unchecked")
	private E[] data=(E[]) new Object[INITINAL_CAPACITY];
	
	public MyArrayList()
	{
		
	}
	public MyArrayList(E[] objects)
	{
		for(int i=0;i<objects.length;i++)
		{
			add(objects[i]);
		}
	}
	@Override
	public void add(int index, E e) {
		ensureCapacity();
		
		for(int i=size-1;i>=index;i--)
		{
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
	}
	@SuppressWarnings("unchecked")
	private void ensureCapacity()
	{
		if(size >= data.length)
		{
			E[] newData=(E[]) new Object[size * 2 + 1];
			System.arraycopy(data, 0, newData, 0, size);
			data=newData;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data=(E[])new Object[INITINAL_CAPACITY];
		size=0;
	}
	@Override
	public boolean contains(E e) {
		for(int i=0;i<size;i++)
		{
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	@Override
	public E get(int index) {
		checkIndex(index);
		
		return data[index];
	}
	private void checkIndex(int index)
	{
		if(index<0 || size <= index)
		{
			throw new IndexOutOfBoundsException("index "+index+" out of bound");
		}
	}
	@Override
	public int indexOf(E e) {
		for(int i=0;i<size;i++)
		{
			if(e.equals(data[i]))
			{
				return i;
			}
		}
		return -1;
	}
	@Override
	public int lastIndexOf(E e) {
		for(int i=size;i>=0;i--)
		{
			if(e.equals(data[i]))
				return i;
		}
		return -1;
	}
	@Override
	public E remove(int index) {
		checkIndex(index);
		E e=data[index];
		for(int i=index;i<size-1;i++)
		{
			data[i]=data[i+1];
		}
		data[size-1]=null;
		size--;
		return e;
	}
	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E old=data[index];
		data[index]=e;
		return old;
	}
	@Override
	public String toString()
	{
		String result="[";
		for(int i =0;i<size;i++)
		{
			result+=data[i];
			if(i<size-1)
				result+=", ";
		}
		result+="]";
		return result;
	}
	@SuppressWarnings("unchecked")
	public void trimToSize()
	{
		if(size != data.length)
		{
			E[] newData=(E[]) new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			data=newData;	
		}
	}
	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}
	private class ArrayListIterator implements Iterator<E>
	{
		private int current=0; 
		@Override
		public boolean hasNext() {
			if(current<size)
				return true;
			return false;
		}

		@Override
		public E next() {
			return data[current++];
		}
		
		@Override
		public void remove() {
			MyArrayList.this.remove(current);
		}		
	}

}
