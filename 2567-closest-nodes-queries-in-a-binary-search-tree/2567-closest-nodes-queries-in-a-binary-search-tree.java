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
        List<List<Integer>> res = new ArrayList<>();
        TreeNode newNode = rebalanceBST(root);
        
        for (int query : queries) {
            int left = -1;
            int right = -1;
            TreeNode cur = newNode;
            
            while (cur != null) {
                if (query == cur.val) {
                    left = query;
                    right = query;
                    break;
                } else if (query < cur.val) {
                    right = cur.val;
                    cur = cur.left;
                } else {
                    left = cur.val;
                    cur = cur.right;
                }
            }
            
            res.add(Arrays.asList(left, right)); // Store values directly in the result list
        }
        
        return res;
    }

    List<TreeNode> list;

    private TreeNode rebalanceBST(TreeNode node) {
        if (node == null) {
            return null;
        }
        list = new ArrayList<>();
        inOrder(node);
        return constructBST(0, list.size() - 1);
    }

    private TreeNode constructBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = list.get(mid);
        node.left = constructBST(left, mid - 1);
        node.right = constructBST(mid + 1, right);
        return node;
    }

    private void inOrder(TreeNode node) {
        if (node == null) 
            return ;
        inOrder(node.left);
        list.add(node);
        inOrder(node.right);
    }
}