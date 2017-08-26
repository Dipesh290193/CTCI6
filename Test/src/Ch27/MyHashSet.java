package Ch27;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
public class MyHashSet<E> implements MySet<E>{

	private static int DEFAULT_INITIAL_CAPACITY=4;
	
	private static int MAXIMUM_CAPACITY=1 << 30;
	
	private int capacity;
	
	private static float DEFAULT_MAX_LOAD_FACTOR=0.75f;
	
	private float loadFactorThreshold;
	
	private int size;
	
	private LinkedList<E>[] table;

	public MyHashSet()
	{
		this(DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_LOAD_FACTOR);
	}
	public MyHashSet(int initialCapacity)
	{
		this(initialCapacity,DEFAULT_MAX_LOAD_FACTOR);
	}
	public MyHashSet(int initialCapacity,float loadFactorThreshold)
	{
		if(initialCapacity> MAXIMUM_CAPACITY)
		{
			this.capacity=MAXIMUM_CAPACITY;
		}
		else
		{
			this.capacity=trimToPowerOf2(initialCapacity);
			this.loadFactorThreshold=loadFactorThreshold;
			table=new LinkedList[capacity];			
		}		
	}
	private int trimToPowerOf2(int initialCapacity)
	{
		int capacity=1;
		while(capacity<initialCapacity)
		{
			capacity <<= 1;
		}
		return capacity;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		size=0;
		removeElements();
	}
	private void removeElements()
	{
		for(int i=0;i<capacity;i++)
		{
			if(table[i] != null)
			{
				table[i].clear();
			}
		}
	}

	@Override
	public boolean contains(E e) {
		int bucketIndex=hash(e.hashCode());
		if(table[bucketIndex] != null)
		{
			LinkedList<E> bucket=table[bucketIndex];
			for(E element:bucket)
			{
				if(element.equals(e))
					return true;
			}
		}
		return false;
	}

	private int hash(int hashCode)
	{
		return supplementalHash(hashCode) & capacity-1;
	}
	
	private static int supplementalHash(int h)
	{
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^(h >>> 7 ) ^ (h >>> 4);
	}
	@Override
	public boolean add(E e) {
		if(contains(e))
			return false;
		if(size+1>capacity*loadFactorThreshold)
		{
			if(capacity==MAXIMUM_CAPACITY)
				throw new RuntimeException("");
			rehash();
		}
		
		return true;
	}
	private void rehash()
	{
		ArrayList<E> list = new ArrayList<>();
		for(int i=0;i<capacity;i++)
		{
			if(table[i] != null)
			{
				for(E e:table[i])
				{
					list.add(e);
				}
			}
		}
		capacity <<= 1;
		table= new LinkedList[capacity];
		size=0;
		
		for(E element:list)
		{
			add(element);
		}
		
	}
	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
