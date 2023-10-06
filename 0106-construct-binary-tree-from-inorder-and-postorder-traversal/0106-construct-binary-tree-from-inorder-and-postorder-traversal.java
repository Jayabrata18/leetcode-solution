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
          int i, o;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length-1;
        o = postorder.length-1;
        return build(inorder, postorder, 3001);
    }
    public TreeNode build(int[] inorder, int[] postorder, int left){
        if(o == -1 || inorder[i] == left){
            return null;
        }
        TreeNode node = new TreeNode(postorder[o--]);
        node.right = build(inorder, postorder, node.val);
        i--;
        node.left = build(inorder, postorder, left);
        return node;
    }
}