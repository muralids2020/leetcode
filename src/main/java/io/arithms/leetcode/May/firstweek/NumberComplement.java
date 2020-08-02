package io.arithms.leetcode.May.firstweek;

public class NumberComplement {
    public int findComplement(int num) {

        if(num == 0) return 1;
        int numOfBits = (int)(Math.log(num)/Math.log(2)) + 1;
        int mask = (1 << numOfBits) -1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(""+ numberComplement.findComplement(4));
    }
}
