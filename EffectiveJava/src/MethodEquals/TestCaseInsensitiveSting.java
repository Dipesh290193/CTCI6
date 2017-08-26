package MethodEquals;

public class TestCaseInsensitiveSting {

	public static void main(String args[]){
		CaseInsensitiveString c = new CaseInsensitiveString("Dipesh");
		String s = "dipesh";
		System.out.println(s.equals(c));
	}
}
