package io.arithms.leetcode.May.firstweek;

public class JewelsNStones {
    public int numJewelsInStones(String J, String S) {
        int num = 0;
        for(int i=0; i<S.length();i++){
            if(J.indexOf(S.charAt(i))> -1){ //-1, since 0th index is very first index
                num ++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        JewelsNStones jewelsNStones = new JewelsNStones();
        String jewels="z";//"aA";
        String stones ="ZZ";//"aAAbbbb";
        System.out.println("No.of Jewels found:"+ jewelsNStones.numJewelsInStones(jewels,stones));
    }
}
