package ch2_LinkedLists;

public class DeleteMiddleNode {

	
	public static void deleteMiddle(Node n){
		if(n.next == null){
			n =null;
			return;
		}
		n.data = n.next.data;
		n.next = n.next.next;
	}
}
