package io.arithms.leetcode.thirdweek;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums
 * except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

    /**
     * Note: Please solve it without division and in O(n).
     * Could you solve it with constant space complexity?
     * (The output array does not count as extra space for the purpose of space complexity analysis.)
     * @param nums
     */
    public int[] productExceptSelf_bruteforce(int[] nums) {
        int[] res=new int[nums.length];
        int k=0;
        for(int i=0; i<nums.length ; i++){
            int prod = 1;
            for(int j=0; j<nums.length; j++){
                if(i != j){
                    prod = prod * nums[j];
                }
            }
            res[k++]= prod;
        }
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf poa = new ProductOfArrayExceptSelf();
        int[] array = new int[]{2,2,2,2,2};
        //int[] res = poa.productExceptSelf_bruteforce(array);
        //int[] res = poa.productExceptSelf(array);
        int[] res = poa.productExceptSelf_SpaceComplex(array);
        for(int i:res){
            System.out.print(" "+i+" ");
        }
    }

    private int[] productExceptSelf_SpaceComplex(int[] nums) {

        int[] outputArray = new int[nums.length];
        outputArray[0] = 1;
        for(int i= 1; i < nums.length; i++){
            outputArray[i] = nums[i-1]* outputArray[i-1];
        }
        int rightArrayVal = 1;
        for(int i=nums.length-1; i>=0; i--){
            outputArray[i]= outputArray[i]* rightArrayVal ;
            rightArrayVal = rightArrayVal * nums[i];
        }

        return outputArray;
    }

    private int[] productExceptSelf(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        int[] outputArray = new int[nums.length];
        leftArray[0]=1;

        rightArray[nums.length -1]=1;

        for(int i= 1; i < nums.length; i++){
            leftArray[i] = nums[i-1]* leftArray[i-1];
        }
        for(int i=nums.length-2; i>=0; i--){
            rightArray[i]= nums[i+1]* rightArray[i+1];
        }
        for(int i=0; i<nums.length; i++){
            outputArray[i]= leftArray[i]*rightArray[i];
        }
        return outputArray;
    }
}
