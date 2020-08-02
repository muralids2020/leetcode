package io.arithms.leetcode.firstweek;

/**
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class MovingZerosToEnd {
    /**
     * 1. In-place means we should not be allocating any space for extra array.
     * But we are allowed to modify the existing array.
     * However, as a first step, try coming up with a solution that makes use of additional space.
     * For this problem as well, first apply the idea discussed using an additional array and
     * the in-place solution will pop up eventually.
     */

    /**
     * 2. A two-pointer approach could be helpful here.
     * The idea would be to have one pointer for iterating the array and
     * another pointer that just works on the non-zero elements of the array.
     */

    public void moveZeroes(int[] nums) {
        if(nums.length ==0 && nums==null){
            return;
        }
        int index=0;
        for(int i= 0; i< nums.length; i++){
            if(nums[i]!= 0){
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }
        for(int i=0;i<nums.length; i++){
            System.out.print(nums[i]);
        }
    }

    public static void main(String[] args) {
        MovingZerosToEnd mz = new MovingZerosToEnd();
        int[] nums = new int[] {0,1,0,3,12};
        mz.moveZeroes(nums);

    }
}
