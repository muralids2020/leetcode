package io.arithms.leetcode.fourthweek;

import java.util.LinkedHashMap;

public class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> linkedHashMap;
    int val;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<>();
        this.val = 0;
    }

    public int get(int key) {
        if(linkedHashMap!= null && linkedHashMap.containsKey(key)){
            val = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(linkedHashMap.containsKey(key)){
            linkedHashMap.remove(key);
        } else if(linkedHashMap.size() == capacity) {
            linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
        }
        linkedHashMap.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Return: "+ cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println("Return: "+cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println("Return: "+cache.get(1));       // returns -1 (not found)
        System.out.println("Return: "+cache.get(3));       // returns 3
        System.out.println("Return: "+cache.get(4));       // returns 4
    }
}
