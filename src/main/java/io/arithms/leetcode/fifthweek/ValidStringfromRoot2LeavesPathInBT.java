package io.arithms.leetcode.fifthweek;

public class ValidStringfromRoot2LeavesPathInBT {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null) {
            return arr.length == 0;
        }
        return isValid(root, arr, 0);
    }

    private boolean isValid(TreeNode root, int[] array, int index) {
        //the current index=0, so cross check, if it's root
        if(root.val != array[index]) {
            return  false;
        }
        //check for the last index should be either left leaf/right leaf
        if(index == array.length - 1) {
            return root.left == null && root.right ==null;
        }
        /**
         * First index=0 as root and last index=arrray.length-1 as eith left/right leaf
         * check is done and below is for rest of the array elements are either left/right nodes
         */
        return (root.left != null && isValid(root.left, array, index++) ||
                root.right !=null && isValid(root.right, array, index++));
    }

    public static void main(String[] args) {
        ValidStringfromRoot2LeavesPathInBT vsinBT = new ValidStringfromRoot2LeavesPathInBT();
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left.val = 0;
        root.right.val = 0;

        int[] array={1,0,0};
        vsinBT.isValidSequence(root, array);
    }
}
