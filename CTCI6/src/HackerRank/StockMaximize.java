package HackerRank;

import java.util.Scanner;

public class StockMaximize {

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			int[] price = new int[n];
			for (int j = 0; j < n; j++) {
				price[j] = in.nextInt();
			}

			long profit = 0L;
			int minIndex = 0;
			while (minIndex < n) {
				int max = 0;
				int index = -1;
				for (int p = minIndex; p < n; p++) {
					if (price[p] >= max) {
						max = price[p];
						index = p;
					}
				}
				int maxIndex = index + 1;
				while (index >= minIndex) {
					profit += max - price[index];
					index--;
				}
				minIndex = maxIndex;
			}
			System.out.println(profit);
		}
	}
}
