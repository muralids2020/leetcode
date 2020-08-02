package io.arithms.leetcode.thirdweek;


import java.util.Stack;

public class BinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        for(int i=1; i< preorder.length ;i++){
            TreeNode temp = null;
            while(!stack.isEmpty() && preorder[i]>stack.peek().val) {
                temp = stack.pop();
            }
            if(temp !=null){
                temp.right = new TreeNode(preorder[i]);
                stack.push(temp.right);
            } else{
                temp = stack.peek();
                temp.left = new TreeNode(preorder[i]);
                stack.push(temp.left);
            }
        }
    return root;
    }
    public static void main(String[] args) {

    }
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}

