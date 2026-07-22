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

    int max;

    public int maxpositivesumpossiblewithroot(TreeNode root){

        if(root==null)return 0;

        int leftmax = maxpositivesumpossiblewithroot(root.left);
        int rightmax = maxpositivesumpossiblewithroot(root.right);

        max = Math.max(root.val + leftmax + rightmax, max);

        return Math.max(root.val + leftmax , Math.max(root.val + rightmax, 0));
    }

    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        max = root.val;
        maxpositivesumpossiblewithroot(root);
        return max;
    }
}
