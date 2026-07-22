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

    List<Integer> ans = new ArrayList<>();
    int currlevel = 0;

    public int helper(TreeNode root, int level){
        if(root==null)return level;

        if(level == currlevel){
            ans.add(root.val);
            currlevel+=1;
        }

        int right = helper(root.right, level+1);
        int left = helper(root.left, level+1);
        return level;
    }

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return ans;
    }
}
