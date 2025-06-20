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
    TreeNode prev;

    void preorder(TreeNode curr) {
        if (curr == null)
            return;
        if (prev != null) {
            prev.left = null;
            prev.right = curr;
        }
        TreeNode r = curr.right;
        prev = curr;
        preorder(curr.left);
        preorder(r);
    }

    public void flatten(TreeNode root) {
        prev = null;
        preorder(root);

    }
}