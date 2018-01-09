package Sample;

public class Solution {

	public static void main(String args[]){
		int[] P = {2,1,4,3};
		System.out.println(solution(P, 1));
	}
	
	public static int solution(int[] P, int K) {
        // write your code in Java SE 8
		boolean[] days = new boolean[P.length];
		Node root = new Node(P.length);
		for(int i = 0; i < P.length;i++){
			days[P[i]-1] = true;
			root.left = new Node(calculateLeft(days, P[i]-1));
			root.right = new Node(calculateRight(days, P[i]-1));
			
			if(root.left.NumOfEmptyGroup == K){
				return i+1;
			}
			if(root.right.NumOfEmptyGroup == K){
				return i+1;
			}
		}
		
		return -1;
    }
	
	public static int calculateLeft(boolean[] days, int index){
		if(index <= 0 ){
			return 0;
		}
		int left = 0;
		for(int i = index -1; i>=0 && !days[i]; i--){
			left ++;
		}
		return left;
		
	}
	
	public static int calculateRight(boolean[] days, int index){
		
		if(index >= days.length-1){
			return 0;
		}
		int right =0;
		
		for(int i = index+1;i<days.length && !days[i];i++){
			right++;
		}
		return right;
	}
	
	
}

class Node{
	Node left;
	Node right;
	int NumOfEmptyGroup;
	public Node(int numOfEmptyGroup){
		this.NumOfEmptyGroup=numOfEmptyGroup;
	}
}
 