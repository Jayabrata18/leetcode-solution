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
    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if(root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int val = 0;

        if(root.left != null && root.val == root.left.val)
            val = Math.max(val, left + 1);

        if(root.right != null && root.val == root.right.val)
            val = Math.max(val, right + 1);

        if(
            root.right != null &&
            root.left != null &&
            root.val == root.right.val &&
            root.val == root.left.val
        )
            result = Math.max(result, left + right + 2);

        result = Math.max(result, val);
        
        return val;
    }
}
