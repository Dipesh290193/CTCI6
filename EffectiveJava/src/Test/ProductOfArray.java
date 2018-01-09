package Test;

public class ProductOfArray {

    public static  void main(String args[]){
        int[] nums ={1,2,3,4};
        int[] r = productExceptSelf(nums);
        for(int i : r){
            System.out.println(i);
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        product(nums,result,0,1);
        return result;
    }
    public static int product(int[] nums, int[] result, int index,int left){
        if(index == nums.length-1){
            result[index] = left;
            return nums[index];
        }
        int right = product(nums, result, index+1, left*nums[index]);
        result[index] = left*right;
        return right * nums[index];
    }
}
