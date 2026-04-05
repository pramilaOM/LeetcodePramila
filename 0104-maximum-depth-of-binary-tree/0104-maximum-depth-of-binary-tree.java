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
    //https://www.youtube.com/watch?v=uCvur520ejA&t=112s
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = (root.left != null) ? maxDepth(root.left) : Integer.MIN_VALUE;
        int right = (root.right != null) ? maxDepth(root.right) : Integer.MIN_VALUE;

        return 1 + Math.max(left, right);
    }
}