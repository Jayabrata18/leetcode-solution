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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> list = new ArrayList<>();
        int max = -1;
        int min = -1;
        TreeSet<Integer> set = new TreeSet<>();
        inorder(root, set);
        int idx = 0;
        for(int q : queries){
            ArrayList<Integer> base = new ArrayList<>();
            if(set.contains(q)){
                min = q;
                max = q;
            }
            else{
                Integer high = set.higher(q);
                if(high == null){
                    max = -1;
                } else{
                    max = high;
                }
                Integer low = set.lower(q);
                if(low == null){
                    min = -1;
                } else{
                    min = low;
                }
            }
            base.add(min);
            base.add(max);
            list.add(base);
        }
        return list;
    }
    public void inorder(TreeNode root, TreeSet<Integer> set){
        if(root == null){
            return;
        }
        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }
}