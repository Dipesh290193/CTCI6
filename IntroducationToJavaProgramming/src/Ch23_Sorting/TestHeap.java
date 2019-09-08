package Ch23_Sorting;


public class TestHeap {

	public static void main(String args[])
	{
		Integer[] list={1,5,9,10,25,0,-2,-3,-9};
		Heap<Integer> heap=new Heap<>(list);
		for(int i=list.length-1;i>=0;i--)
		{
			list[i]=heap.remove();
		}
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	}

}
