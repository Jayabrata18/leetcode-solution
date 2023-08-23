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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        // Initialize an empty list to hold the result
        List<List<Integer>> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // Initialize a queue to hold the nodes in the current level
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            
            // Get the number of nodes in the current level
            int levelSize = queue.size();

            // Initialize a list to hold the nodes in the current level
            List<Integer> levelNodes = new ArrayList<>();

            // Traverse the nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                // Get the first node in the queue
                TreeNode node = queue.remove();

                // Add the node's value to the list of nodes in the current level
                levelNodes.add(node.val);

                // Add the node's children to the queue for the next level
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // Add the list of nodes in the current level to the result
            result.add(levelNodes);
        }
    // Return the final result
    return result;
    }
}