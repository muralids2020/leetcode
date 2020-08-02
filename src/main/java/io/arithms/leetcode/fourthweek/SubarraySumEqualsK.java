package io.arithms.leetcode.fourthweek;

import java.util.HashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int sum = 0;
        for(int i= 0; i< nums.length; i++){
            sum += nums[i];

            if(hashMap.containsKey(sum - k)){
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0)+ 1);

        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int[] array = {3,4,7,2,-3,1,4,2};
        int K = 7;
        System.out.println("No.Of Sub Arrays:"+ subarraySumEqualsK.subarraySum(array, K));
    }
}
