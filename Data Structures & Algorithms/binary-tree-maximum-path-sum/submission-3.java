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

    int max = -1001;

    public int maxsum(TreeNode root){

        if(root==null)return -1001;

        int leftmax = maxsum(root.left);
        int rightmax = maxsum(root.right);

        max = Math.max(rightmax + leftmax + root.val, Math.max(root.val, Math.max(rightmax, Math.max(leftmax, Math.max(rightmax+root.val, Math.max(leftmax + root.val,  max))))));

        return Math.max(Math.max(root.val + leftmax, root.val + rightmax), root.val);
    }

    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return max;
    }
}
