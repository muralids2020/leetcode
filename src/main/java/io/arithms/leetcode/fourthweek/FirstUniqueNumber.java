package io.arithms.leetcode.fourthweek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You have a queue of integers, you need to retrieve the first unique integer in the queue.
 */
public class FirstUniqueNumber {
    private class ListNode{
        ListNode next;
        ListNode prev;
        int val;
        public ListNode(int val){
            this.val = val;
            next = null;
            prev = null;
        }
    }

    private class DoubleLinkedList{
        ListNode head;
        ListNode tail;

        public DoubleLinkedList(){
            head = new ListNode(-1);
            tail = new ListNode(-1);

            head.next = tail;
            tail.prev = head;
        }

        private ListNode getFirst(){
            return head.next;
        }

        private boolean isEmpty(){
            return head.next == tail;
        }

        private void remove(ListNode node){
            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        private ListNode add(int num){
            ListNode listNode = new ListNode(num);
            ListNode prevNode = tail.prev;
            prevNode.next = listNode;
            listNode.next = tail;
            tail.prev = listNode;
            listNode.prev = prevNode;
            return listNode;
        }

    }

    private DoubleLinkedList keys;
    private Map<Integer, ListNode> map;

    /**
     * Initializes the object with the numbers in the queue.
     */
    public FirstUniqueNumber(int[] nums) {
            keys = new DoubleLinkedList();
            map = new HashMap<>();
            for(int num : nums){
                add(num);
            }
    }

    /**
     * returns the value of the first unique integer of the queue,
     * and returns -1 if there is no such integer.
     * @return
     */
    public int showFirstUnique() {
        if(keys.isEmpty()){
            return -1;
        }else{
            return keys.getFirst().val;
        }
    }

    /**
     * insert value to the queue.
     * @param value
     */
    public void add(int value) {
        if(map.containsKey(value)){
            if(map.get(value)!= null){
                keys.remove(map.get(value));
                map.put(value, null);
            }
        }else{
            ListNode node = keys.add(value);
            map.put(value, node);
        }
    }

    public static void main(String[] args) {

        //int[] nums = {7,7,7,7,7,7};
        int[] nums = {2,3,5};
        FirstUniqueNumber firstUnique = new FirstUniqueNumber(nums);
        /*try {
            System.out.println("" + firstUnique.showFirstUnique()); // return -1
            firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
            firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
            firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
            firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
            firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
            System.out.println("" + firstUnique.showFirstUnique()); // return 17
        }catch (Exception e){
            e.printStackTrace();
        }*/
        try {
            System.out.println(""+firstUnique.showFirstUnique()); // return 2
            firstUnique.add(5);            // the queue is now [2,3,5,5]
            System.out.println(""+firstUnique.showFirstUnique()); // return 2
            firstUnique.add(2);            // the queue is now [2,3,5,5,2]
            System.out.println(""+firstUnique.showFirstUnique()); // return 3
            firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
            System.out.println(""+firstUnique.showFirstUnique()); // return -1
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
