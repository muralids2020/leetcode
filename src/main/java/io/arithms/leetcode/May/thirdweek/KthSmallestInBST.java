package io.arithms.leetcode.May.thirdweek;


import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger();
        AtomicInteger result =new AtomicInteger();
        findKthSmallest(root, k ,count, result);
        return result.get();
    }

    private void findKthSmallest(TreeNode root, int k, AtomicInteger count, AtomicInteger result) {

        if(root.left != null){
            findKthSmallest(root.left, k , count, result);
        }
        count.getAndIncrement();
        if(count.get() == k){
            result.set(root.val);
            return;
        }

        if(root.right != null) {
            findKthSmallest(root.right , k , count, result);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
