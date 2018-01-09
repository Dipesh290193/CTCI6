package Test;

import java.util.HashMap;

public class combinationSum {

    public static void main(String args[]){
        int[] nums = {4,3,1};
        System.out.println(combinationSum4(nums, 32));
    }

    public static int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return combinationSum4(nums, target, map);
    }

    public static int combinationSum4(int[] nums, int target, HashMap<Integer,Integer> map){
        if(target == 0){
            return 1;
        }
        int ways = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= target){
                ways+=combinationSum4(nums, target-nums[i], map);
            }
        }
        return ways;
    }
}
