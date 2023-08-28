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
    class Tuple{
        int x;
        int y;
        TreeNode node;
        Tuple(TreeNode n, int x, int y){
            this.node=n;
            this.x=x;
            this.y=y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        //treemap stores sorted values according to key which is the vertical axis and hoerizontal axis here
        //we traverse and store in map the vertical and horizontal value and the noedes are sorted according to it
        //we used priority Queue because again we wanted a sorted storage for node which occur at same x and y eg: right node of left 1st node and left node of right first node
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        Queue<Tuple> q= new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple t=q.remove();
            TreeNode n= t.node;
            int x= t.x;//vertical level(x axis val)
            int y=t.y;//horizontal level(y axis)
            //adding empty lists
            if(!map.containsKey(x)) map.put(x,new TreeMap<>());
            if(!map.get(x).containsKey(y)) map.get(x).put(y,new PriorityQueue<>());
            
            //adding value
            map.get(x).get(y).add(n.val);

            //pushing children in queue like normal level order traversal
            if(n.left!=null) q.add(new Tuple(n.left,x-1,y+1));
            if(n.right!=null) q.add(new Tuple(n.right,x+1,y+1));
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> ym:map.values()){
            list.add( new ArrayList<>());
            for(PriorityQueue<Integer> xy:ym.values()){
                while(!xy.isEmpty()){
                    list.get(list.size()-1).add(xy.remove());
                }
            }
        }
        return list;
    }
}