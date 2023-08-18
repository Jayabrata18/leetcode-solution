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
    public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length-1);
    }
    public TreeNode CreateBST(int nums[], int left, int right){
        if(left>right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = CreateBST(nums, left, mid-1);
        root.right = CreateBST(nums, mid+1, right);
        return root;
    }
}