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

    public boolean isSame(TreeNode p, TreeNode q){

        if(p==null && q==null)return true;
        if((p==null && q!=null) || (p!=null && q==null))return false;
        if(p.val!=q.val)return false;

        return (isSame(p.left, q.left) && isSame(p.right, q.right));
    }

    public boolean isSub(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot!=null)return false;
        if(subRoot==null)return true;
        
        boolean left = isSub(root.left, subRoot);
        boolean right = isSub(root.right, subRoot);
        boolean same = isSame(root, subRoot);

        return left||right||same;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSub(root, subRoot);
    }
}
