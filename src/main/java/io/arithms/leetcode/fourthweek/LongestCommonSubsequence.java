package io.arithms.leetcode.fourthweek;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order of
 * the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 * If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] lcmarray = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for( int j=1; j<=n ;j++){
                if(text1.charAt(i-1)== text2.charAt(j-1)){
                    lcmarray[i][j] = 1+ lcmarray[i-1][j-1];
                } else{
                    lcmarray[i][j] = Math.max(lcmarray[i][j-1], lcmarray[i-1][j]);
                }
            }
        }
        return lcmarray[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abc";
        String text2 = "def";
        System.out.println("LCS:"+ lcs.longestCommonSubsequence(text1, text2));
    }
}
