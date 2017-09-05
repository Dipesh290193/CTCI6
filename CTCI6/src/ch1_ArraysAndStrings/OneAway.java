package ch1_ArraysAndStrings;

public class OneAway {
	
	public static void main(String args[]){
		System.out.println(oneAway("pale","pla"));
		System.out.println(oneAway("pales","pale"));
		System.out.println(oneAway("pale","bale"));
		System.out.println(oneAway("pale","bake"));
	}
	
	public static boolean oneAway(String a, String b){
		if( a == null || b == null){
			return false;
		}
		if(Math.abs(a.length() - b.length()) > 1){
			return false;
		}
		
		if(a.length() == b.length()){
			int countDiff = 0;
			
			 for(int i = 0; i< a.length(); i++){
				 if(a.charAt(i) != b.charAt(i)){
					 countDiff++;
				 }
			 }
			 return countDiff <= 1;
		}
		
		if(a.length() > b.length()){
			return addDelete(a,b);
		}
		return addDelete(b, a);
	}
	
	private static boolean addDelete(String longer, String sorter){
		int countDiff = 0;
		int i = 0 ,j =0;
		for(; j<sorter.length(); i++, j++){
			
			if(longer.charAt(i) != sorter.charAt(j)){
				countDiff++;
				j--;
			}
			if(countDiff > 1){
				return false;
			}
		}
		
		if(i < longer.length() -1){
			countDiff++;
		}
		
		return countDiff <= 1;
	}

}
