package io.arithms.leetcode.secondweek;

public class DiameterDFS {

    private int ans = 1;
    private int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int temp = left + right + 1;
        ans = temp > ans ? temp : ans;
        int depth = left > right ? left : right;
        return depth + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }

    public static void main(String[] args) {
         DiameterDFS diameterDFS = new DiameterDFS();
         TreeNode treeNode = diameterDFS.createNewNode(2);

        int diameter = diameterDFS.diameterOfBinaryTree(treeNode);
        System.out.println("Diameter:"+ diameter);

    }
    public TreeNode createNewNode(int val) {
        TreeNode newNode = new TreeNode();
        newNode.val = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
