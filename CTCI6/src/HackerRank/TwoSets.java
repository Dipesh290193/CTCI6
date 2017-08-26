package HackerRank;

public class TwoSets {

	public static void main(String[] args) {
		int[] a = {2,4};
		int[] b = {16,32,96};
		System.out.println(getTotalX(a, b));
	}
	public static int getTotalX(int[] a, int[] b){
        // Complete this function
        int min = 101;
        int max = 0;
        
        for(int i : b){
            if(i >  max){
                max = i;
            }
        }
        
        for (int i :  a){
            if(i < min){
                min = i;
            }
        }
        
        int x = 0;
        for(int i = min; i <= max; i++){
            boolean flag = true;
            for(int numA : a){
                if(i % numA != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int numB : b){
                    if(numB % i != 0){
                    flag = false;
                    break;
                    }
                }
            }
            if(flag){
                x++;
            }
        }
        return x;
    }
}
