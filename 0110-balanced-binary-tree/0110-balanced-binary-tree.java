/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(Height(root) == -1) return false; //height function return -1 when unbalanced
        return true;
    }
    private int Height(TreeNode root) {
        if (root== null) return 0;
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight -rightHeight) > 1) return -1;//if height difference more than 1
        return Math.max(leftHeight, rightHeight)+1;
    }
}