package io.arithms.leetcode.firstweek;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubarray {
    /**
     * Kadanes' algorithms
     * introduced two pointers: one points to maxatend:max at given index and maxsofar: max so far....
     * @param a
     * @return
     */
    public int maxSubArray(int[] a) {
        int maxatend = 0;
        int maxsofar = Integer.MIN_VALUE;

        for(int i=0; i<a.length ; i++){
            maxatend = maxatend + a[i];

            if(maxatend < a[i]){
                maxatend = a[i];
            }
            if(maxsofar < maxatend){
                maxsofar = maxatend ;
            }

        }
        return  maxsofar;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1,2,3,-1,-2,10};
        MaximumSubarray msa = new MaximumSubarray();
        int max = msa.maxSubArray(array);
        System.out.println(" Max subarray:"+ max);
    }
}
