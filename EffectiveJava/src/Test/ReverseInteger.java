package Test;

public class ReverseInteger {

    public static void main(String args[]){
        System.out.print(reverseInt(1023));
    }

    public static int reverseInt(int num){
        int result = 0;
        while(num != 0){
            int lastDigit = num % 10;
            num = num / 10;
            result=(result * 10 )+ lastDigit;
        }
        return result;
    }
}
