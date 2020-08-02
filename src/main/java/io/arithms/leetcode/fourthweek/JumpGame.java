package io.arithms.leetcode.fourthweek;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index
 * of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max_reach = 0;

        for(int i=0; i< nums.length; i++){
         if(nums[i]+ i > max_reach){
             max_reach = nums[i] + i;
         }
         if(max_reach == i)
             break;
        }
        return max_reach >= nums.length-1;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        //int[] array = {2,3,1,1,4};
        int[] array = {3,2,1,0,4};
        System.out.println(""+ jumpGame.canJump(array));
    }
}
