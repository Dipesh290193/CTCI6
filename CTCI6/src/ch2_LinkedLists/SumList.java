package ch2_LinkedLists;

public class SumList {
	
	public static void main(String args[]){
		Node a = new Node(7);
		a.next = new Node(1);
		a.next.next = new Node(6);
		a.next.next.next = new Node(9);
		
		Node b = new Node(5);
		b.next = new Node(9);
		b.next.next = new Node(9);
		
		Node result = sumDiff(a,b,0);
		while(result != null){
			System.out.print(result.data);
			result = result.next;
		}
		
	}
	
	public static Node sumDiff(Node a, Node b, int carry){
		if(a == null && b == null && carry == 0){
			return null;
		}
		
		int value = carry;
		if(a != null){
			value+= a.data;
		}
		if(b != null){
			value+= b.data;
		}
		
		Node result = new Node(value%10);
		
		if(a != null || b != null){
			Node n = sumDiff(a == null ? null: a.next, b == null ? null : b.next, value/10);
			result.next= n;
		}
		
		return result;
		
	}
	

	//Assuming a and b are same length
	public static Node sum(Node a, Node b){
		int carry = 0;
		Node head = null;
		Node tail = null;
		while(a != null && b != null){
			int sum = carry + a.data + b.data;
			int data= sum %10;
			carry = sum /10;
			
			if(head == null){
				Node n = new Node(data);
				head = n;
				tail = n;
			}
			else{
				tail.next = new Node(data);
				tail = tail.next;
			}
			a = a.next;
			b= b.next;
		}
		
		if( carry != 0){
			tail.next = new Node(carry);
			tail = tail.next;
		}
		return head;
	}
	
	
	private static Node result = null;
	public static Node sumReverse(Node a, Node b){
		if(a == null){
			return b;
		}
		if(b == null){
			return a;
		}
		
		int carry = sumReverseHelper(a, b);
		if(carry != 0){
			Node n = new Node(carry);
			n.next= result;
			result = n;
		}
		return result;
		
	}
	
	private static int sumReverseHelper(Node a, Node b){
		int sum = 0;
		if( a.next == null && b.next == null){
			sum = a.data + b.data;
			result = new Node(sum % 10);
			return sum /10;
		}
		
		int carry = sumReverseHelper(a.next, b.next);
		sum = carry + a.data + b.data;
		Node n = new Node(sum %10);
		n.next = result;
		result = n;
		return sum /10;
	}
}

