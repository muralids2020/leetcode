package io.arithms.leetcode.May.firstweek;

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c:s.toCharArray()){
            count[c - 'a'] +=1;
        }
        for(int i=0; i<s.length(); i++){
            if(count[s.charAt(i) - 'a'] ==1 ){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString fucis = new FirstUniqueCharacterInAString();

        String s="aaac";
        System.out.println("Found at:"+ fucis.firstUniqChar(s));

    }
}
