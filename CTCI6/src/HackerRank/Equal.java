package HackerRank;

import java.util.Scanner;

public class Equal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
        int[] n = new int[num];
        for(int j = 0 ; j < num ; j++){
            n[j] = in.nextInt();
        }
        find(n);
        in.close();
	}
	
	static void equal(int[] n){
		int count = 0;
		while(true){
			int min = Integer.MAX_VALUE;
			int max = 0;
			int  indexMax= -1;
			for(int i = 0 ; i < n.length; i++){
				if(min > n[i]){
					min = n[i];
				}
				if(max < n[i]){
					max = n[i];
					indexMax = i;
				}
			}
			if(min == max){
				break;
			}
			
			if(max - min >= 4){
				n[indexMax]-=5;
			}
			else if(max - min >= 2){
				n[indexMax]-=2;
			}
			else if(max - min >= 1){
				n[indexMax]-=1;
			}
			count++;
		}
		System.out.println(count);
    }

	
	public static void findEq(int[] n){
		long count = 0;
		long min = Integer.MAX_VALUE;
		long max = 0;
		int  maxIndex= -1;
		for(int i = 0 ; i < n.length; i++){
			if(min > n[i]){
				min = n[i];
			}
			if(max < n[i] || n[i] == 0){
				max = n[i];
				maxIndex = i;
			}
		}
		while(min != max){
			long diff = max-min;
            long number = 0;
            if(diff >= 5){
                count+= diff/5;
                number = count*5;
            }
            else if(diff >= 2){
                count+= diff/2;
			    number = count*2;
            }
            else{
                count+=diff;
			    number = count;	
            }
			int index = -1;
			for(int i = 0 ; i < n.length; i++){
				if(i != maxIndex){
					n[i]+=number;
				}
				if(max < n[i]){
					max = n[i];
					index = i;
				}
			}
			min = n[maxIndex];
			maxIndex = index;
		}
		System.out.println(count);
	}
	
	public static void find(int[] n){
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < n.length; i++){
			if(min > n[i]){
				min = n[i];
			}
		}
		int count = Integer.MAX_VALUE;
		for(int i = 0 ; i < 5; i++){
			if(min-i >= 0){
				int ways =  findWays(n,min-i);
				if(ways < count){
					count = ways;
				}
			}
			else{
				break;
			}
		}
		System.out.println(count);
	}
	
	public static int findWays(int[] n , int value){
		int count = 0;
		for(int i = 0 ; i < n.length ;i++){
			int temp = n[i] - value;
			count+=temp/5;
			count+= (temp%5)/2;
			count+= (temp%5)%2;
		}
		return count;
	}
	
}
