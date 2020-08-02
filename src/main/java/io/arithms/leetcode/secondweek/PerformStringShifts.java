package io.arithms.leetcode.secondweek;


/**
 *
 */
public class PerformStringShifts {
    /**
     *
     * @param s
     * @param shift
     * @return
     */
    public String stringShift(String s, int[][] shift) {
        int val = 0;
        for(int i=0; i<shift.length; i++){
            int shiftLength = shift[i][0] == 0 ? -shift[i][1] : shift[i][1];
            val = val+shiftLength;
        }
        int stringLength = s.length();
        val = val % stringLength;

        String finalStr="";
        if(val > 0){
            finalStr = s.substring(stringLength-val) + s.substring(0, stringLength-val);
        }else{
            val = Math.abs(val);
            finalStr = s.substring(val) + s.substring(0, val);
        }
        return finalStr;
    }

    public static void main(String[] args) {
        PerformStringShifts pss = new PerformStringShifts();
        //String str = "abc";int[][] shift = {{0,1},{1,2}};
        String str="abcdefg";
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        String finalString = pss.stringShift(str, shift);
        System.out.println("final shifted string:"+ finalString);
    }
}
