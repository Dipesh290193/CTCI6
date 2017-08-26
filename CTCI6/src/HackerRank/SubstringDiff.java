package HackerRank;

import java.util.Scanner;

public class SubstringDiff {

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; i++) {
			String[] inputs = in.nextLine().split(" ");
			int diff = Integer.parseInt(inputs[0]);
			String s1 = inputs[1];
			String s2 = inputs[2];
			System.out.println(substringDiff(s1, s2, diff));
		}
	}

	public static int substringDiff(String s1, String s2, int diff) {
		int max = 0;
		int len = s1.length() - 1;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				int di = 0;
				int a = i;
				int b = j;
				int c = 0;
				int d = 0;
				int L = 0;
				boolean flag = true;
				if (i <= j) {
					c = len - j + i;
					d = len;
				} else {
					c = len;
					d = len - i + j;
				}
				L = c - a + 1;
				if(L > max){
					while (a <= c) {
	
						if (s1.charAt(a) != s2.charAt(b)) {
							di++;
						}
						if (a != c && s1.charAt(c) != s2.charAt(d)) {
							di++;
						}
						if (di > diff) {
							flag = false;
							break;
						}
						a++;
						b++;
						c--;
						d--;
					}
					if (flag && L > max) {
						max = L;
					}
				}
			}
		}
		return max;
	}
}
