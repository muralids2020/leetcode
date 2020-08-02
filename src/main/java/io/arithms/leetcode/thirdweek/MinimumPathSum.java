package io.arithms.leetcode.thirdweek;

public class MinimumPathSum {
    //You can only move either down or right at any point in time
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }

        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0]; //initialized very first row and column
        //adding with previous value to current value for first ROW
        for(int i= 1; i<columns ; i++){
            //int k = grid[0][i-1];
            //int l = grid[0][i];
            //dp[0][i]= k+l;
            dp[0][i] =  dp[0][i-1] + grid[0][i] ;
        }
        //adding with previous value to current value for first COLUMN
        for(int j=1; j<rows; j++){
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }

        //Perform the previous row/column value addition to current grid and update with the minimum val
        for(int i=1; i<rows; i++){
            for(int j=1; j<columns; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[rows-1][columns-1];
    }

    /**
     * Given a m x n grid filled with non-negative numbers,
     *
     * find a path from top left to bottom right which minimizes the sum of all numbers along its path
     * @param args
     */
    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        System.out.println("Min. path:"+mps.minPathSum(grid));
    }
}
