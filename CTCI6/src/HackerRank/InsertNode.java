package HackerRank;

public class InsertNode {

	public static void main(String[] args) {
		LinkedListNode n = new LinkedListNode(1);
		n.next= new LinkedListNode(2);
		n.next.next= new LinkedListNode(2);
		n.next.next.next = new LinkedListNode(3);
		n.next.next.next.next = new LinkedListNode(3);
		n.next.next.next.next.next = new LinkedListNode(4);
		LinkedListNode result = removeDuplicates(n);
		while(result != null)
		{
			System.out.println(result.data);
			result = result.next;
		}
	}
	
	
	public static LinkedListNode removeDuplicates(LinkedListNode head)
	{
		if(head == null)
			return null;
		LinkedListNode i =head;
		LinkedListNode j = head.next;
		while( j != null)
		{
			while(j != null && i.data == j.data)
			{
				j = j.next;
			}
			i.next= j;
			i = j;
		}
		return head;
	}
	public static int getNodeFromLast(LinkedListNode head, int position)
	{
		LinkedListNode i = head;
		LinkedListNode j = head;
		
		while(position>1)
		{
			i = i.next;
			position--;
		}
		while( i.next != null)
		{
			i = i.next;
			j = j.next;
		}
		return j.data;
	}
	
	public static LinkedListNode insert(LinkedListNode head, int data)
	{
		if(head == null)
		{
			head = new LinkedListNode();
			head.data = data;
			return head;
		}
		else
		{
			LinkedListNode n = head;
			LinkedListNode p = null;
			while(n != null)
			{
				p = n;
				n = n.next;
			}
			n = new LinkedListNode();
			n.data = data;
			p.next = n;
			return head;
		}
	}
}

class LinkedListNode{
	int data;
	LinkedListNode next;
	
	public LinkedListNode(int data)
	{
		this.data = data;
	}
	public LinkedListNode()
	{
		
	}
	
}
