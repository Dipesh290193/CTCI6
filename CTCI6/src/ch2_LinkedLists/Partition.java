package ch2_LinkedLists;

public class Partition {

	public static Node partition(Node n, int partition){
		Node head = n;
		Node tail = n;
		while(n != null){
			Node next = n.next;
			if(n.data < partition){
				n.next = head;
				head = n;
			}
			else{
				tail.next = n;
				tail = n;
			}
			n = next;
		}
		tail.next= null;
		return head;
	}
}
