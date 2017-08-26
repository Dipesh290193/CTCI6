package HackerRank;

import java.util.Scanner;

public class MissingNumbers {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int[] memo = new int[100];
        int[] arrN = new int[n]; 
        int min = 10000;
        for(int i = 0 ; i < n ; i++)
        {
            arrN[i] = in.nextInt();
            if(arrN[i] < min){
                min = arrN[i];
            }
        }
        int m = in.nextInt();
        for(int i = 0 ; i < m; i++){
            int num = in.nextInt();
            memo[num-min]++;
        }
        for(int num : arrN){
            memo[num-min]--;
        }
        for(int i=0; i<memo.length; i++){
            if(memo[i] > 0){
                System.out.println(min+i);
            }
        }
        in.close();
    }
}
