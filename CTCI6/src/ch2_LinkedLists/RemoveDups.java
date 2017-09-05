package ch2_LinkedLists;
import java.util.*;
public class RemoveDups {

	public static void main(String[] args) {
		
	}
	
	//Time complexity O(n), Space Complexity O(n)
	public static void removeDups(Node n){
		if( n == null)
			return;
		HashSet<Integer> dups = new HashSet<Integer>();
		Node pre = n;
		dups.add(pre.data);
		Node current = n.next;
		while(current != null){
			if(dups.contains(current.data)){
				pre.next = current.next;
			}
			else{
				dups.add(current.data);
				pre = current;
			}
			current = current.next;
		}
	}
	
	//Time complexity is O(n^2), Space complexity is  O(1)
	public static void removeDuplicate(Node n){
		Node current = n;
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}
				else{
					runner =runner.next;
				}
			}
			current = current.next;
		}
	}
}

