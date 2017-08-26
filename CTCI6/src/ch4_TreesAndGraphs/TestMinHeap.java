package ch4_TreesAndGraphs;

public class TestMinHeap {

	public static void main(String args[])
	{
		MinHeaps minHeap = new MinHeaps();
		minHeap.insert(4);
		minHeap.insert(50);
		minHeap.insert(7);
		minHeap.insert(55);
		minHeap.insert(90);
		minHeap.insert(87);
		minHeap.insert(2);
		minHeap.insert(65);
		System.out.println(minHeap.toString());
		System.out.println(minHeap.remove());
		System.out.println(minHeap.toString());
	}
}
