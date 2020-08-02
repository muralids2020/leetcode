package io.arithms.leetcode.May.secondweek;

import sun.text.normalizer.Trie;

public class Tries {

    private Tries children[];
    private boolean isEndofWord;
    /** Initialize your data structure here. */
    public Tries() {
        children = new Tries[26];
        isEndofWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Tries curr = this;
        for(char ch:word.toCharArray()){
            if(curr.children[ch - 'a']==null){
                curr.children[ch - 'a'] = new Tries();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEndofWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Tries curr = this;
        for(char ch: word.toCharArray()){
            curr = curr.children[ch - 'a'];
            if(curr == null){
                return false;
            }

        }
        if(curr.isEndofWord) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Tries curr = this;
        for(char ch: prefix.toCharArray()){
            curr = curr.children[ch - 'a'];
            if(curr == null){
                return false;
            }
        }
        return true;
    }
}
