package io.arithms.leetcode.thirdweek;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;

           if(target == nums[mid]){
               return mid;
           } else if(nums[mid] >= nums[left]){
                if(target <= nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
           } else{
               if(target >= nums[mid] && target <= nums[right]){
                   left = mid + 1;
               }else{
                   right = mid - 1;
               }
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray srsa = new SearchInRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4;
        int index = srsa.search(nums, target);
        System.out.println("Found at Index:"+ index);
    }
}
