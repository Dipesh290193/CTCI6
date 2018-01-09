package Test;

public class SingleElementInArray {

    public static void main(String args[]){
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length-1);
    }

    public static int singleNonDuplicate(int[] nums, int start, int end){
        if(start > end || start < 0 || end < 0){
            return -1;
        }

        int  mid = (start + end)/2;
        int left = mid -start;
        int right = end -mid;
        if(mid == 0 && nums[mid] != nums[mid+1]){
            return nums[mid];
        }
        else if(mid == nums.length-1 && nums[mid] != nums[mid-1]){
            return nums[mid];
        }
        else if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
            return nums[mid];
        }

        if(nums[mid] == nums[mid -1])
        {
            left--;
        }
        if(nums[mid] == nums[mid+1]){
            right--;
        }
        if(nums[mid] == nums[mid -1] && left % 2 != 0){
            return singleNonDuplicate(nums, start,mid -2);
        }
        else if(left % 2 != 0){
            return singleNonDuplicate(nums, start,mid -1);
        }

        if(nums[mid] == nums[mid+1] && right % 2 != 0){
            return singleNonDuplicate(nums,mid+2, end);
        }
        else if(right % 2 != 0){
            return singleNonDuplicate(nums,mid+1, end);
        }
        return -1;

    }
}
