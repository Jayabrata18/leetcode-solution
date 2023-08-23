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
    int max = -10000;

    public int maxPathSum(TreeNode root) {
        max = -10000;
        maxFinder(root);
        return max;
    }

    public int maxFinder(TreeNode root) {

        if(root == null) {
            return 0;
        }

        
        int LTreeMax = root.left == null  ? -1000 : maxFinder(root.left);
        int RTreeMax = root.right == null ? -1000 : maxFinder(root.right);
        // System.out.println("rootval   " + root.val);
        // System.out.println("  LtreeMax  " + LTreeMax);
        // System.out.println("  rtreeMax  " + RTreeMax);
        
        int max1 = LTreeMax + RTreeMax + root.val;
        int max2 = LTreeMax + root.val;
        int max3 = RTreeMax + root.val;

        int maxSubtree = Math.max(max2, Math.max(max3, root.val));
        // System.out.println("   maxSubTree  " + maxSubtree);

        max = Math.max(max, Math.max(maxSubtree, Math.max(max1, Math.max(LTreeMax, RTreeMax))))     ;
        return maxSubtree;
    }
}