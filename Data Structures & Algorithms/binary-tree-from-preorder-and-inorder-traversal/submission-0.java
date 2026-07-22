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

    public HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int[] preorder, int[] inorder, int lpre, int rpre, int lin, int rin){
        // System.out.println("root : " + preorder[lpre]);
        
        if(lpre==1){
            System.out.println(lpre + " " + rpre + " " + lin + " " + rin);
        }

        if(lpre>rpre || lin>rin){
            // System.out.println("root : " + preorder[lpre]);
            return null;
        }
        if(lpre>=preorder.length || lpre<0) {
            // System.out.println("root : " + preorder[lpre]);
            return null;
        }

        int r = preorder[lpre];
        TreeNode root = new TreeNode(r);

        int leftlen = map.get(r) - lin;
        int rightlen = rin - map.get(r);
        System.out.println("r= " + r + " leftlen= " + leftlen + " rightlen= " + rightlen);
        root.left = build(preorder, inorder, lpre+1, lpre+leftlen, map.get(r) - leftlen, map.get(r)-1);
        root.right = build(preorder, inorder, lpre+leftlen+1, rpre, map.get(r)+1, map.get(r)+ rightlen);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
