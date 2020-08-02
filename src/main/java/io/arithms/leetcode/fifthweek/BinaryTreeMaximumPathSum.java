package io.arithms.leetcode.fifthweek;

/**
 * For this problem, a path is defined as any sequence of nodes from
 * some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum {

    /**
     * Given a non-empty binary tree, find the maximum path sum.
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
         Integer i = Integer.MIN_VALUE;
         return mxptSum(root, i);
    }

    private int mxptSum(TreeNode root, Integer i) {
        if(root ==null){
            return Integer.MIN_VALUE;
        }
        Integer i1 = Integer.MIN_VALUE;
        Integer i2 = Integer.MIN_VALUE;

        int sumOfLeftPath = mxptSum(root.left, i1);
        int sumOfRightPath = mxptSum(root.right, i2);

        i = Math.max(Math.max(i1, i2), 0)+ root.val;

        return Math.max(Math.max(sumOfLeftPath, sumOfRightPath),
                        Math.max(i1, 0)+ Math.max(i2, 0) + root.val);

    }


    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1, left, right);

        BinaryTreeMaximumPathSum btmsp = new BinaryTreeMaximumPathSum();
        System.out.println(""+ btmsp.maxPathSum(treeNode));
    }

}
