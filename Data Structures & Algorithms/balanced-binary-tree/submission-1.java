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

    boolean ans = true;

    public int helper(TreeNode root){
        if(root==null)return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(right-left>1 || right-left<-1){
            ans = false;
        }

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return ans;
    }
}
