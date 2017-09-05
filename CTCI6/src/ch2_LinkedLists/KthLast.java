package ch2_LinkedLists;

public class KthLast {
	
	public static Node last(Node n, int k){
		Node j = n;
		for(int i =0; i < k && j != null; i++){
			j = j.next;
		}
		
		Node i = n;
		
		while(j.next != null){
			i=i.next;
			j= j.next;
		}
		return i;
	}

}

