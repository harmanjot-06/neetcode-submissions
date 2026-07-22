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

    class RType{
        boolean isbs;
        int min;
        int max;

        RType(boolean b, int l, int r){
            this.isbs = b;
            this.min = l;
            this.max = r;
        }
    }

    public RType isbst(TreeNode root){
        if(root==null)return new RType(true, 1001, -1001);
        RType left = isbst(root.left);
        RType right = isbst(root.right);

        if(left.isbs==false || right.isbs==false)return new RType(false, -2000, -2000);

        if(root.val > left.max && root.val < right.min)return new RType(true, Math.min(left.min, root.val), Math.max(right.max, root.val));

        return new RType(false, -2000, -2000);

    }

    public boolean isValidBST(TreeNode root) {
        return isbst(root).isbs;
    }
}
