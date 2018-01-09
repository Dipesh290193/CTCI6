package Test;

public class NextGreater {
    public static void main(String args[]){
        int[] nums = {1,8,-1,-100,-1,222,1111111,-111111};
        nextGreaterElements(nums);
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0 ; i <  nums.length; i++){
            result[i] = -1;
            boolean flag = false;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j]>nums[i]){
                    result[i] = nums[j];
                    flag =true;
                    break;
                }
            }
            if(!flag){
                for(int k = 0 ; k < i; k++){
                    if(nums[k]>nums[i]){
                        result[i] = nums[k];
                        break;
                    }
                }
            }
        }
        return result;
    }
}
