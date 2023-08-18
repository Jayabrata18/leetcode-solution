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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return helper(root);
    }
    private static int helper(TreeNode root){
        if(root.left==null && root.right == null)
        return 1;
        else if(root.right == null && root.left != null)
        return helper(root.left)+1;
        else if(root.left == null && root.right != null)
        return helper(root.right)+1;
        else {
            return Math.min(helper(root.left), helper(root.right))+1;
        }
    }
  
}