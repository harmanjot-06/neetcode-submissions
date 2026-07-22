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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        
        ArrayList<TreeNode> listp = new ArrayList<>();
        ArrayList<TreeNode> listq = new ArrayList<>();

        TreeNode rootp = root;
        TreeNode rootq = root;

        while(rootp.val!=p.val){
            listp.add(rootp);
            if(p.val < rootp.val)rootp = rootp.left;
            else rootp = rootp.right;
        }
        listp.add(rootp);

        while(rootq.val!=q.val){
            listq.add(rootq);
            if(q.val < rootq.val)rootq = rootq.left;
            else rootq = rootq.right;
        }
        listq.add(rootq);
        TreeNode ans = null;

        for(int i=0; i<Math.min(listp.size(), listq.size()); i++){

            if(listp.get(i).val==listq.get(i).val)ans = listp.get(i);
            else return ans;
        }
        return ans;
    }
}
