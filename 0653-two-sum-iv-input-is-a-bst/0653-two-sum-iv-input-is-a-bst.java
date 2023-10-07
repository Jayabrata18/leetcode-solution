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
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    private boolean dfs(TreeNode root, TreeNode cur, int target) {
        if(cur == null) return false;
        return search(root, cur, target - cur.val) ||
               dfs(root, cur.left, target) ||
               dfs(root, cur.right, target);
    }
    private boolean search(TreeNode root, TreeNode cur, int target) {
        if(root == null) return false;
        return (root.val == target && cur != root)||
               (target > root.val && search(root.right, cur, target)) || 
               (target < root.val && search(root.left, cur, target));
    }
}
