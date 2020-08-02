package io.arithms.leetcode.thirdweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne{

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();

        int rows = list.get(0);
        int cols = list.get(1);

        int result = -1;

        int r = 0;
        int c = cols - 1;
        while(r < rows && c >= 0){
            if(binaryMatrix.get(r,c)== 1){
                result = c;
                c--;
            }else{
                r++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeftmostColumnWithAtLeastAOne lmcw1 = new LeftmostColumnWithAtLeastAOne();
        BinaryMatrix binaryMatrix = null;
        lmcw1.leftMostColumnWithOne(binaryMatrix);
    }

}