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
    static TreeSet<Integer> preorder(TreeNode root,TreeSet<Integer> set){
        if(root == null) return set;
        set  = preorder(root.left, set);
        set.add(root.val);
        set  = preorder(root.right, set);
        return set;
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
    List<List<Integer>> result = new ArrayList<>();
    TreeSet<Integer> set = new TreeSet<>();
  
    set = preorder(root, set);
    for (int target : queries) {
        List<Integer> closestNode = new ArrayList<>();
        if(set.floor(target)!=null){
                closestNode.add(set.floor(target));
        }
        else{
                closestNode.add(-1);
        }
        
        if(set.ceiling(target)!=null){
                closestNode.add(set.ceiling(target));
        }
        else{
                closestNode.add(-1);
        }
        result.add(closestNode);
    }
        return result;
    }
}