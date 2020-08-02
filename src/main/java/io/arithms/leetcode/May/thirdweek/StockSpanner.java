package io.arithms.leetcode.May.thirdweek;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    private List<Integer> spans;
    private List<Integer> prices;
    public StockSpanner() {
        spans = new ArrayList();
        prices = new ArrayList();
    }

    public int next(int price) {

        int index = prices.size()-1;

        while( index>=0 && prices.get(index) <= price){
            int sp = spans.get(index);
            index = index - sp;
        }
        prices.add(price);
        int span = prices.size()- 1 - index;
        spans.add(span);
        return span;
    }
}
