package io.arithms.leetcode.secondweek;

import java.util.Stack;

public class RemoveKdigits {
    public String removeKdigits(String num, int k) {

        int n = num.length();
        if (n == k) return "0";

        Stack<Character> mystack = new Stack<>();

        for(char c: num.toCharArray()){
            while(!mystack.isEmpty() && k >0 && mystack.peek() >c){
                mystack.pop();
                k-=1;
            }
            if(!mystack.isEmpty() || c!='0'){
                mystack.push(c);
            }
        }
        while(!mystack.isEmpty()&& k>0){
            mystack.pop();
            k--;
        }
        if(mystack.isEmpty()) return "0";


        StringBuilder sb = new StringBuilder();
        while(!mystack.isEmpty()){
            char currentChar = mystack.pop();
            sb.append(currentChar);
        }
        sb.reverse();
        while (sb.length()>1 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits rkd = new RemoveKdigits();
        System.out.println(""+rkd.removeKdigits("1432219", 3));
    }
}
