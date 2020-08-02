package io.arithms.leetcode.secondweek;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Simulate the process. We can do it with a heap,
 * or by sorting some list of stones every time we take a turn.
 */
public class LastStoneWeight {

    /**
     * Note:
     * 1 <= stones.length <= 30
     * 1 <= stones[i] <= 1000
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        if(stones.length <1 || stones.length >30){
            throw new RuntimeException("Runtime Exception");
        }
       for(int i=0; i<stones.length; i++){
           if(stones[i]<1 || stones[i]>1000){
               throw new RuntimeException("Runtime Exception");
           }
       }
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(java.util.Comparator.reverseOrder());
        for(int i=0; i< stones.length ; i++){
            pq.offer(stones[i]);
        }
        while( pq.size() > 1){
            int first = pq.poll();
            int second  = pq.poll();
            if(first!= second) {
                pq.offer(first - second);
            }
        }
        return pq.size()!=0? pq.poll(): 0;
    }
    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] array = new int[]{2,0,1};
        int lsw = lastStoneWeight.lastStoneWeight(array);
        System.out.println("Last Stone Weight::"+ lsw);
    }

}
