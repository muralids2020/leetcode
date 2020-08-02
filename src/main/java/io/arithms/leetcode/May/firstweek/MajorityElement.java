package io.arithms.leetcode.May.firstweek;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int index = 0;
        int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[index] == nums[i]){
               count++;
            }else{
                count--;
            }
            if(count == 0){
                index = i;
                count = 1;
            }
        }
        return nums[index];
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums={2,2,1,1,1,2,2};//{3,2,3};//{2,3,3,4,4,4,4};
        System.out.println(""+ me.majorityElement(nums));
    }
}
