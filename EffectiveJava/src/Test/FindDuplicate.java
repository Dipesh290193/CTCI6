package Test;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicate {

    public static void main(String args[]){
        char op = '+';
        System.out.println(Integer.parseInt("-2") + 3);
        char c ='\u0000';
        /*int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDuplicate(nums);
        for(int  i : result){
            System.out.println(i);
        }*/
    }

    public static List<Integer> findDuplicate(int[] nums){
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        for(int i : nums){
            if(i > len){
                i = i - len;
            }

            if(nums[i-1] > len){
                result.add(i);
            }
            else{
                nums[i-1]+=len;
            }
        }
        return result;
    }
}
