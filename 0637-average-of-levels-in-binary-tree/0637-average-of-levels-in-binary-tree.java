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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list=new LinkedList<>();
        if(root==null) return list;
       Queue<TreeNode> ans=new LinkedList<>();
        ans.add(root);
        while(!ans.isEmpty()){                                                       
            int n=ans.size();
           double avgrage=0;
            for(int i=0;i<n;i++){
                 TreeNode curr=ans.poll();
                avgrage+=(double)curr.val;
                if(curr.left!=null){ans.add(curr.left);}
                if(curr.right!=null){ans.add(curr.right);}
            }
            avgrage/=n;
            list.add(avgrage);
        }
       return list; 
    } 
}
