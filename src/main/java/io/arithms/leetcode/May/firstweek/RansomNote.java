package io.arithms.leetcode.May.firstweek;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for(char mc: magazine.toCharArray()){
            if(map.containsKey(mc)){
                map.put(mc, map.get(mc)+1);
            }else{
                map.put(mc, 1);
            }
        }
        for(char rc: ransomNote.toCharArray()){
            if(map.containsKey(rc)== false){
                return false;
            }
            if(map.get(rc)==0){
                return false;
            }
            map.put(rc, map.get(rc)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        String ransom = "aa";
        String magazine = "bbb";
        System.out.println(""+ransomNote.canConstruct(ransom, magazine));
    }
}
