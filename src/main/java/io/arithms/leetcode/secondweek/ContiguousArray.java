package io.arithms.leetcode.secondweek;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {

    //The length of the given binary array will not exceed 50,000.
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(0, -1);

        int maxLength = 0;
        int count = 0;
        for(int i=0; i<nums.length ; i++){
            if(nums[i] == 0){
                count = count - 1;
            }else{
                count = count + 1;
            }
            if(hashMap.containsKey(count)){
                maxLength = Math.max(maxLength, i- (hashMap.get(count)));
            }else{
                hashMap.put(count, i);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        ContiguousArray ca = new ContiguousArray();
        int[] binaryArray = new int[]{0,1,0};
        int length = ca.findMaxLength(binaryArray);
        System.out.println("Max. length "+ length);
    }
}
