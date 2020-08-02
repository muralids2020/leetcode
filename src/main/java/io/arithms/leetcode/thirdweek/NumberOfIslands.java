package io.arithms.leetcode.thirdweek;

/**
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int noofIslands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    noofIslands +=1;
                    callBSFGrid(grid, i,j);
                }
            }
        }
        return noofIslands;
    }

    private void callBSFGrid(char[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j<0 || j>= grid[i].length || grid[i][j]!='1' ){
            return;
        }
        grid[i][j]= '2';// visiting the Land and increment 1, so that ignore in next visit
        //Since visit horizontally and vertically...
        callBSFGrid(grid, i+1, j);//on X-Axis: right
        callBSFGrid(grid, i-1, j); //X-Axis: left
        callBSFGrid(grid, i, j+1);//on Y-Axis: Up
        callBSFGrid(grid, i, j-1);//on Y-Axis: down
    }

    public static void main(String[] args) {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] grid = { {'1','1','0','0','0'},{'1','1','0','0','0'},
                            {'0','0','1','0','0'}, {'0','0','0','1','1'}};

        System.out.println("No.of Islands:"+ noi.numIslands(grid));
    }
}
