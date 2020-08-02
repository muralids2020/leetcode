package io.arithms.leetcode.firstweek;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class CountingElements {

    /**
     * Constraints:
     * 1 <= arr.length <= 1000
     * 0 <= arr[i] <= 1000
     *
     * Hint #1
     * Use hashset to store all elements.
     * Hint #2
     * Loop again to count all valid elements.
     *
     * @param array
     * @return count
     */
    public int countElements(int[] array) {
        if(array!=null && array.length> 1000){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<array.length; i++) {
            set.add(array[i]);
        }
        int count = 0;
        for(int i=0; i<array.length;i++){
            if(array[i]<0 || array[i]>1000){
                return 0;
            }
            if(set.contains(array[i]+1)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountingElements ce = new CountingElements();
        int[] array = new int[]{1,3,1,5};
        System.out.println(""+ce.countElements(array));
    }
}

