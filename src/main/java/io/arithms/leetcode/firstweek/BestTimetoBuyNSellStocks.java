package io.arithms.leetcode.firstweek;

/**
 * Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * i.e., buy one and sell one share of the stock multiple times.
 *
 * Note: You may not engage in multiple transactions at the same time
 * i.e., you must sell the stock before you buy again.
 */
public class BestTimetoBuyNSellStocks {

    /**
     *
     * @param args
     */
    public int maxProfit(int[] prices) {
        if(prices ==null && prices.length ==0){
            return 0;
        }
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i]-prices[i-1];
            if(diff > 0){
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTimetoBuyNSellStocks bts = new BestTimetoBuyNSellStocks();

        int[] prices =  new int[]{1,4,3,5,2,1,7};
        System.out.println("Max Profit: "+bts.maxProfit(prices));
    }
}
