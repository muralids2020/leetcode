package io.arithms.leetcode.firstweek;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 * 1. All inputs will be in lowercase.
 * 2. The order of your output does not matter.
 */
public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {

        Collections.sort(Arrays.asList(strs));

        List<List<String>> result = new ArrayList<List<String>>();
        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] arr = new char[26];
            for(int i = 0; i < str.length(); i++){
                arr[str.charAt(i)-'a']++;
            }
            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(str);
            }else{
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(ns, al);
            }
        }

        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        GroupAnagram ga = new GroupAnagram();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> resp = ga.groupAnagrams(strs);
        System.out.println(""+resp);
    }
}
