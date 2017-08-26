package ch7_ObjectOrientedDesign;

import java.util.Iterator;

public class CircularArray<T> {

	public static void main(String args[])
	{
		MyCircularArray<String> circularArray = new MyCircularArray(5);
		circularArray.set(0, "Dipesh");
		circularArray.set(1, "Meet");
		circularArray.set(2, "Sevak");
		circularArray.set(3, "Sid");
		circularArray.set(4, "Ammar");
		
		circularArray.rotateRight(2);
		circularArray.rotateRight(-3);
		
		System.out.println(circularArray.get(0));
	}
	
}

class MyCircularArray<T> implements Iterable<T>
{
	private T[] items;
	private int head = 0;
	
	@SuppressWarnings("unchecked")
	public MyCircularArray(int size)
	{
		items =(T[]) new Object[size];
	}
	
	private int rotate(int times)
	{
		if(times < 0)
		{
			times += items.length;
		}
		return (head+times) % items.length;
	}
	
	public void rotateRight(int rotateNumber)
	{
		this.head = rotate(rotateNumber);
	}
	
	public void set(int index, T data)
	{
		items[rotate(index)] = data;
	}
	public T get(int index)
	{
		if(index<0 || index >= items.length)
			throw new IndexOutOfBoundsException(index+" is out of bound");
		return items[rotate(index)];
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator();
	}
	
	private class CircularArrayIterator implements Iterator<T>
	{
		private int current  = -1;

		@Override
		public boolean hasNext() {
			return current < items.length-1;
		}

		@Override
		public T next() {
			current++;
			return items[rotate(current)];
		}
		
	}
	
}
