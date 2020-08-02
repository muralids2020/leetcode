package io.arithms.leetcode.firstweek;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 */
public class FindUniqueNumber {

    /**
     * Algorithm should have a linear runtime complexity
     * @param a
     * @return
     */
    public int singleNumber(int[] a){
        if(a.length != 0 && a.length==1){
            return a[0];
        }
        for(int i=0; i< a.length; i++){
            for(int j=i+1; j<a.length; j++) {

                if (a[i]!=Integer.MIN_VALUE && a[i] == a[j]) {
                    a[i]=a[j]= Integer.MIN_VALUE;
                }
            }
        }
        for(int k=0; k<a.length;k++){
            if(a[k]!= Integer.MIN_VALUE){
                return a[k];
            }
        }
       return 0;
    }

    public int singleNumber2(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,2,4,1};
        FindUniqueNumber fu = new FindUniqueNumber();
        int unique = fu.singleNumber2(nums);
        System.out.println("Unique Number:"+ unique);
    }
}
