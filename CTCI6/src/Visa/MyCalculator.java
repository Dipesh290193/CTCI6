package Visa;

public class MyCalculator {

    public static void main(String args[]){
        int x= 0;
        int y = 0;
        for(int z = 0; z < 5; z++){
            if((++x >2) && (++y) > 2 ){
                x++;
            }
        }
        System.out.print(x +" ,"+y);
    }

    public int power(int n, int p) throws Exception {
        if(n < 0 || p < 0){
            throw new Exception("n and p should be non-negative");
        }
        return (int)Math.pow(n, p);
    }
}
