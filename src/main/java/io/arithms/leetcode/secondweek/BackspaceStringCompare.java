package io.arithms.leetcode.secondweek;

import java.util.Stack;

/**
 * Solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s_stack = new Stack<Character>();
        Stack<Character> t_stack = new Stack<Character>();
        for(char c: S.toCharArray()){
            if(c != '#'){
                s_stack.push(c);
            }else if(!s_stack.isEmpty()){
                s_stack.pop();
            }
        }
        for(char c:T.toCharArray()){
            if(c != '#'){
                t_stack.push(c);
            }else if(!t_stack.isEmpty()){
                t_stack.pop();
            }
        }

        while(!s_stack.isEmpty()){
            char curr = s_stack.pop();
            if(t_stack.isEmpty() || curr != t_stack.pop()){
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        String s = "a#c";
        String t = "b";
        System.out.println(""+ bsc.backspaceCompare(s, t));
    }

}
