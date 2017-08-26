package HackerRank;

public class SherlockAndCost {
	
	public static void main(String args[]){
		
	}
	
	public static void findCost(int[] B){
		int low = 0;
		int high = 0;
		boolean l = true;
		boolean h = true;
		for(int i = 1 ; i < B.length; i++){
			if(l){
				low+=B[i]-1;
				l=false;
			}
			else{
				low+=B[i-1]-1;
				l =true;
			}
			if(h){
				high+=B[i-1]-1;
				h=false;
			}
			else{
				high+=B[i]-1;
				h = true;
			}
		}
		
		int cost = (low>high)?low:high;
		System.out.println(cost);
	}

}
