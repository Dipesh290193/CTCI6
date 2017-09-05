package ch1_ArraysAndStrings;

public class StringCompression {
	
	public static void main(String args[]){
		System.out.println(compress("aabccccaaa"));
	}

	public static String compress(String s){
		if( s == null || s.length() == 0){
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while( i < s.length()){
			int count = 0;
			char c = s.charAt(i);
			while( i < s.length() && s.charAt(i) == c){
				i++;
				count++;
			}
			sb.append(c+""+count);
		}
		
		if(sb.length() > s.length()){
			return s;
		}
		return sb.toString();
	}
}
