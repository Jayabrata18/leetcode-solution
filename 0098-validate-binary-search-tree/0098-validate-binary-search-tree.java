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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);    
//     }
//     public boolean isValid(TreeNode root, long minVal, long maxVal){
//         if(root == null) return true;
//         if (root.val >= maxVal || root.val <= minVal) return false;
//         return isVaild(root.left,  root.val, minVal) && isValid(root.right, root.val, maxVal);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode root, Integer max, Integer min) {

        if(root == null)
            return true;

        if((max != null && root.val >= max) || (min != null && root.val <= min)) {
            return false;
        }

        return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
    }
}