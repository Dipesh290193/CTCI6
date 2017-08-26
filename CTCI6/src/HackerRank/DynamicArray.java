package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int query = in.nextInt();
        int lastAns = 0;
        ArrayList<Integer>[] seqList = new ArrayList[5];
        for(int k = 0 ; k< n ; k++)
        {
        	seqList[k] = new ArrayList<>();
        }
        for(int i = 0;i<query;i++)
        {
         int queryType = in.nextInt();
        if(queryType == 1)
            {
        	int x = in.nextInt();
            int y = in.nextInt();
            int cal  = (x^lastAns)%n;
            seqList[cal].add(y);
        }
        if(queryType == 2)
        {
        	int x = in.nextInt();
            int y = +in.nextInt();
            int cal = (x^lastAns)%n;
            lastAns = seqList[cal].get(y);
            System.out.println(lastAns);
       }
    }
        in.close();
	}
}
