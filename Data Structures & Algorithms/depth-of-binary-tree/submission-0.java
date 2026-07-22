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

    public int mDepth(TreeNode root){
        if(root == null)return 0;

        int lmaxdepth = mDepth(root.left);
        int rmaxdepth = mDepth(root.right);

        return 1 + Math.max(lmaxdepth, rmaxdepth);
    }

    public int maxDepth(TreeNode root) {
        return mDepth(root);
    }
}
