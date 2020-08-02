package io.arithms.leetcode.May.firstweek;

import java.util.concurrent.atomic.AtomicInteger;

public class CousinsInBinaryTree {
    public boolean cousins(TreeNode root, int x, int y){
        AtomicInteger px = new AtomicInteger();
        AtomicInteger py = new AtomicInteger();
        AtomicInteger dx = new AtomicInteger(-1);
        AtomicInteger dy = new AtomicInteger(-1);

        areCousins(root, 0, x, y, dx, dy, px, py);
        return ((dx.get() == dy.get())&& (px.get() != py.get()));
    }
    private void areCousins(TreeNode root, int d, int x, int y,
                               AtomicInteger dx, AtomicInteger dy,
                               AtomicInteger px, AtomicInteger py){
        if(root == null){
            return;
        }
        if(root.left != null){
            if(root.left.val == x){
                px.set(root.val);
                dx.set( d + 1);
            } else if(root.left.val == y){
                px.set(root.val);
                dx.set( d + 1);
            }
        }
        if(root.right != null){
            if(root.right.val == x){
                py.set(root.val);
                dy.set( d + 1);
            } else if(root.right.val == y){
                py.set(root.val);
                dy.set( d + 1);
            }
        }
        if(dx.get()!= -1 && dy.get() != -1){
            return;
        }

        areCousins(root.left, d+1, x, y, dx, dy, px , py);
        areCousins(root.right, d+1, x, y, dx, dy, px, py);
    }
    public static void main(String[] args) {
        CousinsInBinaryTree cousins = new CousinsInBinaryTree();
        TreeNode treeNode = new TreeNode(2);
        int x=4,  y =6;
        System.out.println(""+ cousins.cousins(treeNode, x, y));
    }

}


class TreeNode {
    int val;
    io.arithms.leetcode.May.firstweek.TreeNode left;
    io.arithms.leetcode.May.firstweek.TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, io.arithms.leetcode.May.firstweek.TreeNode left, io.arithms.leetcode.May.firstweek.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
