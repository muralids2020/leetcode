package io.arithms.leetcode.fourthweek;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.
 */
public class BitwiseANDofNumberRange {

    public int rangeBitwiseAnd(int m, int n) {
        int shifts = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            shifts++;
        }
        return n << shifts;
    }

    public static void main(String[] args) {
        BitwiseANDofNumberRange bitwiseANDOfNumberRange = new BitwiseANDofNumberRange();
        int m = 5, n = 7;
        System.out.println("Bitwise AND: "+ bitwiseANDOfNumberRange.rangeBitwiseAnd(m, n));
    }
}
