package io.arithms.leetcode.fourthweek;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int largest = 0;
        int rows = matrix.length;
        if(rows==0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];

        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j],(Math.min(dp[i][j-1],dp[i-1][j-1])));
                    if(largest < dp[i][j]){
                        largest = dp[i][j];
                    }
                }
            }
        }
        return largest * largest;
    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        char[][] matrix = {
                {'1', '1','0'},
                { '1', '1', '1'}
                };
        try {
            System.out.println("Max:" + ms.maximalSquare(matrix));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
