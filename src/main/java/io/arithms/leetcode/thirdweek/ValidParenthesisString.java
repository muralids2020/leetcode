package io.arithms.leetcode.thirdweek;

import java.util.Stack;

public class ValidParenthesisString {

    /**
     * validity of a string by these rules:
     * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
     * Any right parenthesis ')' must have a corresponding left parenthesis '('.
     * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
     * '*' could be treated as a single right parenthesis ')' or
     * a single left parenthesis '(' or an empty string.
     * An empty string is also valid.
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        if(s.length()== 0){
            return true;
        }else if(chars[0]==')'){
            return false;
        }

        Stack<Integer> charStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == '('){
                charStack.push(i);
            }else if(chars[i] == '*'){
                starStack.push(i);
            }else{
                if(!charStack.isEmpty()) {
                    charStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        while(! charStack.isEmpty()){
            if(starStack.isEmpty()){
                return false;
            }else if(charStack.peek()<starStack.peek()){
                charStack.pop();
                starStack.pop();
            }else {
                return false;
            }
        }

        return true;
    }

    /**
     * Given a string containing only three types of characters: '(', ')' and '*',
     * write a function to check whether this string is valid.
     * @param args
     */
    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        String str = "";
        boolean isValid = vps.checkValidString(str);
        System.out.println("Valid Parenthesis String:"+ isValid);
    }
}
