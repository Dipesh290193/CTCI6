package Test;

import java.util.ArrayList;
import java.util.List;

public class FinalDiscount {
    public static void main(String args[]){
        int[] price = {2,0, 1};
        finalPrice(price);
    }

    public static void finalPrice(int[] price){
        int totalDiscount = 0;
        int[] nonDiscount = new int[price.length];
        for(int i = 0 ; i< price.length; i++){
            int discount = 0;
            boolean flag = false;
            for(int j = i+1; j < price.length; j++){
                if(price[j] <= price[i] ){
                    discount = price[j];
                    if(price[j] == 0){
                        flag = true;
                    }
                    break;
                }
            }
            if(flag){
                nonDiscount[i] = 1;
            }
            else{
                nonDiscount[i] = discount;
            }

            totalDiscount+=(price[i]-discount);

        }
        System.out.println(totalDiscount);
        for(int i = 0 ; i < nonDiscount.length; i++){
            if(nonDiscount[i] == 0)
                System.out.print(i+" ");
        }
    }
}
