package HackerRank;

import java.util.ArrayList;

public class SeparateNumber {

	public static void main(String[] args) {
		//System.out.println("1234".substring(0, 1));
		isBeauty("9596979899100101102103104105106");
		//System.out.println(Math.floor(3.5));
	}
	
	
	public static void isBeauty(String s){
		
		for(int i =1 ; i <= s.length(); i++ ){
			long first = Long.parseLong(s.substring(0,i));
			long temp = first;
			String test = Long.toString(first);
			while(test.length() < s.length()){
				test+=Long.toString(++temp);
			}
			if(s.equals(test)){
				System.out.println("YES "+first);
				return;
			}
		}
		System.out.println("NO");
	}
	public static void isBeautiful(String s){
        boolean result = false;
        for(int i = 1; i  <= s.length()/2; i++){
            long first = Long.parseLong(s.substring(0,i));
            for(int j = i ; j <= i+1; j++){
                ArrayList<String> possibleDivide = devide(s.substring(i, s.length()), j);
                long temp = first;
                for(String value: possibleDivide){
                    if(value.charAt(0) == '0'){
                        result = false;
                        break; 
                    }
                    else if(Long.parseLong(value) - temp == 1){
                        temp = Long.parseLong(value);
                        result = true;
                    }
                    else{
                        result = false;
                        break; 
                    }
                }
                if(result){
                    System.out.println("YES "+first);
                    return;
                }
            }
        }
        System.out.println("NO");

    }
	    
	    public static ArrayList<String> devide(String s, int number){
	        ArrayList<String> list = new ArrayList<String>();
	        int i = 0 ;
	        for(; i < s.length()-number; i+=number){
	            list.add(s.substring(i,i+number));
	        }
	        list.add(s.substring(i,s.length()));
	        return list;
	    }
}
