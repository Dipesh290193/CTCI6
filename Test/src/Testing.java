
public class Testing {

	/*
	 * What is lexicographical comparison ? Compare character by character for
	 * both the string, one string is greater then another if a character is of
	 * higher ASCII value @ same position on both the string.
	 * 
	 * Example S1 = ABC, S2 = ABD => Answer is -1 S1 = AB, S2 = ABCD => Answer
	 * is -1 S1 = ABD, S2 = ABD => Answer is 0 S1 = mahesh, S2 = mahesh =>
	 * Answer is 0 S1 = ABD, S2 = ABC => Answer is +1 S1 = ABCDEF, S2 = ABCDE =>
	 * Answer is +1
	 * 
	 * Return +1 if s1 is lexicographically greater then s2 Return 0 is s1 and
	 * s2 are same Return -1 if s1 is lexicographically smaller then s2
	 */
public static void main(String args[])
{
	System.out.println(compare("ABC", "ABD"));
	System.out.println(compare("ABD", "ABD"));
}
	public static int compare(String s1, String s2) {
		if (s1 != null && s2 != null) {
			if (s1.length() > s2.length()) {
				return 1;
			} else if (s1.length() < s2.length()) {
				return -1;
			} else {
				for (int i = 0; i < s1.length(); i++) {
					if (s1.charAt(i) > s2.charAt(i)) {
						return 1;
					} else if (s1.charAt(i) < s2.charAt(i)) {
						return -1;
					}
				}
			}
			return 0;
		} else {
			throw new NullPointerException("");
		}
	}
}
