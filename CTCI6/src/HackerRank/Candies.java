package HackerRank;

import java.util.Scanner;

public class Candies {

	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in  =  new Scanner(System.in);
        int n = in.nextInt();
        int[] rating = new int[n];
        int[] c = new int[n];
        for(int i = 0 ; i < n; i++){
           rating[i] = in.nextInt();
        }
       
        if(rating[0]<=rating[1])
        {
            c[0] = 1;
        }
        else{
            c[0] = find(rating, c, 1)+1;
        }
        if(rating[n-1] <= rating[n-2]){
            c[n-1] = 1;
        }
       else{
            c[n-1] = find(rating, c, n-2)+1;
        }
        
        for(int i = 1; i< n-1; i++){
            if(c[i] == 0){
                c[i]= find(rating, c, i);
            }
        }
        
        long sum = 0 ;
        for(int i: c){
            sum+=i;
        }
        
        System.out.println(sum);
       
    }
    
    public static int find(int[] rating, int[] c, int index){
        if(rating[index] <= rating[index-1] && rating[index] <= rating[index+1]){
            return 1;
        }
        
        if(rating[index] > rating[index-1] && rating[index] > rating[index+1]){
            if(c[index-1] == 0){
                c[index-1] = find(rating, c, index-1);
            }
            if(c[index+1] == 0){
                c[index+1] = find(rating, c , index+1);
            }
            
            return rating[index-1] < rating[index+1] ? c[index+1]+1: c[index-1]+1;
        }
        if(rating[index] > rating[index-1]){
            if(c[index-1] == 0){
                c[index-1] = find(rating, c, index-1);
            }
            return 1+ c[index-1];
        }
        if(rating[index] > rating[index+1]){
            if(c[index+1] == 0){
                c[index+1] = find(rating, c, index+1);
            }
            return 1+ c[index+1];
        }
        
        
        return 1;
    }
		
}
