package io.arithms.leetcode.May.secondweek;

public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {

        float m_slope = calculateSlope(coordinates[0], coordinates[1]);
        for(int i=2; i<coordinates.length; i++){
            float calSlope = calculateSlope(coordinates[i], coordinates[0]);
            if(m_slope != calSlope){
                return false;
            }
        }
        return true;
    }

    private float calculateSlope(int[] c1, int[] c2) {
        if(c1[0] == c2[0]){
            return 100000;
        }
        return (float)(c2[1]-c1[1])/(c2[0]-c1[0]);
    }

    public static void main(String[] args) {
        CheckIfItIsAStraightLine check4StraightLine = new
                CheckIfItIsAStraightLine();
        //int[][] coordinates={{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates =  {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(" "+check4StraightLine.checkStraightLine(coordinates));
    }
}
