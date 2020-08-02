package io.arithms.leetcode.secondweek;

public class MiddleElement {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next !=null){
                slow = slow.next;
                fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleElement md = new MiddleElement();
        ListNode listNode = new ListNode(10);

        md.middleNode(listNode);
    }
}

/**
 * ListNode definition
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

}
