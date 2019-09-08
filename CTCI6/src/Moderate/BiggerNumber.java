package Moderate;

public class BiggerNumber {
    public static void main(String args[]){
        int i = -4; // 100
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i >> 31));
        System.out.println(i >> 31);
        System.out.println(max(Integer.MAX_VALUE -2,-4));
        System.out.println(max(3,3));
    }

    public static int max(int a, int b){
        int diff = a - b;
        int k = diff & (1 << 31);
        k = (k >> 31) + 1;
        return (b * (1 - k)) + (a * k);
    }
}
