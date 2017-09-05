package ch1_ArraysAndStrings;

public class URLify {

	public static String urlify(String s, int trueLength){
		char[] chars = s.toCharArray();
		int spaces = 0;
		for(int i = 0 ; i < trueLength ;i ++){
			if(chars[i] == ' '){
				spaces++;
			}
		}
		int index = spaces * 2 + trueLength;
		for(int i = trueLength; i>= 0; i--){
			if(chars[i] == ' '){
				chars[--index]= '0';
				chars[--index]= '0';
				chars[--index]= '0';
			}
			else{
				chars[index] = chars[i];
				index--;
			}
		}
		return chars.toString();
	}
}
