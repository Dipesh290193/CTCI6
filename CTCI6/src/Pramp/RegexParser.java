package Pramp;

public class RegexParser {

	public static void main(String args[]){
		System.out.println(isMatch("abbb", "ab*"));
	}
	
	public static boolean isMatch(String text, String pattern){
		return isMatch(text, pattern, 0, 0);
	}
	public static boolean isMatch(String text, String pattern, int startText, int startPattern){
		if(startText == text.length() && pattern.length() == startPattern){
			return true;
		}
		if(startText >= text.length() || pattern.length() <= startPattern){
			return false;
		}
		
		if(pattern.length() -1 == startPattern){
			char r = pattern.charAt(startPattern);
			if(r == '*'){
				return true;
			}
			else if(r == '.'){
				return text.length() - startText == 1;
			}
			else
			{ 
				return text.length() - startText == 1 && text.charAt(startText) == r;
			}
		}
		char regex = pattern.charAt(startPattern+1);
		if(regex == '*'){
			char c = pattern.charAt(startPattern);
			int i = 0;
			while(startText + i < text.length() && text.charAt(startText+i) == c){
				if(isMatch(text, pattern,startText+i , startPattern+2)){
					return true;
				}
				i++;
			}
			return isMatch(text, pattern, startText+i-1, startPattern+2);
		}
		else{
			char r = pattern.charAt(startPattern);
			if(r == '.'){
				return isMatch(text, pattern, startText+1, startPattern+1);
			}
			else{
				return text.charAt(startText) == r && isMatch(text, pattern, startText+1, startPattern+1);
			}
		}
	}
}
