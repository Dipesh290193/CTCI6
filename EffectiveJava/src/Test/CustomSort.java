package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CustomSort {
    public static void main(String args[]){
       int[]  arr = {10,10,10};
       sort(arr);
    }

    public static void sort(int[]  arr){
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i : arr){
            Integer num = count.get(i);
            if(num == null){
                count.put(i, 1);
            }
            else{
                count.put(i, num+1);
            }
        }
        ArrayList<Integer>[] sort = new ArrayList[arr.length + 1];
        for(int element: count.keySet()){
            if(sort[count.get(element)] == null){
                sort[count.get(element)] = new ArrayList<>();
            }
            sort[count.get(element)].add(element);
        }
        printSortArray(sort);
    }

    public static void printSortArray(ArrayList<Integer>[] sortArray){
        for(int i = 1 ; i < sortArray.length ; i++){
            if(sortArray[i] != null){
                Collections.sort(sortArray[i]);
                for(int num : sortArray[i]){
                    for(int j = 0 ; j < i ; j++){
                        System.out.println(num);
                    }
                }
            }
        }
    }
}
